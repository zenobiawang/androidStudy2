package com.example.entity;

/**
 * Created by wanghui on 2016/12/14.
 * 支出实体类
 */
public class CostEntity {
    private String date;
    private int[] costs;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int[] getCosts() {
        return costs;
    }

    public void setCosts(int[] costs) {
        this.costs = costs;
    }
}
