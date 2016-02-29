package rc.diego.model.entities;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class User extends BaseEntity{

    public final static String SESSION_ATTRIBUTE_USER="usuario";
    public final static String PARAMETER_NAME ="nombre";
    public final static String PARAMETER_MAIL ="email";

    private String name;
    private String eMail;
    private HashMap<String,Product> shoppingCart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public HashMap<String,Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String,Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public User(){
        this.shoppingCart = new HashMap<>();
    }

}
