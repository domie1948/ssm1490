package com.dao;

import com.entity.WuliugongshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuliugongshiView;

/**
 * 物流公司表 Dao 接口
 *
 * @author 
 * @since 2021-02-25
 */
public interface WuliugongshiDao extends BaseMapper<WuliugongshiEntity> {

   List<WuliugongshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
