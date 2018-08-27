package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 专业信息表
 * </p>
 *
 * @author liyang_1
 * @since 2018-06-20
 */
@TableName("qz_major")
public class QzMajor extends Model<QzMajor> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 专业名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 状态 0 删除 1 正常
     */
    @TableField(value = "state")
    private Integer state;
    /**
     * 父类ID
     */
    @TableField(value = "parent_id")
    private String parentId;
    /**
     * 四位一组 0000 开始 00010001
     */
    @TableField(value = "code")
    private String code;

    public String getParentId() {
        return parentId;
    }

    public QzMajor setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getCode() {
        return code;
    }

    public QzMajor setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getId() {
        return id;
    }

    public QzMajor setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public QzMajor setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public QzMajor setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public QzMajor setState(Integer state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "QzMajor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", state=" + state +
                ", parentId='" + parentId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
