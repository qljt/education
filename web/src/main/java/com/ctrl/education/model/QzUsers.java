package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-19
 */
@TableName("qz_users")
public class QzUsers extends Model<QzUsers> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 状态0删除1正常2禁用
     */
    private Integer state;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 部门ID
     */
    @TableField("depart_id")
    private String departId;
    /**
     * 级别ID数组，逗号隔开
     */
    @TableField("level_id")
    private String levelId;
    /**
     * 岗位ID数组，逗号隔开
     */
    @TableField("position_id")
    private String positionId;
    /**
     * qqtoken
     */
    @TableField("qq_token")
    private String qqToken;
    /**
     * 微信token
     */
    @TableField("wx_token")
    private String wxToken;
    /**
     * 性别0男1女
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 用户来源 0 手机APP注册 1网站 2系统添加
     */
    private Integer source;
    /**
     * 类型 0 企业内部 1企业外部
     */
    private Integer type;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;
    /**
     * 头像
     */
    private String icon;
    /**
     * 身份证号
     */
    @TableField("id_number")
    private String idNumber;
    /**
     * 学历
     */
    private String education;
    /**
     * 所属公司
     */
    private String company;
    /**
     * 工号
     */
    @TableField("work_number")
    private String workNumber;
    /**
     * 审核 0未审核 1通过 2拒绝
     */
    private Integer examine;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getQqToken() {
        return qqToken;
    }

    public void setQqToken(String qqToken) {
        this.qqToken = qqToken;
    }

    public String getWxToken() {
        return wxToken;
    }

    public void setWxToken(String wxToken) {
        this.wxToken = wxToken;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzUsers{" +
        "id=" + id +
        ", account=" + account +
        ", password=" + password +
        ", nickname=" + nickname +
        ", mobile=" + mobile +
        ", createtime=" + createtime +
        ", state=" + state +
        ", sysCode=" + sysCode +
        ", departId=" + departId +
        ", levelId=" + levelId +
        ", positionId=" + positionId +
        ", qqToken=" + qqToken +
        ", wxToken=" + wxToken +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", source=" + source +
        ", type=" + type +
        ", sysUserId=" + sysUserId +
        ", icon=" + icon +
        ", idNumber=" + idNumber +
        ", education=" + education +
        ", company=" + company +
        ", workNumber=" + workNumber +
        ", examine=" + examine +
        "}";
    }
}
