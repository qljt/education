package com.ctrl.education.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("sys_dict")
public class SysDict extends Model<SysDict> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    @NotNull(message = "id不可为空", groups = UpdateGroup.class)
    private String id;
    /**
     * 类型id
     */
    @TableField("type_id")
    @NotNull(message = "类型id必传", groups = {AddGroup.class, UpdateGroup.class})
    private String typeId;
    /**
     * 父级id5
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 标签
     */
    @NotNull(message = "标签必填", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "标签字符长度在1-30之间。", groups = {AddGroup.class, UpdateGroup.class})
    private String label;
    /**
     * 值
     */
    @NotNull(message = "值必填", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "值字符长度在1-30之间。", groups = {AddGroup.class, UpdateGroup.class})
    private String value;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
                ", typeId=" + typeId +
                ", parentId=" + parentId +
                ", label=" + label +
                ", value=" + value +
                ", sort=" + sort +
                ", remark=" + remark +
                "}";
    }
}
