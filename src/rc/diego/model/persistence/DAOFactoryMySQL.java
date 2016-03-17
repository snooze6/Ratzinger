package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/03/16.
 */
public class DAOFactoryMySQL implements InterfaceDAOFactory{

    @Override
    public InterfaceDAOPedidos getDAOPedidos() {
        return new DAOPedidosMySQL();
    }
}
