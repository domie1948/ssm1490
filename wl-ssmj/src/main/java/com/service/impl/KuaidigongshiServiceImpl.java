package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KuaidigongshiDao;
import com.entity.KuaidigongshiEntity;
import com.service.KuaidigongshiService;
import com.entity.view.KuaidigongshiView;

/**
 * 快递公司表 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("kuaidigongshiService")
@Transactional
public class KuaidigongshiServiceImpl extends ServiceImpl<KuaidigongshiDao, KuaidigongshiEntity> implements KuaidigongshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KuaidigongshiView> page =new Query<KuaidigongshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
