package rc.diego.entities;

/**
 * Created by entakitos on 20/02/16.
 */
public class Product extends BaseEntity{
    protected String name;
    protected String description;
    protected float unitaryPrice;
    protected int quantity;

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
}
