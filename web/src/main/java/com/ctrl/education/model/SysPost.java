package com.ctrl.education.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 岗位表
 * </p>
 *
 * @author ctrl
 * @since 2018-07-23
 */
@TableName("sys_post")
public class SysPost extends Model<SysPost> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 父级id
     */
    private String pid;
    /**
     * 岗位名称
     */
    @NotNull(message = "岗位名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 20, message = "岗位名称长度为1-20。", groups = {AddGroup.class, UpdateGroup.class})
    @TableField("post_name")
    private String postName;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysPost{" +
        "id=" + id +
        ", pid=" + pid +
        ", postName=" + postName +
        ", sort=" + sort +
        ", createTime=" + createTime +
        "}";
    }
}
