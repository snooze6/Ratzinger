package rc.diego.entities;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class User extends BaseEntity{
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
