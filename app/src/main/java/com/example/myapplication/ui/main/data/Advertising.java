package com.example.myapplication.ui.main.data;

public class Advertising {
    private String content = "";

    public Advertising() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "content='" + content + '\'' +
                '}';
    }
}
