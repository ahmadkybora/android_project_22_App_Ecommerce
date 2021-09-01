package com.example.android_project_22_app_ecommerce.models;

public class Product {
    private int id;
    private int categoryId;
    private String name;
    private String price;
    private String description;
    /*private String image;
    private String state;
    private String createdAt;
    private String updatedAt;
    private String ProductFavoriteLikes;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProductFavoriteLikes() {
        return ProductFavoriteLikes;
    }

    public void setProductFavoriteLikes(String productFavoriteLikes) {
        ProductFavoriteLikes = productFavoriteLikes;
    }*/
}