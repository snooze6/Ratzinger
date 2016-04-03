package rc.diego.model.VO;

/**
 * Created by entakitos on 20/02/16.
 */
public class VOCd extends BaseEntity{

    private int id;
    private String title;
    private String description;
    private String author;
    private String country;
    private float unitaryPrice;
    private int quantity; //usase quantity en vez de stock, porque así podemos usar a mesma clase para representarostck de CDs como para representar unha cantidad determinada seleccionada
    private String image;

    public String getImage() {
        return image;
    }

    public VOCd setImage(String image) {
        this.image = image;
        return this;
    }

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

    public float getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(float unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public VOCd() {

    }

    public VOCd(int id, String title, String description, String author, String country, float unitaryPrice, int quantity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.country = country;
        this.unitaryPrice = unitaryPrice;
        this.quantity = quantity;
    }
}
