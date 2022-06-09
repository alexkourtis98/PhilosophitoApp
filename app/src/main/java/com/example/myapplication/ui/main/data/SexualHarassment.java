package com.example.myapplication.ui.main.data;

public class SexualHarassment {
    private String content = "";

    public SexualHarassment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SexualHarassment{" +
                "content='" + content + '\'' +
                '}';
    }
}
