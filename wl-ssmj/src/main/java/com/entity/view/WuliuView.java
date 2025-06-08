package com.entity.view;

import com.entity.WuliuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 物流表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("wuliu")
public class WuliuView extends WuliuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public WuliuView() {

	}

	public WuliuView(WuliuEntity wuliuEntity) {
		try {
			BeanUtils.copyProperties(this, wuliuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
