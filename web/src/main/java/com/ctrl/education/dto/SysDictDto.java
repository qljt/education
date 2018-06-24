package com.ctrl.education.dto;

import java.io.Serializable;

/**
 * com.ctrl.education.dto
 *
 * @name SysDictDto
 * @description
 * @date 2018-06-19 22:18
 */
public class SysDictDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String label;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
