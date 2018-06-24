package com.ctrl.education.dto;

import java.io.Serializable;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name PermissionDataRuleDto
 * @description
 * @date 2018-06-20 09:04
 */
public class PermissionDataRuleDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 数据规则 主键
     */
    private Integer value;
    /**
     * 数据规则 描述
     */
    private String title;
    /**
     * 数据规则 子节点(无用，为兼容插件而加的属性)
     */
    private List<PermissionSourceDto> data;
    /**
     * 数据规则 是否选中
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

    public List<PermissionSourceDto> getData() {
        return data;
    }

    public void setData(List<PermissionSourceDto> data) {
        this.data = data;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

