package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuaidigongshiEntity;
import java.util.Map;

/**
 * 快递公司表 服务类
 * @author 
 * @since 2021-02-25
 */
public interface KuaidigongshiService extends IService<KuaidigongshiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}