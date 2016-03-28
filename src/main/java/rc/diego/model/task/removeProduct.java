package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;

/**
 * Created by entakitos on 20/02/16.
 */
public class removeProduct implements InterfaceTask {
    private VOShoppingCart shoppingCart;
    private VOCd VOCd;

    public VOShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(VOShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public VOCd getVOCd() {
        return VOCd;
    }

    public void setVOCd(VOCd VOCd) {
        this.VOCd = VOCd;
    }

    public removeProduct(VOShoppingCart shoppingCart, VOCd VOCd) {
        this.shoppingCart = shoppingCart;
        this.VOCd = VOCd;
    }

    @Override
    public void run() {

        if(shoppingCart.containsKey(VOCd.getId())){
            shoppingCart.remove(VOCd.getId());
        }

    }
}
