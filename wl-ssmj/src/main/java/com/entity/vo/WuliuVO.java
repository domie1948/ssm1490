package com.entity.vo;

import com.entity.WuliuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物流表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-25
 */
@TableName("wuliu")
public class WuliuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 物流单号 Search
     */

    @TableField(value = "serial")
    private String serial;


    /**
     * 运送车辆 Search
     */

    @TableField(value = "vehicle")
    private String vehicle;


    /**
     * 发货地址
     */

    @TableField(value = "ship")
    private String ship;


    /**
     * 收货地址
     */

    @TableField(value = "take")
    private String take;


    /**
     * 物流公司 Search
     */

    @TableField(value = "wl_types")
    private Integer wlTypes;


    /**
     * 物流状态 Search
     */

    @TableField(value = "wlzt_types")
    private Integer wlztTypes;


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
	 * 设置：物流单号 Search
	 */
    public String getSerial() {
        return serial;
    }


    /**
	 * 获取：物流单号 Search
	 */

    public void setSerial(String serial) {
        this.serial = serial;
    }
    /**
	 * 设置：运送车辆 Search
	 */
    public String getVehicle() {
        return vehicle;
    }


    /**
	 * 获取：运送车辆 Search
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
	 * 设置：物流公司 Search
	 */
    public Integer getWlTypes() {
        return wlTypes;
    }


    /**
	 * 获取：物流公司 Search
	 */

    public void setWlTypes(Integer wlTypes) {
        this.wlTypes = wlTypes;
    }
    /**
	 * 设置：物流状态 Search
	 */
    public Integer getWlztTypes() {
        return wlztTypes;
    }


    /**
	 * 获取：物流状态 Search
	 */

    public void setWlztTypes(Integer wlztTypes) {
        this.wlztTypes = wlztTypes;
    }

}
