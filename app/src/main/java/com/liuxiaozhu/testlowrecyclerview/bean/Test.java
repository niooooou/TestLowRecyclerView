package com.liuxiaozhu.testlowrecyclerview.bean;

/**
 * Created by chenhui on 2017/6/9.
 * All Rights Reserved by YiZu
 * 通过该类存放数据
 */

public class Test {
    private String title;
    private String img;
    private String content;

    public Test(String title, String img, String content) {
        this.title = title;
        this.img = img;
        this.content = content;
    }

    public Test(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
