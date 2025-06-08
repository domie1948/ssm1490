package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.WuliuEntity;
import com.service.WuliuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.WuliuxiangqingEntity;

import com.service.WuliuxiangqingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 物流详情
 * 后端接口
 * @author
 * @email
 * @date 2021-02-25
*/
@RestController
@Controller
@RequestMapping("/wuliuxiangqing")
public class WuliuxiangqingController {
    private static final Logger logger = LoggerFactory.getLogger(WuliuxiangqingController.class);

    @Autowired
    private WuliuxiangqingService wuliuxiangqingService;

    @Autowired
    private WuliuService wuliuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = wuliuxiangqingService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        WuliuxiangqingEntity wuliuxiangqing = wuliuxiangqingService.selectById(id);
        if(wuliuxiangqing!=null){
            return R.ok().put("data", wuliuxiangqing);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuliuxiangqingEntity wuliuxiangqing, HttpServletRequest request){
        WuliuEntity serial = wuliuService.selectOne(new EntityWrapper().eq("serial", wuliuxiangqing.getSerial()));
        if(serial != null){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<WuliuxiangqingEntity> queryWrapper = new EntityWrapper<WuliuxiangqingEntity>()
            .eq("serial", wuliuxiangqing.getSerial())
            .eq("notice_content", wuliuxiangqing.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliuxiangqingEntity wuliuxiangqingEntity = wuliuxiangqingService.selectOne(queryWrapper);
        if(wuliuxiangqingEntity==null){
            wuliuxiangqingService.insert(wuliuxiangqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
        }else{
            return R.error(511,"该物流单号不存在");
        }

    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuliuxiangqingEntity wuliuxiangqing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        WuliuEntity serial = wuliuService.selectOne(new EntityWrapper().eq("serial", wuliuxiangqing.getSerial()));
        if(serial != null){
            //根据字段查询是否有相同数据
            Wrapper<WuliuxiangqingEntity> queryWrapper = new EntityWrapper<WuliuxiangqingEntity>()
                .notIn("id",wuliuxiangqing.getId())
                .eq("serial", wuliuxiangqing.getSerial())
                .eq("notice_content", wuliuxiangqing.getNoticeContent())
                ;
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            WuliuxiangqingEntity wuliuxiangqingEntity = wuliuxiangqingService.selectOne(queryWrapper);
            if(wuliuxiangqingEntity==null){
                wuliuxiangqingService.updateById(wuliuxiangqing);//根据id更新
                return R.ok();
            }else {
                return R.error(511,"表中有相同数据");
        }
        }else{
            return R.error(511,"该物流单号不存在");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        wuliuxiangqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

