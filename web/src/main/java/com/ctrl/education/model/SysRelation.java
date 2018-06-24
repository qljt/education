package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@TableName("sys_relation")
public class SysRelation extends Model<SysRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 菜单id
     */
    private String menuid;
    /**
     * 角色id
     */
    private String roleid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRelation{" +
        "id=" + id +
        ", menuid=" + menuid +
        ", roleid=" + roleid +
        "}";
    }
}
