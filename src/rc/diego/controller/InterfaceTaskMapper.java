package rc.diego.controller;

import rc.diego.entities.Product;
import rc.diego.entities.User;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public interface InterfaceTaskMapper {
    void initializeShoppingCart(HashMap<String,Product> shoppingCart);
    void addToShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void removeFromShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void updateShoppingCart(HashMap<String,Product>  shoppingCart, Product product);
    void pay(User user);
}
