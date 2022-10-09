package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class Theory {

    private String title;
    private String shortDescription;
    private String fullContent;
    private String image;

    public Theory(String title, String shortDescription, String fullContent, String image) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullContent = fullContent;
        this.image = image;
    }

    public Theory() {
    }

    @NonNull
    @Override
    public String toString() {
        return "Theory{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullContent='" + fullContent + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
