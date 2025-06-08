package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.KuaidiEntity;
import com.service.KuaidiService;
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

import com.entity.KuaidixiangqingEntity;

import com.service.KuaidixiangqingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递详情
 * 后端接口
 * @author
 * @email
 * @date 2021-02-25
*/
@RestController
@Controller
@RequestMapping("/kuaidixiangqing")
public class KuaidixiangqingController {
    private static final Logger logger = LoggerFactory.getLogger(KuaidixiangqingController.class);

    @Autowired
    private KuaidixiangqingService kuaidixiangqingService;

    @Autowired
    private KuaidiService kuaidiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kuaidixiangqingService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KuaidixiangqingEntity kuaidixiangqing = kuaidixiangqingService.selectById(id);
        if(kuaidixiangqing!=null){
            return R.ok().put("data", kuaidixiangqing);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidixiangqingEntity kuaidixiangqing, HttpServletRequest request){
        KuaidiEntity serial = kuaidiService.selectOne(new EntityWrapper().eq("serial", kuaidixiangqing.getSerial()));
        if(serial != null){
            logger.debug("Controller:" + this.getClass().getName() + ",save");
            Wrapper<KuaidixiangqingEntity> queryWrapper = new EntityWrapper<KuaidixiangqingEntity>()
                    .eq("serial", kuaidixiangqing.getSerial())
                    .eq("notice_content", kuaidixiangqing.getNoticeContent())
                    ;
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            KuaidixiangqingEntity kuaidixiangqingEntity = kuaidixiangqingService.selectOne(queryWrapper);
            if(kuaidixiangqingEntity==null){
                kuaidixiangqingService.insert(kuaidixiangqing);
                return R.ok();
            }else {
                return R.error(511,"表中有相同数据");
            }
        }else{
            return R.error(511,"该快递单号不存在");
        }

    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuaidixiangqingEntity kuaidixiangqing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        KuaidiEntity serial = kuaidiService.selectOne(new EntityWrapper().eq("serial", kuaidixiangqing.getSerial()));
        if(serial != null){
                //根据字段查询是否有相同数据
        Wrapper<KuaidixiangqingEntity> queryWrapper = new EntityWrapper<KuaidixiangqingEntity>()
            .notIn("id",kuaidixiangqing.getId())
            .eq("serial", kuaidixiangqing.getSerial())
            .eq("notice_content", kuaidixiangqing.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidixiangqingEntity kuaidixiangqingEntity = kuaidixiangqingService.selectOne(queryWrapper);
        if(kuaidixiangqingEntity==null){
            kuaidixiangqingService.updateById(kuaidixiangqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
        }else{
            return R.error(511,"该快递单号不存在");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        kuaidixiangqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

