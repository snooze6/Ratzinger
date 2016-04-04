package rc.diego.model.VO;

import rc.diego.model.persistence.MySQL.Connector.MySQLContract;

/**
 * Created by entakitos on 20/02/16.
 */
public class VOUser extends BaseEntity{

    public final static String SESSION_ATTRIBUTE_USER="usuario";
    public final static String PARAMETER_FIRST_NAME ="nombre";
    public final static String PARAMETER_LAST_NAME ="apellidos";
    public final static String PARAMETER_MAIL ="email";
    public final static String PARAMETER_PASSWORD ="password";
    public final static String PARAMETER_DNI ="dni";

    private String name;
    private String lastName;
    private String DNI;
    private String eMail;
    private String password;
    private String images;
    private boolean active;
    private boolean vip;



    private MySQLContract.Tipo tipo = MySQLContract.Tipo.normal;

    public MySQLContract.Tipo getTipo() {
        return tipo;
    }

    public boolean isActive() {
        return active;
    }

    public VOUser setActive(boolean active) {
        this.active = active;
        return this;
    }

    public boolean isAdmin(){
        return tipo == MySQLContract.Tipo.admin;
    }

    public String getImages() {
        return images;
    }

    public VOUser setImages(String images) {
        this.images = images;
        return this;
    }

    public VOUser setTipo(MySQLContract.Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Usuario: "+name+" - DNI: "+DNI+" - Email: "+eMail+" - Admin: "+tipo+" - VIP: "+vip+" - Active: "+active;
    }
}
