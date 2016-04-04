package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by entakitos on 17/03/16.
 */
public class DAOCdsMySQL extends AbstractDAOMySQL implements InterfaceDAOCds {

    private final String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME + " NATURAL JOIN "+MySQLContract.Quantities.TABLE_NAME+";";

    private PreparedStatement updateCDQuantityStatement = null;
    private String updateCDQuantitySQL = "UPDATE `"+ MySQLContract.Quantities.TABLE_NAME
            +"` SET "+MySQLContract.Quantities.QUANT+"=? " +
            "WHERE "+MySQLContract.Quantities.ID+"=?;";


    private final String getProductsByFilter = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME + " NATURAL JOIN "+MySQLContract.Quantities.TABLE_NAME+
            " WHERE LOWER( " + MySQLContract.Products.NAME +" ) LIKE ? OR "+
            " LOWER( " + MySQLContract.Products.AUTHOR +" ) LIKE ? OR "+
            " LOWER( " + MySQLContract.Products.COUNTRY +" ) LIKE ? OR "+
            " LOWER( " + MySQLContract.Products.DESCRIPTION +" ) LIKE ? ";



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
    public VOShoppingCart getCDsByFilter(String filter){

        VOShoppingCart sc = new VOShoppingCart();

        try {

            if(filter.trim().length()==0) {
                return sc;
            }

            String finalQuery = getProductsByFilter;
            if(filter.split(" ").length>1) {
                for(int i = 1; i<filter.split(" ").length;i++){
                    finalQuery = finalQuery + " UNION ";
                    finalQuery = finalQuery + getProductsByFilter;

                }
            }
            finalQuery  = finalQuery + " ;";
            System.out.println(filter.split(" ").length);
            System.out.println(finalQuery);

            PreparedStatement  statement = getConnection().prepareStatement(finalQuery);
            for(int i = 0; i<filter.split(" ").length;i++){
                statement.setString((i*4)+1, "%"+filter.split(" ")[i] +"%");
                statement.setString((i*4)+2, "%"+filter.split(" ")[i] +"%");
                statement.setString((i*4)+3, "%"+filter.split(" ")[i] +"%");
                statement.setString((i*4)+4, "%"+filter.split(" ")[i] +"%");
            }



            ResultSet results=statement.executeQuery();



            while(results.next()){
                VOCd cd=new VOCd();

                System.out.println("ALGOOOO");

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
