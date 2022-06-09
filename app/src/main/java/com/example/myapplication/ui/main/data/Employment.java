package com.example.myapplication.ui.main.data;

public class Employment {
    private String content = "";

    public Employment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Employment{" +
                "content='" + content + '\'' +
                '}';
    }
}
