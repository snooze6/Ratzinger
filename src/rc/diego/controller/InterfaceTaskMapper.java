package rc.diego.controller;

import rc.diego.model.entities.Product;
import rc.diego.model.entities.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public interface InterfaceTaskMapper {
    void initializeShoppingCart(HashMap<String,Product> shoppingCart);
    void addToShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void removeFromShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void updateShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void initializeSession(HttpSession session);
    void setUserData(String name, String email, User user);
    void pay(User user);
}
