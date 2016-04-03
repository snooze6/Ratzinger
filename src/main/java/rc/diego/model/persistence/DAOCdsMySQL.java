package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by entakitos on 17/03/16.
 */
public class DAOCdsMySQL extends AbstractDAOMySQL implements InterfaceDAOCds {

    private final String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME + " NATURAL JOIN "+MySQLContract.Quantities.TABLE_NAME+";";

    private PreparedStatement updateCDQuantityStatement = null;
    private String updateCDQuantitySQL = "UPDATE `"+ MySQLContract.Quantities.TABLE_NAME
            +"` SET "+MySQLContract.Quantities.QUANT+"=? " +
            "WHERE "+MySQLContract.Quantities.ID+"=?;";

    @Override
    public VOShoppingCart getAllCDs() {

        VOShoppingCart sc = new VOShoppingCart();

        try {

            ResultSet results=getConnection().createStatement().executeQuery(getProductsSQL);

            while(results.next()){
                VOCd cd=new VOCd();

                cd.setId(results.getInt(MySQLContract.Products.ID));
                cd.setTitle(results.getString(MySQLContract.Products.NAME));
                cd.setAuthor(results.getString(MySQLContract.Products.AUTHOR));
                cd.setCountry(results.getString(MySQLContract.Products.COUNTRY));
                cd.setDescription(results.getString(MySQLContract.Products.DESCRIPTION));
                cd.setQuantity(results.getInt(MySQLContract.Quantities.QUANT));
                cd.setUnitaryPrice(results.getFloat(MySQLContract.Products.UNITARY_PRICE));
                cd.setImage(results.getString(MySQLContract.Products.IMAGE));

                sc.put(cd.getId(),cd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sc;
    }

    @Override
    public boolean getCD(VOCd cd) {

        String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME +
                " NATURAL JOIN "+MySQLContract.Quantities.TABLE_NAME+" WHERE "+MySQLContract.Products.ID+"="+cd.getId()+" LIMIT 1;";

        try {

            ResultSet results=getConnection().createStatement().executeQuery(getProductsSQL);

            if (results.next()){
                cd.setTitle(results.getString(MySQLContract.Products.NAME));
                cd.setAuthor(results.getString(MySQLContract.Products.AUTHOR));
                cd.setCountry(results.getString(MySQLContract.Products.COUNTRY));
                cd.setDescription(results.getString(MySQLContract.Products.DESCRIPTION));
                cd.setQuantity(results.getInt(MySQLContract.Quantities.QUANT));
                cd.setUnitaryPrice(results.getFloat(MySQLContract.Products.UNITARY_PRICE));
                cd.setImage(results.getString(MySQLContract.Products.IMAGE));
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateCDQuantity(VOCd cd) {

        try {
            if (updateCDQuantityStatement == null)
                updateCDQuantityStatement = getConnection().prepareStatement(updateCDQuantitySQL);

            updateCDQuantityStatement.setInt(1, cd.getQuantity());
            updateCDQuantityStatement.setInt(2, cd.getId());

            updateCDQuantityStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            if (updateCDQuantityStatement != null)
                try {
                    updateCDQuantityStatement.close();
                    getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


        }

        return true;
    }

    public DAOCdsMySQL() {
        super();
    }
}
