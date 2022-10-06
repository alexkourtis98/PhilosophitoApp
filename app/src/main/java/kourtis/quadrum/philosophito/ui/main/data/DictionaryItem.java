package kourtis.quadrum.philosophito.ui.main.data;

public class DictionaryItem {

    private String title;
    private String definition;
    private String source;

    public DictionaryItem(String title, String definition, String source) {
        this.title = title;
        this.definition = definition;
        this.source = source;
    }

    public DictionaryItem() {
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
