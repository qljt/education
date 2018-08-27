package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 积分兑换礼品表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@TableName("qz_score_gift")
public class QzScoreGift extends Model<QzScoreGift> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 礼品名称
     */
    @NotNull(message = "礼品名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 190, message = "礼品名称长度为1-190。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 详情
     */
    private String content;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 操作人ID
     */
    @TableField("sys_user_id")
    private String sysUserId;
    /**
     * 所需积分
     */
    private Integer socre;
    /**
     * 最后一次更新时间
     */
    @TableField("last_update_time")
    private String lastUpdateTime;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 供应数量
     */
    @TableField("supply_num")
    private Integer supplyNum;
    /**
     * 剩余数量
     */
    private Integer num;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSupplyNum() {
        return supplyNum;
    }

    public void setSupplyNum(Integer supplyNum) {
        this.supplyNum = supplyNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzScoreGift{" +
        "id=" + id +
        ", name=" + name +
        ", image=" + image +
        ", content=" + content +
        ", createtime=" + createtime +
        ", sysUserId=" + sysUserId +
        ", socre=" + socre +
        ", lastUpdateTime=" + lastUpdateTime +
        ", state=" + state +
        ", supplyNum=" + supplyNum +
        ", num=" + num +
        "}";
    }
}
