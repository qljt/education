package com.ctrl.education.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.shiro.ShiroKit;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * com.ctrl.education.dto
 *
 * @name QzEnterpriseDto
 * @description
 * @date 2018-06-10 下午9:35
 */
public class QzEnterpriseDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private String id;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 系统编码（企业编码）
     */
    private String sysCode;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 联系人
     */
    private String linkName;
    /**
     * 联系电话
     */
    private String linkPhone;
    /**
     * 联系邮箱
     */
    private String linkEmail;
    /**
     * 公司介绍
     */
    private String content;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 创建者姓名
     */
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
