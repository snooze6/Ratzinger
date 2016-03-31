package rc.diego.model.persistence;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.*;

/**
 * Created by entakitos on 17/02/16.
 */
public class DAOPedidosMySQL extends AbstractDAOMySQL implements InterfaceDAOPedidos {

    PreparedStatement insertOrder = null;
    PreparedStatement insertProductOrder = null;

    String insertOrderSQL = "INSERT INTO "+ MySQLContract.Orders.TABLE_NAME+"(`"+MySQLContract.Orders.USER_DNI +"``,`"+MySQLContract.Orders.TOTAL+"`)  VALUES(?,?)";
    final String maxOrderIdSQL = "SELECT MAX(" + MySQLContract.Orders.ID + ") as "+MySQLContract.Orders.ID+" FROM "+ MySQLContract.Orders.TABLE_NAME + " LIMIT 1;";
    String insertProductSQL = "INSERT INTO "+MySQLContract.OrderProducsts.TABLE_NAME+"(`"+MySQLContract.OrderProducsts.ID_ORDER+"`,`"+MySQLContract.OrderProducsts.ID_PRODUCT+"`,`"+MySQLContract.OrderProducsts.UNITARY_PRICE+"`,`"+MySQLContract.OrderProducsts.QUANTITY+"`) VALUES(?,?,?,?);";

    @Override
    public void insertarPedido(VOUser user, VOShoppingCart carrito) throws SQLException {

        try {
            getConnection().setAutoCommit(false);

            if(insertOrder == null)
                insertOrder = getConnection().prepareStatement(insertOrderSQL);

            insertOrder.setString(1, user.getDNI());

            final float[] total = {0};
            carrito.forEach((s, voCd) -> {
                total[0] +=voCd.getQuantity()*voCd.getUnitaryPrice();
            });

            insertOrder.setFloat(2, total[0]);

            int row=insertOrder.executeUpdate();

            ResultSet setId=getConnection().createStatement().executeQuery(maxOrderIdSQL);

            if(setId.next()) {

                int maxId=setId.getInt(MySQLContract.Orders.ID);
                System.out.println("ID2 --> "+setId);

                carrito.forEach((s,product) -> {
                    try {
                        if (insertProductOrder == null)
                            insertProductOrder = getConnection().prepareStatement(insertProductSQL);

                        insertProductOrder.setInt(1,maxId);
                        insertProductOrder.setInt(2,product.getId());
                        insertProductOrder.setFloat(3,product.getUnitaryPrice());
                        insertProductOrder.setInt(4,product.getQuantity());

                        insertProductOrder.executeUpdate();

                    } catch (SQLException e) {
                        //TODO: CONTROLAR QUE SI FALLA A TRANSACCION SE INTERRUMPA A TRANSACCION
                        e.printStackTrace();
                    }

                });

                getConnection().commit();
                getConnection().setAutoCommit(true);
            }else{
                //TODO TERMINAR A EJECUCION DA CONSULTA E TIRAR UN ERROR
            }

        } catch (SQLException e ) {
            e.printStackTrace();
            if (getConnection() != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    getConnection().rollback();
                    getConnection().setAutoCommit(true);
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
            getConnection().setAutoCommit(true);
        }
    }

    public DAOPedidosMySQL() {
        super();
    }
}
