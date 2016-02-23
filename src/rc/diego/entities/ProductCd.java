package rc.diego.entities;

/**
 * Created by entakitos on 20/02/16.
 */
public class ProductCd extends Product{
    protected String author;
    protected String origin;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
