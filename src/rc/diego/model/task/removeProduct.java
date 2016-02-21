package rc.diego.model.task;

import rc.diego.entities.Product;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class removeProduct extends AbstractTask {
    private HashMap<String,Product> shoppingCart;
    private Product product;

    public HashMap<String,Product>  getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String,Product>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public removeProduct(HashMap<String,Product>  shoppingCart, Product product) {
        this.shoppingCart = shoppingCart;
        this.product = product;
    }

    @Override
    void run() {

        if(shoppingCart.containsKey(product.getName())){
            shoppingCart.remove(product.getName());
        }

    }
}
