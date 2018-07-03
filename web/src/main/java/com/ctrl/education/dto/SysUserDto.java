package com.ctrl.education.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * com.ctrl.education.dto
 *
 * @name SysUserDto
 * @description
 * @date 2018-07-03 13:34
 */
public class SysUserDto {
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
    @Length(min = 4, max = 25, message = "企业名称长度为1-25。", groups = {AddGroup.class, UpdateGroup.class})
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "密码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "密码长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String password;
    /**
     * 真实姓名
     */
    @Length(min = 1, max = 30, message = "真实长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String realname;
    /**
     * 昵称
     */
    @Length(min = 1, max = 50, message = "昵称长度为0-0。", groups = {AddGroup.class, UpdateGroup.class})
    private String nickname;
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
    @Length(min = 1, max = 80, message = "邮箱长度为0-0。", groups = {AddGroup.class, UpdateGroup.class})
    private String email;
    /**
     * 手机号
     */
    @Length(min = 12, max =12, message = "手机号码长度为12位。", groups = {AddGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^1[3-9]{1}\\d{9}$", message = "手机号格式不正确。", groups = {AddGroup.class, UpdateGroup.class})
    private String mobile;
    /**
     * 角色ID数组，逗号隔开
     */
    @TableField("role_id")
    private String roleId;
    /**
     * 座机号
     */
    @Length(min = 1, max = 18, message = "座机号码长度为1-18。", groups = {AddGroup.class, UpdateGroup.class})
    private String phone;
    /**
     * 账号状态，1：启用，2：冻结 3：删除
     */
    private Integer status;
    /**
     * 机构id
     */
    @TableField("office_id")
    private String officeId;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public SysUserDto() {
    }

    public SysUserDto(String username, String password, String realname, String nickname, Date birthday, Integer gender, String email, String mobile, String roleId, String phone, Integer status, String officeId) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.roleId = roleId;
        this.phone = phone;
        this.status = status;
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "SysUserDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", roleId='" + roleId + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", officeId='" + officeId + '\'' +
                '}';
    }
}
