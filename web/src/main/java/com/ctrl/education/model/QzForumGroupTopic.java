package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Blob;

/**
 * <p>
 * 小组话题
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@TableName("qz_forum_group_topic")
public class QzForumGroupTopic extends Model<QzForumGroupTopic> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 小组ID
     */
    @TableField("group_id")
    private String groupId;
    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;
    /**
     * 话题内容
     */
    @TableField("content")
    private String  content;
    /**
     * 浏览总量
     */
    @TableField("brow_num")
    private Integer browNum;
    /**
     * 点赞总量
     */
    @TableField("appreciate_num")
    private Integer appreciateNum;
    /**
     * 评论总量
     */
    @TableField("comment_num")
    private Integer commentNum;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 是否置顶 0否 1是
     */
    @TableField("is_top")
    private Integer isTop;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 话题标题
     */
    private String title;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 审核状态 0未审核 1通过2未通过
     */
    private Integer status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String  getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBrowNum() {
        return browNum;
    }

    public void setBrowNum(Integer browNum) {
        this.browNum = browNum;
    }

    public Integer getAppreciateNum() {
        return appreciateNum;
    }

    public void setAppreciateNum(Integer appreciateNum) {
        this.appreciateNum = appreciateNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzForumGroupTopic{" +
        "id=" + id +
        ", groupId=" + groupId +
        ", userId=" + userId +
        ", content=" + content +
        ", browNum=" + browNum +
        ", appreciateNum=" + appreciateNum +
        ", commentNum=" + commentNum +
        ", sort=" + sort +
        ", isTop=" + isTop +
        ", createtime=" + createtime +
        ", title=" + title +
        ", sysCode=" + sysCode +
        ", status=" + status +
        "}";
    }
}
