package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 单位人员关联表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-03
 */
@TableName("sys_user_office")
public class SysUserOffice extends Model<SysUserOffice> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 系统用户id
     */
    @NotNull(message = "用户主键不可为空",groups = {AddGroup.class,UpdateGroup.class})
    @TableId(value = "sys_user_id", type = IdType.UUID)
    private String sysUserId;
    /**
     * 所属机构
     */
    @TableField("office_id")
    private String officeId;
    /**
     * 所属部门
     */
    @TableField("dept_id")
    private String deptId;
    /**
     * 是否主任职 0:否 1：是
     */
    @TableField("is_director")
    private Integer isDirector;
    /**
     * 职务
     */
    private String job;
    /**
     * 岗位类别
     */
    @TableField("post_id")
    private String postId;
    /**
     * 级别
     */
    @TableField("grade_id")
    private String gradeId;
    /**
     * 排序
     */
    private Integer sort;


    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getIsDirector() {
        return isDirector;
    }

    public void setIsDirector(Integer isDirector) {
        this.isDirector = isDirector;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.sysUserId;
    }

    @Override
    public String toString() {
        return "SysUserOffice{" +
        "sysUserId=" + sysUserId +
        ", officeId=" + officeId +
        ", deptId=" + deptId +
        ", isDirector=" + isDirector +
        ", job=" + job +
        ", postId=" + postId +
        ", gradeId=" + gradeId +
        ", sort=" + sort +
        "}";
    }
}
