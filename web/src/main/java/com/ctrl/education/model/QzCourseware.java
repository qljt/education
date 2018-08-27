package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@TableName("qz_courseware")
public class QzCourseware extends Model<QzCourseware> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 课程名称
     */
    @TableField("cou_name")
    private String couName;

    /**
     * 类型ID
     */
    @TableField("type_id")
    private String typeId;

    /**
     * 讲师ID数组，逗号隔开
     */
    @TableField("tea_ids")
    private String teaIds;

    /**
     * 部门ID数组，逗号隔开
     */
    @TableField("depart_ids")
    private String departIds;

    /**
     * 培训人员ID数组，逗号隔开
     */
    @TableField("users_ids")
    private String usersIds;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 公开范围 0个人私有 1部门内部 2所有部门
     */
    @TableField("public_scope")
    private Integer publicScope;

    /**
     * 封面图片
     */
    @TableField("image")
    private String image;

    /**
     * 简介
     */
    @TableField("content")
    private String content;

    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;

    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;

    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    /**
     * 创建时间
     */
    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public QzCourseware setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getId() {
        return id;
    }

    public QzCourseware setId(String id) {
        this.id = id;
        return this;
    }

    public String getCouName() {
        return couName;
    }

    public QzCourseware setCouName(String couName) {
        this.couName = couName;
        return this;
    }

    public String getTypeId() {
        return typeId;
    }

    public QzCourseware setTypeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getTeaIds() {
        return teaIds;
    }

    public QzCourseware setTeaIds(String teaIds) {
        this.teaIds = teaIds;
        return this;
    }

    public String getDepartIds() {
        return departIds;
    }

    public QzCourseware setDepartIds(String departIds) {
        this.departIds = departIds;
        return this;
    }

    public String getUsersIds() {
        return usersIds;
    }

    public QzCourseware setUsersIds(String usersIds) {
        this.usersIds = usersIds;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public QzCourseware setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public QzCourseware setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getPublicScope() {
        return publicScope;
    }

    public QzCourseware setPublicScope(Integer publicScope) {
        this.publicScope = publicScope;
        return this;
    }

    public String getImage() {
        return image;
    }

    public QzCourseware setImage(String image) {
        this.image = image;
        return this;
    }

    public String getContent() {
        return content;
    }

    public QzCourseware setContent(String content) {
        this.content = content;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzCourseware setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzCourseware setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzCourseware setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzCourseware{" +
                "id='" + id + '\'' +
                ", couName='" + couName + '\'' +
                ", typeId='" + typeId + '\'' +
                ", teaIds='" + teaIds + '\'' +
                ", departIds='" + departIds + '\'' +
                ", usersIds='" + usersIds + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", publicScope=" + publicScope +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", sysCode='" + sysCode + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
