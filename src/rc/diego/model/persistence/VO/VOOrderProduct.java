package rc.diego.model.persistence.VO;

/**
 * Created by entakitos on 11/03/16.
 */
public class VOOrderProduct {
    private VOOrder order;
    private VOProduct product;
    private float unitaryPrice;
    private int quantity;

    public VOOrder getOrder() {
        return order;
    }

    public void setOrder(VOOrder order) {
        this.order = order;
    }

    public VOProduct getProduct() {
        return product;
    }

    public void setProduct(VOProduct product) {
        this.product = product;
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

    public VOOrderProduct() {

    }

    public VOOrderProduct(VOOrder order, VOProduct product, float unitaryPrice, int quantity) {
        this.order = order;
        this.product = product;
        this.unitaryPrice = unitaryPrice;
        this.quantity = quantity;
    }
}
