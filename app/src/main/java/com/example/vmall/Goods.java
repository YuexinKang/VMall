package com.example.vmall;

import java.io.Serializable;

//序列化接口，从内存到物理介质 反序列化，从物理介质到内存
public class Goods implements Serializable {
    private String title;
    private String prices;
    private Integer icon;

    public Goods(String title, String prices, Integer icon) {
        this.title = title;
        this.prices = prices;
        this.icon = icon;
    }

    public Goods() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "title='" + title + '\'' +
                ", prices='" + prices + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
