package rc.diego.model.task;

import rc.diego.entities.Product;
import rc.diego.entities.User;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class addProduct  implements InterfaceTask {
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

    public addProduct(HashMap<String,Product>  shoppingCart, Product product) {
        this.shoppingCart = shoppingCart;
        this.product = product;
    }

    @Override
    public void run() {

        if(shoppingCart.containsKey(product.getName())){
            Product p=shoppingCart.get(product.getName());
            p.setQuantity(p.getQuantity() + product.getQuantity());
        }else{
            shoppingCart.put(product.getName(),product);
        }

    }
}
