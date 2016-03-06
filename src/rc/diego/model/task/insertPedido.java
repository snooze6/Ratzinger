package rc.diego.model.task;

import rc.diego.model.entities.Pedido;
import rc.diego.model.persistence.AbstractRepositoryManager;
import rc.diego.model.persistence.CustomRepositoryManager;

import java.sql.SQLException;

/**
 * Created by entakitos on 6/03/16.
 */
public class insertPedido implements InterfaceTask {

    private AbstractRepositoryManager repo= new CustomRepositoryManager();
    private Pedido pedido;

    public AbstractRepositoryManager getRepo() {
        return repo;
    }

    public void setRepo(AbstractRepositoryManager repo) {
        this.repo = repo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try {
            repo.getDAOPedidos().insertarPedido(pedido);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public insertPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
