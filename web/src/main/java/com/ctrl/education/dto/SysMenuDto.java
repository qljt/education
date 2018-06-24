package com.ctrl.education.dto;

import java.io.Serializable;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name SysMenuDto
 * @description
 * @date 2018-06-20 09:10
 */
public class SysMenuDto implements Serializable {

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
     * 菜单路径
     */
    private String path;
    /**
     * 按钮集合
     */
    private List<SysMenuBtnDto> btns;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SysMenuBtnDto> getBtns() {
        return btns;
    }

    public void setBtns(List<SysMenuBtnDto> btns) {
        this.btns = btns;
    }
}
