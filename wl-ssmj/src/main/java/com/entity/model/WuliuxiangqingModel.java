package com.entity.model;

import com.entity.WuliuxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物流详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-25
 */
public class WuliuxiangqingModel implements Serializable {
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
     * 详情信息
     */
    private String noticeContent;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
	 * 设置：详情信息
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    /**
	 * 设置：时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
