package rc.diego.model.persistence;

/**
 * Created by entakitos on 17/02/16.
 */
public class MySqlRepository extends AbstractRepository {

    @Override
    void initializeData() {
        this.DAOPedidos = new PedidosMySqlDAO();
    }
}
