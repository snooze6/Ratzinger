package rc.diego.model.persistence.VO;

import java.sql.Date;

/**
 * Created by entakitos on 11/03/16.
 */
public class VOOrder {
    private int id;
    private String user;
    private String email;
    private float total;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public VOOrder(int id) {
        this.id = id;
    }

    public VOOrder(int id, String user, String email, float total, Date date) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.total = total;
        this.date = date;
    }
}
