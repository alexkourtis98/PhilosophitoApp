package com.example.myapplication.ui.main.data;

public class CSR {
    private String content = "";

    public CSR() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CSR{" +
                "content='" + content + '\'' +
                '}';
    }
}
