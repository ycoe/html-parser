package com.duoec.htmlparse;

/**
 * Created by ycoe on 16/7/19.
 */
public class House {
    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String houseName;

    /**
     * 价格
     */
    private Integer price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
