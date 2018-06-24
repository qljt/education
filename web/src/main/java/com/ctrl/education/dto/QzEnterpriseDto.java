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
 * @author liyang
 * @name QzEnterpriseDto
 * @description
 * @date 2018-06-10 下午9:35
 */
@TableName("qz_enterprise")
public class QzEnterpriseDto implements Serializable{

    private static final long serialVersionUID = 1L;
    @NotNull(message = "企业名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 190, message = "企业名称长度为4-190。", groups = {AddGroup.class, UpdateGroup.class})
    @Excel(name = "企业名称")
    private String enterpriseName;
    /**
     * 系统编码（企业编码）
     */
    @NotNull(message = "企业编码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 30, message = "企业编码长度为4-30。", groups = {AddGroup.class, UpdateGroup.class})
    @Excel(name = "企业编码")
    private String sysCode;
    /**
     * 创建时间
     */
    @Excel(databaseFormat = "yyyy-MM-dd-HH-mm-ss", name = "")
    private String createtime;
    /**
     * 联系人
     */
    @Length(min = 4, max = 90, message = "联系人长度为4-90。", groups = {AddGroup.class, UpdateGroup.class})
    @Excel(name = "联系人")
    private String linkName;
    /**
     * 联系电话
     */
    @Length(min = 4, max = 30, message = "联系电话长度为4-30。", groups = {AddGroup.class, UpdateGroup.class})
    @Excel(name = "联系电话")
    private String linkPhone;
    /**
     * 联系邮箱
     */
    @Length(min = 4, max = 90, message = "联系电话长度为4-90。", groups = {AddGroup.class, UpdateGroup.class})
    @Excel(name = "邮箱")
    private String linkEmail;
    /**
     * 公司介绍
     */
    @Excel(name = "公司介绍")
    private String content;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state=1;

    /**
     * 编辑人员ID
     */

    private String sysUserId = String.valueOf(ShiroKit.getUser().getId());

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

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
}
