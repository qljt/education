package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业信息配置表
 * </p>
 *
 * @author liyang
 * @since 2018-06-04
 */
@TableName("qz_enterprise_setting")
public class QzEnterpriseSetting extends Model<QzEnterpriseSetting> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 企业ID
     */
    @TableField("enterprise_id")
    private String enterpriseId;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 网站title
     */
    @TableField("website_title")
    private String websiteTitle;
    /**
     * 网站关键词数组，逗号隔开
     */
    @TableField("key_words")
    private String keyWords;
    /**
     * 网站名称
     */
    @TableField("website_name")
    private String websiteName;
    /**
     * 网站作者
     */
    @TableField("website_author")
    private String websiteAuthor;
    /**
     * 网站描述
     */
    @TableField("website_intro")
    private String websiteIntro;
    /**
     * 网站联系邮箱
     */
    @TableField("website_email")
    private String websiteEmail;
    /**
     * 网站联系电话
     */
    @TableField("website_phone")
    private String websitePhone;
    /**
     * 工作时间
     */
    @TableField("work_time")
    private String workTime;
    /**
     * 版权和备案号
     */
    private String copyright;
    /**
     * 地址
     */
    private String address;
    /**
     * 网站logo
     */
    @TableField("website_logo")
    private String websiteLogo;
    /**
     * banner图片
     */
    @TableField("website_banner")
    private String websiteBanner;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 是否启用单点登录 0否 1是
     */
    @TableField("single_sign")
    private Integer singleSign;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteAuthor() {
        return websiteAuthor;
    }

    public void setWebsiteAuthor(String websiteAuthor) {
        this.websiteAuthor = websiteAuthor;
    }

    public String getWebsiteIntro() {
        return websiteIntro;
    }

    public void setWebsiteIntro(String websiteIntro) {
        this.websiteIntro = websiteIntro;
    }

    public String getWebsiteEmail() {
        return websiteEmail;
    }

    public void setWebsiteEmail(String websiteEmail) {
        this.websiteEmail = websiteEmail;
    }

    public String getWebsitePhone() {
        return websitePhone;
    }

    public void setWebsitePhone(String websitePhone) {
        this.websitePhone = websitePhone;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsiteLogo() {
        return websiteLogo;
    }

    public void setWebsiteLogo(String websiteLogo) {
        this.websiteLogo = websiteLogo;
    }

    public String getWebsiteBanner() {
        return websiteBanner;
    }

    public void setWebsiteBanner(String websiteBanner) {
        this.websiteBanner = websiteBanner;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSingleSign() {
        return singleSign;
    }

    public void setSingleSign(Integer singleSign) {
        this.singleSign = singleSign;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzEnterpriseSetting{" +
                "id='" + id + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", websiteTitle='" + websiteTitle + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", websiteName='" + websiteName + '\'' +
                ", websiteAuthor='" + websiteAuthor + '\'' +
                ", websiteIntro='" + websiteIntro + '\'' +
                ", websiteEmail='" + websiteEmail + '\'' +
                ", websitePhone='" + websitePhone + '\'' +
                ", workTime='" + workTime + '\'' +
                ", copyright='" + copyright + '\'' +
                ", address='" + address + '\'' +
                ", websiteLogo='" + websiteLogo + '\'' +
                ", websiteBanner='" + websiteBanner + '\'' +
                ", state=" + state +
                ", singleSign=" + singleSign +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
