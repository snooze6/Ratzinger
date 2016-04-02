package rc.diego.model.persistence;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;

import java.sql.SQLException;

/**
 * Created by entakitos on 17/02/16.
 */
public interface InterfaceDAOPedidos {
    boolean insertOrder(VOUser user, VOShoppingCart carrito) throws SQLException;
}
