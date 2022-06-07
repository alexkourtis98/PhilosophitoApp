package com.example.myapplication.ui.main.data;

public class Theory {

    private String title;
    private String shortDescription;
    private String fullContent;

    public Theory() {
    }

    public Theory(String title, String shortDescription, String fullContent) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullContent = fullContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    @Override
    public String toString() {
        return "Theory{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullContent='" + fullContent + '\'' +
                '}';
    }
}
