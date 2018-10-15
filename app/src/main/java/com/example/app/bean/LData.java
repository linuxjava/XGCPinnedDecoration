package com.example.app.bean;

public class LData {
    public static final int ITEM_TYPE_SECTION = 1;
    public static final int ITEM_TYPE_DATA = 2;

    private int itemType;
    private String data;

    public LData(int itemType, String data) {
        this.itemType = itemType;
        this.data = data;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
