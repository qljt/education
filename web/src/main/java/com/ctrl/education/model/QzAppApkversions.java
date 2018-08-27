package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@TableName("qz_app_apkversions")
public class QzAppApkversions extends Model<QzAppApkversions> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * apk名称
     */
    @NotNull(message = "apk名称", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "apk名称长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String apkname;
    /**
     * apk版本号
     */
    private String apkversion;
    /**
     * apkURL
     */
    private String apkurl;
    /**
     * 是否最新版本  1最新  
     */
    private String isnew;
    /**
     * apk文件大小
     */
    private String filesize;
    /**
     * 更新 内容
     */
    private String remark;
    /**
     * 时间
     */
    private String updatetime;
    /**
     * 1 终端客户版
     */
    private String clienttype;
    /**
     * 类型 1 android    2 ios
     */
    private String type;
    /**
     * 二维码图片地址url
     */
    @TableField("two_code")
    private String twoCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getApkversion() {
        return apkversion;
    }

    public void setApkversion(String apkversion) {
        this.apkversion = apkversion;
    }

    public String getApkurl() {
        return apkurl;
    }

    public void setApkurl(String apkurl) {
        this.apkurl = apkurl;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTwoCode() {
        return twoCode;
    }

    public void setTwoCode(String twoCode) {
        this.twoCode = twoCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzAppApkversions{" +
        "id=" + id +
        ", apkname=" + apkname +
        ", apkversion=" + apkversion +
        ", apkurl=" + apkurl +
        ", isnew=" + isnew +
        ", filesize=" + filesize +
        ", remark=" + remark +
        ", updatetime=" + updatetime +
        ", clienttype=" + clienttype +
        ", type=" + type +
        ", twoCode=" + twoCode +
        "}";
    }
}
