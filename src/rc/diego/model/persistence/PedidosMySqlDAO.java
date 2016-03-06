package rc.diego.model.persistence;

import rc.diego.model.entities.Pedido;
import rc.diego.model.persistence.Connector.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by entakitos on 17/02/16.
 */
public class PedidosMySqlDAO implements InterfaceDAOPedidos {

    private Connection con;

    PreparedStatement insertOrder = null;
    PreparedStatement insertProductOrder = null;

    String insertOrderSQL = "INSERT INTO orders  (`user`,`email`,`total`)  VALUES(?,?,?)";
    //String insertProductSQL = "INSERT INTO products('id_pedido','name','description','unitary_price','quantity') VALUES(?,?,?,?,?);";


    @Override
    public String getTestData() {
        return "HELLO WORLD";
    }

    @Override
    public void insertarPedido(Pedido pedido) throws SQLException {

        try {
            con.setAutoCommit(false);
            insertOrder = con.prepareStatement(insertOrderSQL);
            insertOrder.setString(1,pedido.getUser().getName());
            insertOrder.setString(2,pedido.getUser().geteMail());
            insertOrder.setFloat(3,pedido.getTotal());
            int row=insertOrder.executeUpdate();

//            pedido.getUser().getShoppingCart().entrySet().forEach(stringProductEntry -> {
//
//                stringProductEntry.getValue()
//
//            });

            con.commit();

        } catch (SQLException e ) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException excep) {
                    excep.printStackTrace();
                }
            }
        } finally {
            if (insertProductOrder != null) {
                insertProductOrder.close();
            }
            if (insertProductOrder != null) {
                insertProductOrder.close();
            }
            con.setAutoCommit(true);
        }
    }

    public PedidosMySqlDAO() {
        try {
            this.con = new MySqlConnector().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
