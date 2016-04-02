package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/03/16.
 */
public class AbstractFactoryMySQL implements InterfaceDAOFactory{

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
