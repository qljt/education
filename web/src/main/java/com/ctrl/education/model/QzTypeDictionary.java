package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 分类字典表
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-20
 */
@TableName("qz_type_dictionary")
public class QzTypeDictionary extends Model<QzTypeDictionary> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 岗位名称
     */
    @TableField("pos_name")
    private String posName;
    /**
     * 排序值
     */
    @TableField("sort")
    private String sort;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private String state;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 类型 0、培训分类1、资讯分类2、岗位分类3、级别分类4、预留人员分类5、课程分类6、共享资料分类7、试题分类
     * 8、试卷分类9、问卷分类10试题难易度分类 11公告类别 12教师分类
     */
    @TableField("type")
    private String type;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public QzTypeDictionary setId(String id) {
        this.id = id;
        return this;
    }

    public String getPosName() {
        return posName;
    }

    public QzTypeDictionary setPosName(String posName) {
        this.posName = posName;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public QzTypeDictionary setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public String getState() {
        return state;
    }

    public QzTypeDictionary setState(String state) {
        this.state = state;
        return this;
    }

    public String getSysCode() {
        return sysCode;
    }

    public QzTypeDictionary setSysCode(String sysCode) {
        this.sysCode = sysCode;
        return this;
    }

    public String getType() {
        return type;
    }

    public QzTypeDictionary setType(String type) {
        this.type = type;
        return this;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public QzTypeDictionary setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "QzTypeDictionary{" +
                "id='" + id + '\'' +
                ", posName='" + posName + '\'' +
                ", sort='" + sort + '\'' +
                ", state='" + state + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", type='" + type + '\'' +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
