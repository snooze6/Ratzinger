package rc.diego.model.persistence;

import rc.diego.model.entities.Pedido;

/**
 * Created by entakitos on 17/02/16.
 */
public class PedidosMySqlDAO implements InterfaceDAOPedidos {
    @Override
    public String getTestData() {
        return "HELLO WORLD";
    }

    @Override
    public void insertarPedido(Pedido pedido) {

    }
}
