package com.dao;

import com.entity.KuaidixiangqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidixiangqingView;

/**
 * 快递详情 Dao 接口
 *
 * @author 
 * @since 2021-02-25
 */
public interface KuaidixiangqingDao extends BaseMapper<KuaidixiangqingEntity> {

   List<KuaidixiangqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
