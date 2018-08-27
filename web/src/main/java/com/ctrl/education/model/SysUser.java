package com.ctrl.education.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dto.SysUserOfficeDto;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 账号
     */
    @TableField("username")
    @NotNull(message = "登录名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 25, message = "登录名称长度为1-25。", groups = {AddGroup.class, UpdateGroup.class})
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不可为空", groups = {AddGroup.class})
    @Length(min = 1, max = 250, message = "密码长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String password;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 性别，0保密（默认），1男，2女
     */
    private Integer gender;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式有误。", groups = {AddGroup.class, UpdateGroup.class})
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 座机号
     */
    private String phone;
    /**
     * 账号状态，1：启用，2：冻结 3：删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 扩展信息集合
     */
    @TableField(exist = false)
    private List<SysUserOffice> extendInfo;
    @TableField(exist = false)
    private List<SysUserOfficeDto> sysUserOfficeDtos;

    public SysUser() {
    }

    public SysUser(SysUser sysUser) {
        super();
        this.id = sysUser.getId();
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
        this.realname = sysUser.getRealname();
        this.nickname = sysUser.getRealname();
        this.avatar = sysUser.getAvatar();
        this.birthday = sysUser.getBirthday();
        this.gender = sysUser.getGender();
        this.email = sysUser.getEmail();
        this.mobile = sysUser.getEmail();
        this.phone = sysUser.getPhone();
        this.status = sysUser.getStatus();
        this.createTime = sysUser.getCreateTime();
        this.lastLoginTime = sysUser.getLastLoginTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public List<SysUserOffice> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(List<SysUserOffice> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<SysUserOfficeDto> getSysUserOfficeDtos() {
        return sysUserOfficeDtos;
    }

    public void setSysUserOfficeDtos(List<SysUserOfficeDto> sysUserOfficeDtos) {
        this.sysUserOfficeDtos = sysUserOfficeDtos;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", extendInfo=" + extendInfo +
                '}';
    }
}
