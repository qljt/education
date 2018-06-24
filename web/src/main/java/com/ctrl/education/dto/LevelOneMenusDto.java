package com.ctrl.education.dto;

import java.io.Serializable;

/**
 * com.ctrl.education.dto
 *
 * @name LevelOneMenusDto
 * @description
 * @date 2018-06-20 09:15
 */
public class LevelOneMenusDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单icon
     */
    private String icon;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 按钮集合
     */
    private boolean hasMenu;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }
}

