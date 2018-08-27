package com.ctrl.education.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
@TableName("sys_dict_type")
public class SysDictType extends Model<SysDictType> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    @NotNull(message = "id不可为空", groups = UpdateGroup.class)
    private String id;
    /**
     * 类型名称
     */
    @NotNull(message = "类型名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 200, message = "类型名称字符长度在1-200。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 描述
     */
    @Length(max = 200, message = "描述长度最多不可超过200个字符。", groups = {AddGroup.class, UpdateGroup.class})
    private String desc;
    /**
     * 排序
     */
    @NotNull(message = "排序字段不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Min(value = 0, message = "排序字段必须为0~999之间的数字", groups = {AddGroup.class, UpdateGroup.class})
    @Max(value = 999, message = "排序字段必须为0~999之间的数字", groups = {AddGroup.class, UpdateGroup.class})
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        return "SysDictType{" +
                "id=" + id +
                ", name=" + name +
                ", desc=" + desc +
                ", sort=" + sort +
                ", remark=" + remark +
                "}";
    }
}
