package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 积分规则表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@TableName("qz_integral_rule")
public class QzIntegralRule extends Model<QzIntegralRule> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 类型 0登录次数 1登录时长 2完善个人信息 3评价课件 4共享课件 5考试通过 6发现问题 7提交文章
     */
    private Integer type;
    /**
     * 登录次数/登录时长
     */
    private Integer frequency;
    /**
     * 可以获取的积分数
     */
    private Integer score;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 最后一次修改时间
     */
    @TableField("last_update_time")
    private String lastUpdateTime;
    /**
     * 最后编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;
    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzIntegralRule{" +
        "id=" + id +
        ", type=" + type +
        ", frequency=" + frequency +
        ", score=" + score +
        ", createtime=" + createtime +
        ", state=" + state +
        ", lastUpdateTime=" + lastUpdateTime +
        ", sysUserId=" + sysUserId +
        ", remark=" + remark +
        "}";
    }
}
