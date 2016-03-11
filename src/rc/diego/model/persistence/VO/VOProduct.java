package rc.diego.model.persistence.VO;

/**
 * Created by entakitos on 11/03/16.
 */
public class VOProduct {
    private int id;
    private String name;
    private String description;
    private String author;
    private String country;
    private float unitary_price;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getUnitary_price() {
        return unitary_price;
    }

    public void setUnitary_price(float unitary_price) {
        this.unitary_price = unitary_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public VOProduct() {

    }

    public VOProduct(int id, String name, String description, String author, String country, float unitary_price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.country = country;
        this.unitary_price = unitary_price;
        this.quantity = quantity;
    }
}
