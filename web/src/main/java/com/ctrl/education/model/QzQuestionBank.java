package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * com.ctrl.education.model
 * 题库
 *
 * @author liyang
 * @name QzPaperQuestionType
 * @description
 * @date 2018-08-13 11:00
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_question_bank")
public class QzQuestionBank extends Model<QzQuestionBank> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 编码
     */
    @TableField(value = "code")
    @NotNull(message = "编码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 100, message = "编码长度为1-100。", groups = {AddGroup.class, UpdateGroup.class})
    private String code;
    /**
     * 题库名称
     */
    @TableField(value = "name")
    @NotNull(message = "题库名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 100, message = "题库名称长度为1-100。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 题库类别 0考试题库 1调查问卷
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 父节点ID
     */
    @TableField(value = "parent_id")
    private Integer parentId;
    /**
     * 是否有子节点 0否 1是
     */
    @TableField(value = "is_child")
    private Integer isChild;
    /**
     * 状态 0删除 1正常
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 排序
     */
    @TableField(value = "sort")
    private Double sort;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private String createtime;
    /**
     * 拼音
     */
    @TableField(value = "spell")
    private Double spell;
    /**
     * 编辑用户
     */
    @TableField(value = "sys_user_id")
    private String sysUserId;
    /**
     * 机构ID
     */
    @TableField(value = "office_id")
    private String officeId;
    /**
     * 是否允许练习 0否 1是
     */
    @TableField(value = "is_practice")
    private Integer isPractice;
    /**
     * 编辑权限 0 私人 1本层机构 2本角色人员
     */
    @TableField(value = "edit_permissions")
    private Integer editPermissions;
    /**
     * 共享给管理员的范围 0本级机构所有管理员 1本级及下级所有管理员、所有机构管理员2本级及下级本角色管理员3所有机构本角色管理员
     */
    @TableField(value = "share_admin")
    private Integer shareAdmin;
    /**
     * 学员使用范围—是否指派学员可见范围 0或空不指派，1为指派，若为指派，则需要维护指派的范围，2对内外所人员公开，3、对内所有机构人员公开，若不指派默认均不可见
     */
    @TableField(value = "use_student")
    private Integer useStudent;
    /**
     * 专业ID
     */
    @TableField(value = "major_id")
    private String majorId;

    public String getId() {
        return id;
    }

    public QzQuestionBank setId(String id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public QzQuestionBank setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public QzQuestionBank setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public QzQuestionBank setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public QzQuestionBank setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getIsChild() {
        return isChild;
    }

    public QzQuestionBank setIsChild(Integer isChild) {
        this.isChild = isChild;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzQuestionBank setState(Integer state) {
        this.state = state;
        return this;
    }

    public Double getSort() {
        return sort;
    }

    public QzQuestionBank setSort(Double sort) {
        this.sort = sort;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzQuestionBank setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public Double getSpell() {
        return spell;
    }

    public QzQuestionBank setSpell(Double spell) {
        this.spell = spell;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzQuestionBank setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    public String getOfficeId() {
        return officeId;
    }

    public QzQuestionBank setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
    }

    public Integer getIsPractice() {
        return isPractice;
    }

    public QzQuestionBank setIsPractice(Integer isPractice) {
        this.isPractice = isPractice;
        return this;
    }

    public Integer getEditPermissions() {
        return editPermissions;
    }

    public QzQuestionBank setEditPermissions(Integer editPermissions) {
        this.editPermissions = editPermissions;
        return this;
    }

    public Integer getShareAdmin() {
        return shareAdmin;
    }

    public QzQuestionBank setShareAdmin(Integer shareAdmin) {
        this.shareAdmin = shareAdmin;
        return this;
    }

    public Integer getUseStudent() {
        return useStudent;
    }

    public QzQuestionBank setUseStudent(Integer useStudent) {
        this.useStudent = useStudent;
        return this;
    }

    public String getMajorId() {
        return majorId;
    }

    public QzQuestionBank setMajorId(String majorId) {
        this.majorId = majorId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzQuestionBank{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", parentId=" + parentId +
                ", isChild='" + isChild + '\'' +
                ", state=" + state +
                ", sort=" + sort +
                ", createtime=" + createtime +
                ", spell=" + spell +
                ", sysUserId=" + sysUserId +
                ", officeId='" + officeId + '\'' +
                ", isPractice=" + isPractice +
                ", editPermissions=" + editPermissions +
                ", shareAdmin=" + shareAdmin +
                ", useStudent=" + useStudent +
                ", majorId='" + majorId + '\'' +
                '}';
    }
}
