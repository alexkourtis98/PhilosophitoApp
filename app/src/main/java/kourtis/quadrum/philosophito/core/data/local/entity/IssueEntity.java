package kourtis.quadrum.philosophito.core.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "issues")
public class IssueEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String shortDescription;
    private String image;
    private String mdLocation;
    private String enumType;
    private String audioLocation;

    public IssueEntity(String title, String shortDescription, String image,
                       String mdLocation, String enumType, String audioLocation) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.image = image;
        this.mdLocation = mdLocation;
        this.enumType = enumType;
        this.audioLocation = audioLocation;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMdLocation() {
        return mdLocation;
    }

    public void setMdLocation(String mdLocation) {
        this.mdLocation = mdLocation;
    }

    public String getEnumType() {
        return enumType;
    }

    public void setEnumType(String enumType) {
        this.enumType = enumType;
    }

    public String getAudioLocation() {
        return audioLocation;
    }

    public void setAudioLocation(String audioLocation) {
        this.audioLocation = audioLocation;
    }
}
