package com.manuni.getallcontinentspractice1;

import java.util.List;

public class MainObjectData {
    private List<ObjectData> data;

    public MainObjectData() {
    }

    public MainObjectData(List<ObjectData> data) {
        this.data = data;
    }

    public List<ObjectData> getData() {
        return data;
    }

    public void setData(List<ObjectData> data) {
        this.data = data;
    }
}
