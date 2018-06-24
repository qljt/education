package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
@TableName("sys_log")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 日志类型 1-登录 2-访问 3-操作 4-异常 5-授权
     */
    private Integer type;
    /**
     * 操作用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 操作用户名
     */
    private String username;
    /**
     * 用户操作
     */
    private String operation;
    /**
     * 调用方法
     */
    private String method;
    /**
     * 参数
     */
    private String params;
    /**
     * 操作ip地址
     */
    private String ip;
    /**
     * 操作结果 1-成功 2-失败
     */
    private Integer result;
    /**
     * 操作描述
     */
    private String remark;
    /**
     * 操作时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", type=" + type +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", ip='" + ip + '\'' +
                ", result=" + result +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
