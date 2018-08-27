package com.ctrl.education.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统反馈
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@TableName("qz_app_feedback")
public class QzAppFeedback extends Model<QzAppFeedback> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 反馈内容
     */
    private String content;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 是否处理 0 否 1是
     */
    @TableField("is_suc")
    private Integer isSuc;
    /**
     * 用户ID(没有为匿名)
     */
    @TableField("user_id")
    private String userId;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 处理方式和结果
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getIsSuc() {
        return isSuc;
    }

    public void setIsSuc(Integer isSuc) {
        this.isSuc = isSuc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzAppFeedback{" +
        "id=" + id +
        ", content=" + content +
        ", createtime=" + createtime +
        ", isSuc=" + isSuc +
        ", userId=" + userId +
        ", account=" + account +
        ", remark=" + remark +
        "}";
    }
}
