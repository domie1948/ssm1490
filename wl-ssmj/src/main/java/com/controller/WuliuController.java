package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

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

import com.entity.WuliuEntity;

import com.service.WuliuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 物流表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-25
*/
@RestController
@Controller
@RequestMapping("/wuliu")
public class WuliuController {
    private static final Logger logger = LoggerFactory.getLogger(WuliuController.class);

    @Autowired
    private WuliuService wuliuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = wuliuService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        WuliuEntity wuliu = wuliuService.selectById(id);
        if(wuliu!=null){
            return R.ok().put("data", wuliu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuliuEntity wuliu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<WuliuEntity> queryWrapper = new EntityWrapper<WuliuEntity>()
            .eq("serial", wuliu.getSerial())
            .eq("vehicle", wuliu.getVehicle())
            .eq("ship", wuliu.getShip())
            .eq("take", wuliu.getTake())
            .eq("wl_types", wuliu.getWlTypes())
            .eq("wlzt_types", wuliu.getWlztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliuEntity wuliuEntity = wuliuService.selectOne(queryWrapper);
        if(wuliuEntity==null){
            wuliu.setWlztTypes(2);
            wuliuService.insert(wuliu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuliuEntity wuliu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<WuliuEntity> queryWrapper = new EntityWrapper<WuliuEntity>()
            .notIn("id",wuliu.getId())
            .eq("serial", wuliu.getSerial())
            .eq("vehicle", wuliu.getVehicle())
            .eq("ship", wuliu.getShip())
            .eq("take", wuliu.getTake())
            .eq("wl_types", wuliu.getWlTypes())
            .eq("wlzt_types", wuliu.getWlztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuliuEntity wuliuEntity = wuliuService.selectOne(queryWrapper);
        if(wuliuEntity==null){
            wuliuService.updateById(wuliu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 改状态为运输中
     */
    @RequestMapping("/transport")
    public R transport(@RequestBody Integer ids){
        WuliuEntity wuliuEntity = wuliuService.selectById(ids);
        if(wuliuEntity != null){
            if(wuliuEntity.getWlztTypes()==1){
                return R.error("状态已经是运输中了，请不要重复修改");
            }else if(wuliuEntity.getWlztTypes()==3){
                return R.error("货物已经签收了，请不要重复点击按钮");
            }else{
                wuliuEntity.setWlztTypes(1);
                wuliuService.updateById(wuliuEntity);
                return R.ok();
            }
        }else{
            return R.error();
        }
    }

    /**
     * 改状态为已签收
     */
    @RequestMapping("/haveBeenSigned")
    public R haveBeenSigned(@RequestBody Integer ids){
        WuliuEntity wuliuEntity = wuliuService.selectById(ids);
        if(wuliuEntity != null){
            if(wuliuEntity.getWlztTypes()==3){
                return R.error("货物已经签收了，请不要重复点击按钮");
            }else if(wuliuEntity.getWlztTypes()==2){
                return R.error("货物还未发货，请不要重复点击按钮");
            }else{
                wuliuEntity.setWlztTypes(3);
                wuliuService.updateById(wuliuEntity);
                return R.ok();
            }
        }else{
            return R.error();
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        wuliuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

