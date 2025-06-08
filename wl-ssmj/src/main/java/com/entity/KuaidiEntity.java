package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 快递表
 *
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("kuaidi")
public class KuaidiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuaidiEntity() {

	}

	public KuaidiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 快递单号 Search
     */
    @TableField(value = "serial")
    private String serial;


    /**
     * 快递名称 Search
     */
    @TableField(value = "vehicle")
    private String vehicle;


    /**
     * 发货地址
     */
    @TableField(value = "ship")
    private String ship;


    /**
     * 发件人
     */
    @TableField(value = "shipr")
    private String shipr;


    /**
     * 收货地址
     */
    @TableField(value = "take")
    private String take;


    /**
     * 收件人
     */
    @TableField(value = "taker")
    private String taker;


    /**
     * 快递公司 Search
     */
    @TableField(value = "kd_types")
    private Integer kdTypes;


    /**
     * 快递状态 Search
     */
    @TableField(value = "kdzt_types")
    private Integer kdztTypes;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：快递单号 Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：快递单号 Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：快递名称 Search
	 */
    public String getVehicle() {
        return vehicle;
    }


    /**
	 * 获取：快递名称 Search
	 */

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    /**
	 * 设置：发货地址
	 */
    public String getShip() {
        return ship;
    }


    /**
	 * 获取：发货地址
	 */

    public void setShip(String ship) {
        this.ship = ship;
    }
    /**
	 * 设置：发件人
	 */
    public String getShipr() {
        return shipr;
    }


    /**
	 * 获取：发件人
	 */

    public void setShipr(String shipr) {
        this.shipr = shipr;
    }
    /**
	 * 设置：收货地址
	 */
    public String getTake() {
        return take;
    }


    /**
	 * 获取：收货地址
	 */

    public void setTake(String take) {
        this.take = take;
    }
    /**
	 * 设置：收件人
	 */
    public String getTaker() {
        return taker;
    }


    /**
	 * 获取：收件人
	 */

    public void setTaker(String taker) {
        this.taker = taker;
    }
    /**
	 * 设置：快递公司 Search
	 */
    public Integer getKdTypes() {
        return kdTypes;
    }


    /**
	 * 获取：快递公司 Search
	 */

    public void setKdTypes(Integer kdTypes) {
        this.kdTypes = kdTypes;
    }
    /**
	 * 设置：快递状态 Search
	 */
    public Integer getKdztTypes() {
        return kdztTypes;
    }


    /**
	 * 获取：快递状态 Search
	 */

    public void setKdztTypes(Integer kdztTypes) {
        this.kdztTypes = kdztTypes;
    }

}
