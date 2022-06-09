package com.example.myapplication.ui.main.data;

public class ProductSafety {
    private String content = "";

    public ProductSafety() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ProductSafety{" +
                "content='" + content + '\'' +
                '}';
    }
}
