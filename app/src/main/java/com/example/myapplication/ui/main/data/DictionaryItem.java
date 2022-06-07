package com.example.myapplication.ui.main.data;

public class DictionaryItem {

    private String title;
    private String definition;

    public DictionaryItem(String title, String definition) {
        this.title = title;
        this.definition = definition;
    }

    public DictionaryItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "DictionaryItem{" +
                "title='" + title + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
