package com.entity.view;

import com.entity.KuaidigongshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 快递公司表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("kuaidigongshi")
public class KuaidigongshiView extends KuaidigongshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KuaidigongshiView() {

	}

	public KuaidigongshiView(KuaidigongshiEntity kuaidigongshiEntity) {
		try {
			BeanUtils.copyProperties(this, kuaidigongshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
