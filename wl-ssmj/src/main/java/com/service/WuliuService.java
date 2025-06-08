package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuliuEntity;
import java.util.Map;

/**
 * 物流表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface WuliuService extends IService<WuliuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}