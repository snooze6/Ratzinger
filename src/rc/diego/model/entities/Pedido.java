package rc.diego.model.entities;

import java.util.Date;

/**
 * Created by entakitos on 1/03/16.
 */
public class Pedido {
    private int ID;
    private String usuario;
    private Date date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
