package kourtis.quadrum.philosophito.core.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dictionary")
public class DictionaryEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String externalUrl;
    private int order;

    public DictionaryEntity(String title, String description, String externalUrl, int order) {
        this.title = title;
        this.description = description;
        this.externalUrl = externalUrl;
        this.order = order;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
