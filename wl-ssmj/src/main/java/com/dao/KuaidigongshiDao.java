package com.dao;

import com.entity.KuaidigongshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidigongshiView;

/**
 * 快递公司表 Dao 接口
 *
 * @author 
 * @since 2021-02-25
 */
public interface KuaidigongshiDao extends BaseMapper<KuaidigongshiEntity> {

   List<KuaidigongshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
