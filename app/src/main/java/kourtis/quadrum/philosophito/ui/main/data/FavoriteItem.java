package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class FavoriteItem {
    private String id;
    private String title;
    private String mdFile;
    private String textcontent;

    public FavoriteItem() {
    }

    public FavoriteItem(String id, String title, String mdFile, String textcontent) {
        this.id = id;
        this.title = title;
        this.mdFile = mdFile;
        this.textcontent = textcontent;
    }

    @NonNull
    @Override
    public String toString() {
        return "FavoriteItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", mdFile='" + mdFile + '\'' +
                ", textcontent='" + textcontent + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdFile() {
        return mdFile;
    }

    public void setMdFile(String mdFile) {
        this.mdFile = mdFile;
    }

    public String getTextcontent() {
        return textcontent;
    }

    public void setTextcontent(String textcontent) {
        this.textcontent = textcontent;
    }
}
