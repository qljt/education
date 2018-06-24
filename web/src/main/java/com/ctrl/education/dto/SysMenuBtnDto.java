package com.ctrl.education.dto;

import java.io.Serializable;

/**
 * com.ctrl.education.dto
 *
 * @name SysMenuBtnDto
 * @description
 * @date 2018-06-20 09:10
 */
public class SysMenuBtnDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 按钮名称
     */
    private String name;
    /**
     * 按钮 type
     */
    private Integer type;
    /**
     * 按钮code
     */
    private String code;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

