package com.example.myapplication.ui.main.data;

public class Discrimination {
    private String content = "";

    public Discrimination() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Discrimination{" +
                "content='" + content + '\'' +
                '}';
    }
}
