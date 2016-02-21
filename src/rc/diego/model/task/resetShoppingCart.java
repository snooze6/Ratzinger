package rc.diego.model.task;

import rc.diego.entities.Product;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class resetShoppingCart implements InterfaceTask {
    private HashMap<String,Product> shoppingCart;

    public HashMap<String,Product>  getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String,Product>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public resetShoppingCart(HashMap<String,Product>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    @Override
    public void run() {

        shoppingCart.clear();

    }
}
