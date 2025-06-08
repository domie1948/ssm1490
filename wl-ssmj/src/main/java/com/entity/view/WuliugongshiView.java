package com.entity.view;

import com.entity.WuliugongshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 物流公司表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("wuliugongshi")
public class WuliugongshiView extends WuliugongshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public WuliugongshiView() {

	}

	public WuliugongshiView(WuliugongshiEntity wuliugongshiEntity) {
		try {
			BeanUtils.copyProperties(this, wuliugongshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
