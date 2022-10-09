package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class FavoriteItem {
    private String id;
    private String title;
    private String mdFile;
    private String textcontent;
    private String source;
    private String enumtype;
    private String audiofile;

    public FavoriteItem() {
    }

    public FavoriteItem(String id, String title, String mdFile, String textcontent, String source, String enumtype, String audiofile) {
        this.id = id;
        this.title = title;
        this.mdFile = mdFile;
        this.textcontent = textcontent;
        this.source = source;
        this.enumtype = enumtype;
        this.audiofile = audiofile;
    }

    @NonNull
    @Override
    public String toString() {
        return "FavoriteItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", mdFile='" + mdFile + '\'' +
                ", textcontent='" + textcontent + '\'' +
                ", source='" + source + '\'' +
                ", enumtype='" + enumtype + '\'' +
                ", audiofile='" + audiofile + '\'' +
                '}';
    }

    public String getEnumtype() {
        return enumtype;
    }

    public void setEnumtype(String enumtype) {
        this.enumtype = enumtype;
    }

    public String getAudiofile() {
        return audiofile;
    }

    public void setAudiofile(String audiofile) {
        this.audiofile = audiofile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
