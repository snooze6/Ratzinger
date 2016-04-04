package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.DataManager;

/**
 * Created by pablo on 3/4/16.
 */
public class getCDsByFilter implements InterfaceTask {
    private VOShoppingCart shoppingCart;
    String filter = "";


    public VOShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(VOShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public void run() {
        shoppingCart = DataManager.getDAOCds().getCDsByFilter(filter);
    }
}
