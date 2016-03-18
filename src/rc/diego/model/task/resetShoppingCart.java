package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class resetShoppingCart implements InterfaceTask {
    private VOShoppingCart shoppingCart;

    public VOShoppingCart  getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(VOShoppingCart  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public resetShoppingCart(VOShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    @Override
    public void run() {

        shoppingCart.clear();

    }
}
