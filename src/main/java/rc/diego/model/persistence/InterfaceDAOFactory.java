package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public interface InterfaceDAOFactory {
    InterfaceDAOPedidos getDAOPedidos();
    InterfaceDAOCds getDAOCds();
    InterfaceDAOUsers getDAOUsers();
}
