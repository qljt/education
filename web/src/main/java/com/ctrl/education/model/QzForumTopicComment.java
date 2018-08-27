package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.sql.Blob;

/**
 * <p>
 * 话题评论列表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@TableName("qz_forum_topic_comment")
public class QzForumTopicComment extends Model<QzForumTopicComment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 话题ID
     */
    @TableField("topic_id")
    private String topicId;
    /**
     * 用户ID
     */
    @TableField("users_id")
    private String usersId;
    /**
     * 评论内容
     */
    private Blob content;
    /**
     * 评论时间
     */
    private String createtime;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzForumTopicComment{" +
        "id=" + id +
        ", topicId=" + topicId +
        ", usersId=" + usersId +
        ", content=" + content +
        ", createtime=" + createtime +
        ", state=" + state +
        ", appreciateNum=" + appreciateNum +
        ", commentNum=" + commentNum +
        "}";
    }
}
