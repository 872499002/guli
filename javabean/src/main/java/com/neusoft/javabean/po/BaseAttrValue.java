package com.neusoft.javabean.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "base_attr_value")
public class BaseAttrValue implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 属性值名称
     */
    @Column(name = "value_name")
    private String valueName;

    /**
     * 状态
     */
    @Column(name = "attr_value_status")
    private int attrValueStatus;

    public int getAttrValueStatus() {
        return attrValueStatus;
    }

    public void setAttrValueStatus(int attrValueStatus) {
        this.attrValueStatus = attrValueStatus;
    }

    /**
     * 属性id
     */
    @Column(name = "attr_id")
    private Long attrId;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取属性值名称
     *
     * @return value_name - 属性值名称
     */
    public String getValueName() {
        return valueName;
    }

    /**
     * 设置属性值名称
     *
     * @param valueName 属性值名称
     */
    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    /**
     * 获取属性id
     *
     * @return attr_id - 属性id
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     * 设置属性id
     *
     * @param attrId 属性id
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public String toString() {
        return "BaseAttrValue{" +
                "id=" + id +
                ", valueName='" + valueName + '\'' +
                ", attrValueStatus=" + attrValueStatus +
                ", attrId=" + attrId +
                '}';
    }
}