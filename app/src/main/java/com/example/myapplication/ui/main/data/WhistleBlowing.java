package com.example.myapplication.ui.main.data;

public class WhistleBlowing {

    private String content = "";

    public WhistleBlowing(String content) {
        this.content = content;
    }

    public WhistleBlowing() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WhistleBlowing{" +
                "content='" + content + '\'' +
                '}';
    }
}
