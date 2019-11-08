package com.zxw.common.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EasyUITreeNode implements Serializable {

    private long id;
    private String text;
    private String state;
    private List<EasyUITreeNode> list = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<EasyUITreeNode> getList() {
        return list;
    }

    public void setList(List<EasyUITreeNode> list) {
        this.list = list;
    }
}
