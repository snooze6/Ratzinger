package rc.diego.model.entities;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by entakitos on 1/03/16.
 */
public class Pedido {
    private int ID;
    private User user;
    private Date date;
    private float total;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Pedido(User user, Date date, float total) {
        this.user = user;
        this.date = date;
        this.total = total;
    }
}
