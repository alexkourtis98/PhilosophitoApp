package kourtis.quadrum.philosophito.ui.main.data;

public class ExtraItem {

    private String link;
    private String title;
    private String description;

    public ExtraItem(String link, String title, String description) {
        this.link = link;
        this.title = title;
        this.description = description;
    }

    public ExtraItem() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DictionaryItem{" +
                "link='" + link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
