package com.ctrl.education.dto;

public class SysUserOfficeDto {


    /**
     * 主键
     */
    private String id;

    /**
     * 所属机构
     */
    private String officeId;
    /**
     * 所属部门
     */
    private String deptId;
    /**
     * 是否主任职 0:否 1：是
     */
    private Integer isDirector;
    /**
     * 职务
     */
    private String job;
    /**
     * 岗位类别
     */
    private String postId;
    /**
     * 级别
     */
    private String gradeId;
    private String deptName;
    private String officeName;
    private String gradeName;
    private String postName;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SysUserOfficeDto{" +
                "id='" + id + '\'' +
                ", officeId='" + officeId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", isDirector=" + isDirector +
                ", job='" + job + '\'' +
                ", postId='" + postId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", officeName='" + officeName + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
