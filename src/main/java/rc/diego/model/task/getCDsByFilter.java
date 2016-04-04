package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by pablo on 3/4/16.
 */
public class getCDsByFilter implements InterfaceTask {
    private VOShoppingCart shoppingCart;
    private InterfaceDAOFactory daoFactory;
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
        daoFactory = new AbstractFactoryMySQL();
        shoppingCart = daoFactory.getDAOCds().getCDsByFilter(filter);
    }
}
