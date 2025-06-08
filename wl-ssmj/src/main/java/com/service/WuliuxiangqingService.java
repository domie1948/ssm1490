package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuliuxiangqingEntity;
import java.util.Map;

/**
 * 物流详情 服务类
 * @author 
 * @since 2021-02-25
 */
public interface WuliuxiangqingService extends IService<WuliuxiangqingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}