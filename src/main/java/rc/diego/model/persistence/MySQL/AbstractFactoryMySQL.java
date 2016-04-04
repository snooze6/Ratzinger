package rc.diego.model.persistence.MySQL;

import rc.diego.model.persistence.*;

/**
 * Created by entakitos on 17/03/16.
 */
public class AbstractFactoryMySQL extends AbstractDAOFactory {

    @Override
    public InterfaceDAOPedidos getDAOPedidos() {
        return new DAOPedidosMySQL();
    }

    @Override
    public InterfaceDAOCds getDAOCds() {
        return new DAOCdsMySQL();
    }

    @Override
    public InterfaceDAOUsers getDAOUsers() {
        return new DAOUsersMySQL();
    }

}
