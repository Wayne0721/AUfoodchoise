package com.example.qoo;

/**
 * Created by Qoo on 2018/1/30.
 */

public class Data {
    int price;
    String storename,name,type,style;
    public Data(){

    }

    public Data(Integer price, String name, String type, String style,String storename) {
        this.storename = storename;
        this.price = price;
        this.name = name;
        this.type = type;
        this.style = style;
    }

    public String getStorename() {
        return storename;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStyle() {
        return style;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
