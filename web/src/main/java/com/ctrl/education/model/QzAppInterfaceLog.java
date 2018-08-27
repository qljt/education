package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 接口访问日志
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@TableName("qz_app_interface_log")
public class QzAppInterfaceLog extends Model<QzAppInterfaceLog> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 客户端编号
     */
    private String subsiteCode;
    /**
     * 接口名称
     */
    @TableField("interface_name")
    private String interfaceName;
    /**
     * 最后访问时间
     */
    private String createtime;
    /**
     * 接口编号
     */
    @TableField("interface_num")
    private String interfaceNum;
    /**
     * 访问次数
     */
    private Integer click;
    /**
     * 中文名称
     */
    @TableField("interface_name_cn")
    private String interfaceNameCn;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubsiteCode() {
        return subsiteCode;
    }

    public void setSubsiteCode(String subsiteCode) {
        this.subsiteCode = subsiteCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getInterfaceNum() {
        return interfaceNum;
    }

    public void setInterfaceNum(String interfaceNum) {
        this.interfaceNum = interfaceNum;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getInterfaceNameCn() {
        return interfaceNameCn;
    }

    public void setInterfaceNameCn(String interfaceNameCn) {
        this.interfaceNameCn = interfaceNameCn;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzAppInterfaceLog{" +
        "id=" + id +
        ", subsiteCode=" + subsiteCode +
        ", interfaceName=" + interfaceName +
        ", createtime=" + createtime +
        ", interfaceNum=" + interfaceNum +
        ", click=" + click +
        ", interfaceNameCn=" + interfaceNameCn +
        "}";
    }
}
