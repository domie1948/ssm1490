package com.entity.view;

import com.entity.WuliuxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 物流详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("wuliuxiangqing")
public class WuliuxiangqingView extends WuliuxiangqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public WuliuxiangqingView() {

	}

	public WuliuxiangqingView(WuliuxiangqingEntity wuliuxiangqingEntity) {
		try {
			BeanUtils.copyProperties(this, wuliuxiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
