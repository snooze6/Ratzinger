package rc.diego.model.task;

import rc.diego.model.VO.VOCd;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class resetShoppingCart implements InterfaceTask {
    private HashMap<String,VOCd> shoppingCart;

    public HashMap<String,VOCd>  getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String,VOCd>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public resetShoppingCart(HashMap<String,VOCd>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    @Override
    public void run() {

        shoppingCart.clear();

    }
}
