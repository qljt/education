package com.ctrl.education.model;

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
 * 系统字典表
 * </p>
 *
 * @since 2018-07-15
 */
@TableName("sys_dict")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 字典编码
     */
    @NotNull(message = "编码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max =200, message = "编码长度为1-200。", groups = {AddGroup.class, UpdateGroup.class})
    private String code;
    /**
     * 父级id
     */
    private String pid;
    /**
     * 字典名称
     */
    @NotNull(message = "字典名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max =200, message = "字典名称长度为1-200。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysDict{" +
        "id=" + id +
        ", code=" + code +
        ", pid=" + pid +
        ", name=" + name +
        ", sort=" + sort +
        ", remark=" + remark +
        "}";
    }
}
