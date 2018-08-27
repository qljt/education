package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 兑换记录
 * </p>
 *
 * @author ctrl
 * @since 2018-08-15
 */
@TableName("qz_gift_orders")
public class QzGiftOrders extends Model<QzGiftOrders> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 用户ID
     */
    @TableField("users_id")
    private String usersId;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 礼品ID
     */
    @TableField("gift_id")
    private String giftId;
    /**
     * 礼品名称
     */
    @TableField("gift_name")
    private String giftName;
    /**
     * 兑换数量
     */
    private Integer num;
    /**
     * 单个积分
     */
    private Integer socre;
    /**
     * 总积分
     */
    @TableField("total_score")
    private Integer totalScore;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 部门ID
     */
    @TableField("depart_id")
    private String departId;
    /**
     * 部门名称
     */
    @TableField("depart_name")
    private String departName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 兑换状态 0未处理 1已兑换 2拒绝
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 处理人ID
     */
    @TableField("sys_user_id")
    private String sysUserId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzGiftOrders{" +
        "id=" + id +
        ", usersId=" + usersId +
        ", account=" + account +
        ", giftId=" + giftId +
        ", giftName=" + giftName +
        ", num=" + num +
        ", socre=" + socre +
        ", totalScore=" + totalScore +
        ", createtime=" + createtime +
        ", departId=" + departId +
        ", departName=" + departName +
        ", phone=" + phone +
        ", state=" + state +
        ", status=" + status +
        ", remark=" + remark +
        ", sysUserId=" + sysUserId +
        "}";
    }
}
