package dongukc.model;

public class Quote {

    private Long id;
    private String text;
    private String source;
    private String authorName;
    

    public Quote() {}

    public Quote(String text, String source, String authorName) {
        this.text = text;
        this.source = source;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return String.format("Quote[id=%d, text='%s', by='%s']", this.id, this.text, this.authorName);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }
    
    
}