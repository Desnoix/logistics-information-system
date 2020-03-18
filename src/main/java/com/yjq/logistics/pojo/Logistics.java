package com.yjq.logistics.pojo;

import java.util.Date;

public class Logistics {
    private Integer id;

    private String goodsNumber;

    private Integer gooodsId;

    private Integer fromDeptId;

    private Integer toDeptId;

    private Date createTime;

    private Date arriveTime;

    private Integer deleted;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGooodsId() {
        return gooodsId;
    }

    public void setGooodsId(Integer gooodsId) {
        this.gooodsId = gooodsId;
    }

    public Integer getFromDeptId() {
        return fromDeptId;
    }

    public void setFromDeptId(Integer fromDeptId) {
        this.fromDeptId = fromDeptId;
    }

    public Integer getToDeptId() {
        return toDeptId;
    }

    public void setToDeptId(Integer toDeptId) {
        this.toDeptId = toDeptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}