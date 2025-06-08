package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.WuliuxiangqingDao;
import com.entity.WuliuxiangqingEntity;
import com.service.WuliuxiangqingService;
import com.entity.view.WuliuxiangqingView;

/**
 * 物流详情 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("wuliuxiangqingService")
@Transactional
public class WuliuxiangqingServiceImpl extends ServiceImpl<WuliuxiangqingDao, WuliuxiangqingEntity> implements WuliuxiangqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<WuliuxiangqingView> page =new Query<WuliuxiangqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
