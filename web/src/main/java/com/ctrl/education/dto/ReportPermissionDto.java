package com.ctrl.education.dto;

import java.io.Serializable;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name ReportPermissionDto
 * @description
 * @date 2018-06-20 01:40
 */
public class ReportPermissionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 权限 主键
     */
    private Integer value;
    /**
     * 权限 名称
     */
    private String title;
    /**
     * 权限 子节点，因权限没有父子级，此字段为了兼容js插件。
     */
    private List<ReportPermissionDto> data;
    /**
     * 权限 是否选中
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

    public List<ReportPermissionDto> getData() {
        return data;
    }

    public void setData(List<ReportPermissionDto> data) {
        this.data = data;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}

