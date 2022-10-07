package kourtis.quadrum.philosophito.ui.main.data;

public class DictionaryItem {

    private String title;
    private String definition;
    private String source;
    private int id;

    public DictionaryItem(String title, String definition, String source, int id) {
        this.title = title;
        this.definition = definition;
        this.source = source;
        this.id = id;
    }

    public DictionaryItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
                ", source='" + source + '\'' +
                '}';
    }
}
