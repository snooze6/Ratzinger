package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.MySQL.AbstractFactoryMySQL;
import rc.diego.model.persistence.AbstractDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllCdsFromDataBase implements InterfaceTask{
    private VOShoppingCart shoppingCart;

    public VOShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(VOShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        shoppingCart = DataManager.getDAOCds().getAllCDs();
    }
}
