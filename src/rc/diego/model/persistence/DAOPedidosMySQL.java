package rc.diego.model.persistence;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.Connector.MySQLContract;
import rc.diego.model.persistence.Connector.MySqlConnector;

import java.sql.*;

/**
 * Created by entakitos on 17/02/16.
 */
public class DAOPedidosMySQL implements InterfaceDAOPedidos {

    private Connection con;

    PreparedStatement insertOrder = null;
    PreparedStatement insertProductOrder = null;

    String insertOrderSQL = "INSERT INTO "+ MySQLContract.Orders.TABLE_NAME+"(`"+MySQLContract.Orders.USER+"`,`"+MySQLContract.Orders.EMAIL+"`,`"+MySQLContract.Orders.TOTAL+"`)  VALUES(?,?,?)";
    final String maxOrderIdSQL = "SELECT MAX(" + MySQLContract.Orders.ID + ") as "+MySQLContract.Orders.ID+" FROM "+ MySQLContract.Orders.TABLE_NAME + " LIMIT 1;";
    String insertProductSQL = "INSERT INTO "+MySQLContract.OrderProducsts.TABLE_NAME+"(`"+MySQLContract.OrderProducsts.ID_ORDER+"`,`"+MySQLContract.OrderProducsts.ID_PRODUCT+"`,`"+MySQLContract.OrderProducsts.UNITARY_PRICE+"`,`"+MySQLContract.OrderProducsts.QUANTITY+"`) VALUES(?,?,?,?);";

    @Override
    public void insertarPedido(VOUser user, VOShoppingCart carrito) throws SQLException {

        try {
            con.setAutoCommit(false);

            if(insertOrder == null)
                insertOrder = con.prepareStatement(insertOrderSQL);
//            insertOrder = con.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);

            insertOrder.setString(1, user.getName());
            insertOrder.setString(2, user.geteMail());

            final float[] total = {0};
            carrito.forEach((s, voCd) -> {
                total[0] +=voCd.getQuantity()*voCd.getUnitaryPrice();
            });

            insertOrder.setFloat(3, total[0]);

            int row=insertOrder.executeUpdate();

//            ResultSet generatedKeys=insertOrder.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                int id = generatedKeys.getInt(MySQLContract.Orders.ID);
//                System.out.println("ID --> "+id);
//            }


            ResultSet setId=con.createStatement().executeQuery(maxOrderIdSQL);

            if(setId.next()) {

                int maxId=setId.getInt(MySQLContract.Orders.ID);
                System.out.println("ID2 --> "+setId);

                carrito.forEach((s,product) -> {
                    try {
                        if (insertProductOrder == null)
                            insertProductOrder=con.prepareStatement(insertProductSQL);

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

                con.commit();
            }else{
                //TODO TERMINAR A EJECUCION DA CONSULTA E TIRAR UN ERROR
            }

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

    public DAOPedidosMySQL() {
        try {
            this.con = new MySqlConnector().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
