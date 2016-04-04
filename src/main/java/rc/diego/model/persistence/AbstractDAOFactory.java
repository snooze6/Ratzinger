package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public abstract class AbstractDAOFactory {

    public abstract InterfaceDAOPedidos getDAOPedidos();
    public abstract  InterfaceDAOCds getDAOCds();
    public abstract  InterfaceDAOUsers getDAOUsers();
}
