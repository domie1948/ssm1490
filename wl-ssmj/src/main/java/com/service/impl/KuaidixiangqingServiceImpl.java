package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KuaidixiangqingDao;
import com.entity.KuaidixiangqingEntity;
import com.service.KuaidixiangqingService;
import com.entity.view.KuaidixiangqingView;

/**
 * 快递详情 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("kuaidixiangqingService")
@Transactional
public class KuaidixiangqingServiceImpl extends ServiceImpl<KuaidixiangqingDao, KuaidixiangqingEntity> implements KuaidixiangqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KuaidixiangqingView> page =new Query<KuaidixiangqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
