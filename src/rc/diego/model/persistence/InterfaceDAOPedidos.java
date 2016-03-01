package rc.diego.model.persistence;

import rc.diego.model.entities.Pedido;

import java.util.List;

/**
 * Created by entakitos on 17/02/16.
 */
public interface InterfaceDAOPedidos {
    String getTestData();
    void insertarPedido(Pedido pedido);
}
