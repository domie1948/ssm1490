package com.entity.model;

import com.entity.WuliuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物流表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-25
 */
public class WuliuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物流单号 Search
     */
    private String serial;


    /**
     * 运送车辆 Search
     */
    private String vehicle;


    /**
     * 发货地址
     */
    private String ship;


    /**
     * 收货地址
     */
    private String take;


    /**
     * 物流公司 Search
     */
    private Integer wlTypes;


    /**
     * 物流状态 Search
     */
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
