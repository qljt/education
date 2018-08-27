package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 论坛小组
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@TableName("qz_forum_group")
public class QzForumGroup extends Model<QzForumGroup> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 小组名称
     */
    @NotNull(message = "小组不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 190, message = "小组名称长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 排序
     */
    @Min(value = 0,message = "必须是数字")
    private Integer sort;
    /**
     * 状态 0删除1正常 2禁用
     */
    private Integer state;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 封面地址
     */
    @TableField("cover_path")
    private String coverPath;
    /**
     * 详情
     */
    private String content;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "QzForumGroup{" +
        "id=" + id +
        ", name=" + name +
        ", sort=" + sort +
        ", state=" + state +
        ", sysCode=" + sysCode +
        ", createtime=" + createtime +
        ", coverPath=" + coverPath +
        ", content=" + content +
        ", sysUserId=" + sysUserId +
        "}";
    }
}
