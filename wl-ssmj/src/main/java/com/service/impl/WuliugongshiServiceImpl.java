package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.WuliugongshiDao;
import com.entity.WuliugongshiEntity;
import com.service.WuliugongshiService;
import com.entity.view.WuliugongshiView;

/**
 * 物流公司表 服务实现类
 * @author 
 * @since 2021-02-25
 */
@Service("wuliugongshiService")
@Transactional
public class WuliugongshiServiceImpl extends ServiceImpl<WuliugongshiDao, WuliugongshiEntity> implements WuliugongshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<WuliugongshiView> page =new Query<WuliugongshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
