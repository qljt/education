package com.ctrl.education.dto;

import java.io.Serializable;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name MenuDataRuleDto
 * @description
 * @date 2018-06-20 09:00
 */
public class MenuDataRuleDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单/按钮 主键
     */
    private Integer value;
    /**
     * 菜单/按钮 名称
     */
    private String title;
    /**
     * 菜单/按钮 父级
     */
    private Integer parentId;
    /**
     * 数据规则 子节点
     */
    private List data;
    /**
     * 菜单/按钮 是否选中
     */
    private boolean checked;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

