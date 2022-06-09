package com.example.myapplication.ui.main.data;

public class AffirmativeAction {
    private String content = "";

    public AffirmativeAction() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AffirmativeAction{" +
                "content='" + content + '\'' +
                '}';
    }
}
