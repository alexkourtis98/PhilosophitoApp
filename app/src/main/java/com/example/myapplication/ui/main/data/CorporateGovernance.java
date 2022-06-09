package com.example.myapplication.ui.main.data;

public class CorporateGovernance {
    private String content = "";

    public CorporateGovernance() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CorporateGovernance{" +
                "content='" + content + '\'' +
                '}';
    }
}
