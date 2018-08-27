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
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * <p>
 * 动态资讯
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@TableName("qz_information")
public class QzInformation extends Model<QzInformation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 标题
     */
    @NotNull(message = "标题不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 190, message = "企业名称长度为1-190。", groups = {AddGroup.class, UpdateGroup.class})
    private String title;
    /**
     * 资讯内容
     */
    @NotNull(message = "内容不可为空", groups = {AddGroup.class, UpdateGroup.class})
    private String content;
    /**
     * 状态 0删除 1正常 2禁用 3草稿4已发布
     */
    private Integer state;
    /**
     * 点击数量
     */
    @NotNull(message = "点击数量", groups = {AddGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^/\\d$", message = "点击数量必须是正整数。", groups = {AddGroup.class, UpdateGroup.class})
    @TableField("click_num")
    private Integer clickNum;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 发布时间
     */
    @TableField("put_time")
    private String putTime;
    /**
     * 资讯封面图片
     */
    @NotNull(message = "封面图片不可为空", groups = {AddGroup.class, UpdateGroup.class})
    private String image;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 资讯分类ID
     */
    @TableField("type_id")
    @NotNull(message = "资讯分类不可为空", groups = {AddGroup.class, UpdateGroup.class})
    private String typeId;
    /**
     * 标签ID（逗号隔开）
     */
    private String labels;
    /**
     * 作者
     */
    @NotNull(message = "作者不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 90, message = "作者长度为1-90。", groups = {AddGroup.class, UpdateGroup.class})
    private String author;
    /**
     * 部门ID数组，逗号隔开
     */
    @TableField("depart_ids")
    private String departIds;
    /**
     * 岗位ID数组，逗号隔开
     */
    @TableField("position_ids")
    private String positionIds;
    /**
     * 级别ID数组，逗号隔开
     */
    @TableField("level_ids")
    private String levelIds;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 类型 1通知公告 2新闻咨询
     */
    private Integer type;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPutTime() {
        return putTime;
    }

    public void setPutTime(String putTime) {
        this.putTime = putTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDepartIds() {
        return departIds;
    }

    public void setDepartIds(String departIds) {
        this.departIds = departIds;
    }

    public String getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(String positionIds) {
        this.positionIds = positionIds;
    }

    public String getLevelIds() {
        return levelIds;
    }

    public void setLevelIds(String levelIds) {
        this.levelIds = levelIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        return "QzInformation{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", state=" + state +
        ", clickNum=" + clickNum +
        ", createtime=" + createtime +
        ", putTime=" + putTime +
        ", image=" + image +
        ", sysCode=" + sysCode +
        ", typeId=" + typeId +
        ", labels=" + labels +
        ", author=" + author +
        ", departIds=" + departIds +
        ", positionIds=" + positionIds +
        ", levelIds=" + levelIds +
        ", sort=" + sort +
        ", type=" + type +
        ", sysUserId=" + sysUserId +
        "}";
    }
}
