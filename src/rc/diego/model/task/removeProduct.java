package rc.diego.model.task;

import rc.diego.model.VO.VOCd;

import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public class removeProduct implements InterfaceTask {
    private HashMap<String, VOCd> shoppingCart;
    private VOCd VOCd;

    public HashMap<String, VOCd>  getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<String, VOCd>  shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public VOCd getVOCd() {
        return VOCd;
    }

    public void setVOCd(VOCd VOCd) {
        this.VOCd = VOCd;
    }

    public removeProduct(HashMap<String, VOCd>  shoppingCart, VOCd VOCd) {
        this.shoppingCart = shoppingCart;
        this.VOCd = VOCd;
    }

    @Override
    public void run() {

        if(shoppingCart.containsKey(VOCd.getTitle())){
            shoppingCart.remove(VOCd.getTitle());
        }

    }
}
