package rc.diego.model.VO;

/**
 * Created by entakitos on 11/03/16.
 */
public class VOOrdersLine {
    private VOOrder order;
    private VOCd cd;
    private float unitaryPrice;
    private int quantity;

    public VOOrder getOrder() {
        return order;
    }

    public void setOrder(VOOrder order) {
        this.order = order;
    }

    public VOCd getCd() {
        return cd;
    }

    public void setCd(VOCd cd) {
        this.cd = cd;
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

    public VOOrdersLine() {

    }

    public VOOrdersLine(VOOrder order, VOCd cd, float unitaryPrice, int quantity) {
        this.order = order;
        this.cd = cd;
        this.unitaryPrice = unitaryPrice;
        this.quantity = quantity;
    }
}
