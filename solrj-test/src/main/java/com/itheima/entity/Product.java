package com.itheima.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 定义域相关的实体类
 */
public class Product {
    @Field("pid")
    private String pid;
    @Field("name")
    private String name;
    @Field("catalog_name")
    private String catalogName;
    @Field("price")
    private double price;
    @Field("description")
    private String description;
    @Field("picture")
    private String picture;

    public Product(String pid, String name, String catalogName, double price, String description, String picture) {
        this.pid = pid;
        this.name = name;
        this.catalogName = catalogName;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }

    public Product() {

    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
