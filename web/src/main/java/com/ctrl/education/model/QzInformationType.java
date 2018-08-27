package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资讯分类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@TableName("qz_information_type")
public class QzInformationType extends Model<QzInformationType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 父级id
     */
    private String pid;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 状态 0删除1 正常 2禁用
     */
    private Integer state;


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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzInformationType{" +
        "id=" + id +
        ", pid=" + pid +
        ", name=" + name +
        ", sort=" + sort +
        ", state=" + state +
        "}";
    }
}
