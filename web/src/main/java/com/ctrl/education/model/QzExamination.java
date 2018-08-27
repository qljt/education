package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import javax.xml.soap.Text;
import java.io.Serializable;

/**
 * com.ctrl.education.model
 *
 * @author liyang
 * @name QzExamination
 * @description
 * @date 2018-08-10 16:12
 * <p>
 * <p>
 * Copyright (c) 2018 山东安合信达电子科技有限公司 版权所有
 * shandong aloha CO.,LTD. All Rights Reserved.
 */
@TableName("qz_examination")
public class QzExamination extends Model<QzExamination> {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 专业ID
     */
    @TableField(value = "major_id")
    private String majorId;
    /**
     * 试卷ID
     */
    @TableField(value = "paper_id")
    private String paperId;
    /**
     * 试卷名称
     */
    @TableField(value = "paper_name")
    private String paperName;
    /**
     * 阅卷老师ID数组
     */
    @TableField(value = "teacher_id")
    private String teacherId;
    /**
     * 参考部门ID
     */
    @TableField(value = "depart_id")
    private String departId;
    /**
     * 参考人员ID
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 阅卷老师真实姓名
     */
    @TableField(value = "teacher_name")
    private String teacherName;
    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    private String startTime;
    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    private String endTime;
    /**
     * 状态 0未发布 1进行中 2已结束
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 考试时长(秒)
     */
    @TableField(value = "sweep_time")
    private Integer sweepTime;
    /**
     * 创建人ID
     */
    @TableField(value = "sys_user_id")
    private String sysUserId;
    /**
     * 创建机构ID
     */
    @TableField(value = "office_id")
    private String officeId;
    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private String createtime;
    /**
     * 最后编辑时间
     */
    @TableField(value = "last_update_time")
    private String lastUpdateTime;
    /**
     * 编辑权限 0 私人 1本层机构 2本角色人员
     */
    @TableField(value = "edit_permissions")
    private Integer editPermissions;
    /**
     * 是否指派 0或空不指派，1为指派，若为指派，则需要维护指派的范围，2对内外所人员公开，3、对内所有机构人员公开
     */
    @TableField(value = "is_assign")
    private Integer isAssign;
    /**
     * 是否接受报名 0或空为不接受，1为接受，若为1则需要指定可报名人员的条件；一个考试可同时指派人员和接收报名
     */
    @TableField(value = "is_rec_reg")
    private Integer isRecReg;
    /**
     * 接受报名时的指定条件
     */
    @TableField(value = "rec_reg_next")
    private String recRegNext;
    /**
     * 发布考试类型 0马上显示1考试当天显示
     */
    @TableField(value = "show_type")
    private Integer showType;
    /**
     * 启用30分钟内禁止交卷 0不启用 1启用
     */
    @TableField(value = "submit_limit")
    private Integer submitLimit;
    /**
     * 允许考生查看考试成绩 0不允许 1允许
     */
    @TableField(value = "show_result")
    private Integer showResult;
    /**
     * 允许考生查看答卷 0不允许 1允许
     */
    @TableField(value = "sele_limit")
    private Integer seleLimit;
    /**
     * 允许考生参考次数
     */
    @TableField(value = "plan_limit")
    private Integer planLimit;
    /**
     * 是否发送短信给考生 0否 1是
     */
    @TableField(value = "send_msg")
    private Integer sendMsg;
    /**
     * 阅卷老师的平均分
     */
    @TableField(value = "nmks")
    private Double nmks;
    /**
     * 积分
     */
    @TableField(value = "jifen")
    private Integer jifen;
    /**
     * 是否填空题自动评卷0否 1是
     */
    @TableField(value = "is_auto_tian_kong")
    private Integer isAutoTianKong;
    /**
     * 主观题多人手工评卷 0否 1 是
     */
    @TableField(value = "is_zhu_guan")
    private String isZhuGuan;
    /**
     * 是否显示考试须知 0否 1是
     */
    @TableField(value = "show_notes")
    private Integer showNotes;
    /**
     * 是否自定义考试须知0否 1是
     */
    @TableField(value = "is_custom_notes")
    private Integer isCustomNotes;
    /**
     * 自定义考试须知
     */
    @TableField(value = "custom_notes")
    private String customNotes;
    /**
     * 考试类别 （字典表）
     */
    @TableField(value = "type")
    private String type;
    /**
     * 是否允许模拟 0否 1是
     */
    @TableField(value = "is_simulation")
    private Integer isSimulation;
    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
    /**
     * 手机安全码
     */
    @TableField(value = "app_code")
    private String appCode;

    public String getId() {
        return id;
    }

    public QzExamination setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public QzExamination setName(String name) {
        this.name = name;
        return this;
    }

    public String getIsZhuGuan() {
        return isZhuGuan;
    }

    public QzExamination setIsZhuGuan(String isZhuGuan) {
        this.isZhuGuan = isZhuGuan;
        return this;
    }

    public String getMajorId() {
        return majorId;
    }

    public QzExamination setMajorId(String majorId) {
        this.majorId = majorId;
        return this;
    }

    public String getPaperId() {
        return paperId;
    }

    public QzExamination setPaperId(String paperId) {
        this.paperId = paperId;
        return this;
    }

    public String getPaperName() {
        return paperName;
    }

    public QzExamination setPaperName(String paperName) {
        this.paperName = paperName;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public QzExamination setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getRecRegNext() {
        return recRegNext;
    }

    public QzExamination setRecRegNext(String recRegNext) {
        this.recRegNext = recRegNext;
        return this;
    }

    public String getDepartId() {
        return departId;
    }

    public QzExamination setDepartId(String departId) {
        this.departId = departId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public QzExamination setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public QzExamination setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public QzExamination setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public QzExamination setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public QzExamination setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getSweepTime() {
        return sweepTime;
    }

    public QzExamination setSweepTime(Integer sweepTime) {
        this.sweepTime = sweepTime;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzExamination setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    public String getOfficeId() {
        return officeId;
    }

    public QzExamination setOfficeId(String officeId) {
        this.officeId = officeId;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public QzExamination setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public QzExamination setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Integer getEditPermissions() {
        return editPermissions;
    }

    public QzExamination setEditPermissions(Integer editPermissions) {
        this.editPermissions = editPermissions;
        return this;
    }

    public Integer getIsAssign() {
        return isAssign;
    }

    public QzExamination setIsAssign(Integer isAssign) {
        this.isAssign = isAssign;
        return this;
    }

    public Integer getIsRecReg() {
        return isRecReg;
    }

    public QzExamination setIsRecReg(Integer isRecReg) {
        this.isRecReg = isRecReg;
        return this;
    }

    public Integer getShowType() {
        return showType;
    }

    public QzExamination setShowType(Integer showType) {
        this.showType = showType;
        return this;
    }

    public Integer getSubmitLimit() {
        return submitLimit;
    }

    public QzExamination setSubmitLimit(Integer submitLimit) {
        this.submitLimit = submitLimit;
        return this;
    }

    public Integer getShowResult() {
        return showResult;
    }

    public QzExamination setShowResult(Integer showResult) {
        this.showResult = showResult;
        return this;
    }

    public Integer getSeleLimit() {
        return seleLimit;
    }

    public QzExamination setSeleLimit(Integer seleLimit) {
        this.seleLimit = seleLimit;
        return this;
    }

    public Integer getPlanLimit() {
        return planLimit;
    }

    public QzExamination setPlanLimit(Integer planLimit) {
        this.planLimit = planLimit;
        return this;
    }

    public Integer getSendMsg() {
        return sendMsg;
    }

    public QzExamination setSendMsg(Integer sendMsg) {
        this.sendMsg = sendMsg;
        return this;
    }

    public Double getNmks() {
        return nmks;
    }

    public QzExamination setNmks(Double nmks) {
        this.nmks = nmks;
        return this;
    }

    public Integer getJifen() {
        return jifen;
    }

    public QzExamination setJifen(Integer jifen) {
        this.jifen = jifen;
        return this;
    }

    public Integer getIsAutoTianKong() {
        return isAutoTianKong;
    }

    public QzExamination setIsAutoTianKong(Integer isAutoTianKong) {
        this.isAutoTianKong = isAutoTianKong;
        return this;
    }

    public Integer getShowNotes() {
        return showNotes;
    }

    public QzExamination setShowNotes(Integer showNotes) {
        this.showNotes = showNotes;
        return this;
    }

    public Integer getIsCustomNotes() {
        return isCustomNotes;
    }

    public QzExamination setIsCustomNotes(Integer isCustomNotes) {
        this.isCustomNotes = isCustomNotes;
        return this;
    }

    public String getCustomNotes() {
        return customNotes;
    }

    public QzExamination setCustomNotes(String customNotes) {
        this.customNotes = customNotes;
        return this;
    }

    public String getType() {
        return type;
    }

    public QzExamination setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getIsSimulation() {
        return isSimulation;
    }

    public QzExamination setIsSimulation(Integer isSimulation) {
        this.isSimulation = isSimulation;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public QzExamination setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getAppCode() {
        return appCode;
    }

    public QzExamination setAppCode(String appCode) {
        this.appCode = appCode;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzExamination{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", majorId='" + majorId + '\'' +
                ", paperId='" + paperId + '\'' +
                ", paperName='" + paperName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", departId='" + departId + '\'' +
                ", userId='" + userId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status=" + status +
                ", sweepTime=" + sweepTime +
                ", sysUserId='" + sysUserId + '\'' +
                ", officeId='" + officeId + '\'' +
                ", createtime='" + createtime + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", editPermissions=" + editPermissions +
                ", isAssign=" + isAssign +
                ", isRecReg=" + isRecReg +
                ", recRegNext='" + recRegNext + '\'' +
                ", showType=" + showType +
                ", submitLimit=" + submitLimit +
                ", showResult=" + showResult +
                ", seleLimit=" + seleLimit +
                ", planLimit=" + planLimit +
                ", sendMsg=" + sendMsg +
                ", nmks=" + nmks +
                ", jifen=" + jifen +
                ", isAutoTianKong=" + isAutoTianKong +
                ", isZhuGuan='" + isZhuGuan + '\'' +
                ", showNotes=" + showNotes +
                ", isCustomNotes=" + isCustomNotes +
                ", customNotes='" + customNotes + '\'' +
                ", type='" + type + '\'' +
                ", isSimulation=" + isSimulation +
                ", remark='" + remark + '\'' +
                ", appCode='" + appCode + '\'' +
                '}';
    }
}
