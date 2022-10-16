package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class BankQuestion {
    private String title;
    private String text;
    private String enumtype;

    public BankQuestion() {
    }

    public BankQuestion(String title, String text, String enumtype) {
        this.title = title;
        this.text = text;
        this.enumtype = enumtype;
    }

    @NonNull
    @Override
    public String toString() {
        return "BankQuestion{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", enumtype='" + enumtype + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEnumtype() {
        return enumtype;
    }

    public void setEnumtype(String enumtype) {
        this.enumtype = enumtype;
    }
}
