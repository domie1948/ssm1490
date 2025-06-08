package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuliugongshiEntity;
import java.util.Map;

/**
 * 物流公司表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface WuliugongshiService extends IService<WuliugongshiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}