package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.DAOFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllCdsFromDataBase implements InterfaceTask{
    private VOShoppingCart shoppingCart;
    private InterfaceDAOFactory daoFactory;

    public VOShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(VOShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        daoFactory = new DAOFactoryMySQL();
        shoppingCart = daoFactory.getDAOCds().getAllCDs();
    }
}
