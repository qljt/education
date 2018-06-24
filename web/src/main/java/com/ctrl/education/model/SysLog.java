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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
    private Long userId;
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

}
