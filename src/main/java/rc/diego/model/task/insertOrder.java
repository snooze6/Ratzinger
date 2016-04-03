package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.DAOPedidosMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;

/**
 * Created by entakitos on 6/03/16.
 */
public class insertOrder implements InterfaceTask {

    private InterfaceDAOFactory daoFactory= new AbstractFactoryMySQL();
    private VOUser user;
    private VOShoppingCart carrito;
    private boolean enoughStock=false;

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

    public boolean isEnough() {
        return enoughStock;
    }

    @Override
    public void run() {
        try {
            System.out.println("YES");
            enoughStock=daoFactory.getDAOPedidos().insertOrder(user,carrito);
            System.out.println("YES2");
            if(!user.isVip() && daoFactory.getDAOUsers().checkVipCondition(user)) {
                System.out.println("YES3");
                daoFactory.getDAOUsers().makeVip(user);
                System.out.println("YES4");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public insertOrder(VOUser user, VOShoppingCart carrito) {
        this.user = user;
        this.carrito = carrito;
    }
}
