package com.ctrl.education.dto;

import java.io.Serializable;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name OfficeChartDto
 * @description
 * @date 2018-06-20 01:16
 */
public class OfficeChartDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构主负责人名称
     */
    private String title;
    /**
     * 机构上级
     */
    private Integer parentId;
    /**
     * 机构节点
     */
    private List<OfficeChartDto> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<OfficeChartDto> getChildren() {
        return children;
    }

    public void setChildren(List<OfficeChartDto> children) {
        this.children = children;
    }
}
