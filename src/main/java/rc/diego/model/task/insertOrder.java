package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DAOFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;

/**
 * Created by entakitos on 6/03/16.
 */
public class insertOrder implements InterfaceTask {

    private InterfaceDAOFactory daoFactory= new DAOFactoryMySQL();
    private VOUser user;
    private VOShoppingCart carrito;

    public InterfaceDAOFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(InterfaceDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser user) {
        this.user = user;
    }

    public VOShoppingCart getCarrito() {
        return carrito;
    }

    public void setCarrito(VOShoppingCart carrito) {
        this.carrito = carrito;
    }

    @Override
    public void run() {
        try {
            daoFactory.getDAOPedidos().insertarPedido(user,carrito);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public insertOrder(VOUser user, VOShoppingCart carrito) {
        this.user = user;
        this.carrito = carrito;
    }
}
