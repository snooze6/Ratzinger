package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.*;

/**
 * Created by entakitos on 17/02/16.
 */
public class DAOPedidosMySQL extends AbstractDAOMySQL implements InterfaceDAOPedidos {

    private PreparedStatement insertOrder = null;
    private PreparedStatement insertProductOrder = null;

    private String insertOrderSQL = "INSERT INTO "+ MySQLContract.Orders.TABLE_NAME+"(`"+
            MySQLContract.Orders.USER_DNI +
            "`,`"+MySQLContract.Orders.TOTAL+
            "`) VALUES(?,?);";

    private final String maxOrderIdSQL = "SELECT MAX(" + MySQLContract.Orders.ID + ") as "+MySQLContract.Orders.ID+
            " FROM "+ MySQLContract.Orders.TABLE_NAME + " LIMIT 1;";

    private String insertProductSQL = "INSERT INTO "+MySQLContract.OrderProducsts.TABLE_NAME+"(`"+
            MySQLContract.OrderProducsts.ID_ORDER+"`,`"+
            MySQLContract.OrderProducsts.ID_PRODUCT+"`,`"+
            MySQLContract.OrderProducsts.UNITARY_PRICE+"`,`"+
            MySQLContract.OrderProducsts.QUANTITY+"`) VALUES(?,?,?,?);";

    @Override
    public boolean insertOrder(VOUser user, VOShoppingCart carrito) throws SQLException {

        try {
            getConnection().setAutoCommit(false);

            //CREASE O PEDIDO NA TABLA ORDERS
            if(insertOrder == null)
                insertOrder = getConnection().prepareStatement(insertOrderSQL);

            insertOrder.setString(1, user.getDNI());

            final float[] total = {0};
            carrito.forEach((s, voCd) -> {
                total[0] +=voCd.getQuantity()*voCd.getUnitaryPrice();
            });

            if (user.isVip())
                insertOrder.setFloat(2, total[0]);
            else
                insertOrder.setFloat(2, total[0] * 0.8F);

            insertOrder.executeUpdate();

            //OBTENSE O ID QUE SE ASIGNOU AUTOMATICAMENTE NA BASE DE DATOS AO PEDIDO QUE SE ACABA DE CREAR
            ResultSet setId=getConnection().createStatement().executeQuery(maxOrderIdSQL);

            if(setId.next()) {

                int maxId=setId.getInt(MySQLContract.Orders.ID);

                //INTRODUCESE NA BASE DE DATOS CADA UNHA DAS LINEAS QUE CONFORMAN O PEDIDO
                for(VOCd product: carrito.values()){
                    try {
                        if (insertProductOrder == null)
                            insertProductOrder = getConnection().prepareStatement(insertProductSQL);

                        VOCd cd =new VOCd();
                        cd.setId(product.getId());

                        DAOCdsMySQL daoCds=new DAOCdsMySQL();
                        if(daoCds.getCD(cd) && cd.getQuantity() >= product.getQuantity()) {

                            cd.setQuantity(cd.getQuantity() - product.getQuantity());

                            new DAOCdsMySQL().updateCDQuantity(cd);

                            insertProductOrder.setInt(1, maxId);
                            insertProductOrder.setInt(2, product.getId());

                            if (user.isVip())
                                insertProductOrder.setFloat(3, product.getUnitaryPrice() * 0.8F);
                            else
                                insertProductOrder.setFloat(3, product.getUnitaryPrice());

                            insertProductOrder.setInt(4, product.getQuantity());

                            insertProductOrder.executeUpdate();
                        }else{
                            return false;
                        }
                    } catch (SQLException e) {
                        //TODO: CONTROLAR QUE SI FALLA A TRANSACCION SE INTERRUMPA A TRANSACCION
                        e.printStackTrace();
                        try {
                            getConnection().rollback();
                            getConnection().setAutoCommit(true);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        return false;

                    }
                }

                getConnection().commit();
                getConnection().setAutoCommit(true);
            }else{
                getConnection().rollback();
                getConnection().setAutoCommit(true);
                return false;

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

            return false;

        } finally {
            if (insertProductOrder != null) {
                insertProductOrder.close();
            }
            if (insertProductOrder != null) {
                insertProductOrder.close();
            }
            getConnection().setAutoCommit(true);
            getConnection().close();
        }

        return true;
    }

    public DAOPedidosMySQL() {
        super();
    }
}
