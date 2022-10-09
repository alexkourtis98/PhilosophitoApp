package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class Issue {

    private String title;
    private String shortDescription;
    private String mdLocation;
    private String image;
    private String audioLocation;
    private String enumname;

    public Issue() {
    }

    public Issue(String title, String shortDescription, String mdLocation, String image, String audioLocation, String enumname) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.mdLocation = mdLocation;
        this.image = image;
        this.audioLocation = audioLocation;
        this.enumname = enumname;
    }

    @Override
    @NonNull
    public String toString() {
        return "Issue{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", mdLocation='" + mdLocation + '\'' +
                ", image='" + image + '\'' +
                ", audioLocation='" + audioLocation + '\'' +
                ", enumname=" + enumname +
                '}';
    }

    public String getEnumname() {
        return enumname;
    }

    public void setEnumname(String enumname) {
        this.enumname = enumname;
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

    public String getMdLocation() {
        return mdLocation;
    }

    public void setMdLocation(String mdLocation) {
        this.mdLocation = mdLocation;
    }

    public String getAudioLocation() {
        return audioLocation;
    }

    public void setAudioLocation(String audioLocation) {
        this.audioLocation = audioLocation;
    }
}
