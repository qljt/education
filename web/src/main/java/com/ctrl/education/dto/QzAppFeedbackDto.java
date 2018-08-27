package com.ctrl.education.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * com.ctrl.education.dto
 *
 * @author ctrl
 * @name QzAppFeedbackDto
 * @description
 * @date 2018-08-10 上午9:19
 */
public class QzAppFeedbackDto {
    private static final long serialVersionUID = 1L;

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
    private Integer isSuc;
    /**
     * 用户ID(没有为匿名)
     */
    private String userId;
    /**
     * 处理方式和结果
     */
    private String remark;

    /**
     * 用户名
     */
    private String account;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "QzAppFeedbackDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", isSuc=" + isSuc +
                ", userId='" + userId + '\'' +
                ", remark='" + remark + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
