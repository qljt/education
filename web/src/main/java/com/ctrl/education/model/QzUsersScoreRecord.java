package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户积分记录
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@TableName("qz_users_score_record")
public class QzUsersScoreRecord extends Model<QzUsersScoreRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 用户ID
     */
    @TableField("users_id")
    private String usersId;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 部门ID
     */
    @TableField("depart_id")
    private String departId;
    /**
     * 部门名称
     */
    @TableField("depart_name")
    private String departName;
    /**
     * 获取之前积分
     */
    @TableField("score_ahead")
    private Integer scoreAhead;
    /**
     * 获取之后积分
     */
    @TableField("score_after")
    private Integer scoreAfter;
    /**
     * 积分变换值（增加正数，减少负数）
     */
    private Integer score;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 积分类型  0登录次数 1登录时长 2完善个人信息 3评价课件 4共享课件 5考试通过 6发现问题 7提交文章 8兑换商品
     */
    private Integer type;
    /**
     * 相关对象ID（评价ID、共享课程ID、兑换商品ID等）
     */
    @TableField("object_id")
    private String objectId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getScoreAhead() {
        return scoreAhead;
    }

    public void setScoreAhead(Integer scoreAhead) {
        this.scoreAhead = scoreAhead;
    }

    public Integer getScoreAfter() {
        return scoreAfter;
    }

    public void setScoreAfter(Integer scoreAfter) {
        this.scoreAfter = scoreAfter;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzUsersScoreRecord{" +
        "id=" + id +
        ", usersId=" + usersId +
        ", account=" + account +
        ", phone=" + phone +
        ", name=" + name +
        ", departId=" + departId +
        ", departName=" + departName +
        ", scoreAhead=" + scoreAhead +
        ", scoreAfter=" + scoreAfter +
        ", score=" + score +
        ", createtime=" + createtime +
        ", type=" + type +
        ", objectId=" + objectId +
        "}";
    }
}
