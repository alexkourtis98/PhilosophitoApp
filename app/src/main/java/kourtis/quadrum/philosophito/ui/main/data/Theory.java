package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class Theory {

    private String title;
    private String shortDescription;
    private String mdLocation;
    private String image;
    private String audioLocation;
    private String enumtype;

    public Theory() {
    }

    @NonNull
    @Override
    public String toString() {
        return "Theory{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", mdLocation='" + mdLocation + '\'' +
                ", image='" + image + '\'' +
                ", audioLocation='" + audioLocation + '\'' +
                ", enumtype='" + enumtype + '\'' +
                '}';
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudioLocation() {
        return audioLocation;
    }

    public void setAudioLocation(String audioLocation) {
        this.audioLocation = audioLocation;
    }

    public String getEnumtype() {
        return enumtype;
    }

    public void setEnumtype(String enumtype) {
        this.enumtype = enumtype;
    }
}
