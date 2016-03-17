package rc.diego.model.VO;

/**
 * Created by entakitos on 1/03/16.
 */
public class VOOrder extends BaseEntity{
    private int id;
    private String user;
    private float total;
    private java.sql.Date date;

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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public VOOrder(int id) {
        this.id = id;
    }

    public VOOrder(int id, String user, String email, float total, java.sql.Date date) {
        this.id = id;
        this.user = user;
        this.total = total;
        this.date = date;
    }
}
