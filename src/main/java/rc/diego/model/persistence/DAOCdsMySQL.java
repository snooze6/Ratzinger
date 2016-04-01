package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by entakitos on 17/03/16.
 */
public class DAOCdsMySQL extends AbstractDAOMySQL implements InterfaceDAOCds {

    final String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME + ";";

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
                cd.setQuantity(results.getInt(MySQLContract.Products.QUANTITY));
                cd.setUnitaryPrice(results.getFloat(MySQLContract.Products.UNITARY_PRICE));

                sc.put(cd.getId(),cd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sc;
    }

    @Override
    public boolean getCD(VOCd cd) {

        String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME +
                " WHERE "+MySQLContract.Products.ID+"="+cd.getId()+";";

        try {
//            System.err.println("DEBUG");
//            System.err.println("=================");
//            System.err.println(getProductsSQL);

            ResultSet results=getConnection().createStatement().executeQuery(getProductsSQL);

            if (results.next()){
                cd.setTitle(results.getString(MySQLContract.Products.NAME));
                cd.setAuthor(results.getString(MySQLContract.Products.AUTHOR));
                cd.setCountry(results.getString(MySQLContract.Products.COUNTRY));
                cd.setDescription(results.getString(MySQLContract.Products.DESCRIPTION));
                cd.setQuantity(results.getInt(MySQLContract.Products.QUANTITY));
                cd.setUnitaryPrice(results.getFloat(MySQLContract.Products.UNITARY_PRICE));
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public DAOCdsMySQL() {
        super();
    }
}
