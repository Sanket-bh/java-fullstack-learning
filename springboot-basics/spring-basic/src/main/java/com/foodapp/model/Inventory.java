package com.foodapp.model;

public class Inventory {
    int itemId;
    String itemName;
    Boolean stock;
    String desc;
    String image;

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Boolean getStock() {
        return stock;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
