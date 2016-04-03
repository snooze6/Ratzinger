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

    /*
     * Prepared Statements, such faster, such secure, wow
     */
    private PreparedStatement updateCDQuantityStatement = null;
    private PreparedStatement updateCD = null;
    private PreparedStatement getCD = null;
    private PreparedStatement insertCD = null;
    private PreparedStatement getLastId = null;

    private final String getProductsSQL = "SELECT * FROM "+ MySQLContract.Products.TABLE_NAME + " NATURAL JOIN "+MySQLContract.Quantities.TABLE_NAME+";";

    private String updateCDQuantitySQL = "UPDATE `"+ MySQLContract.Quantities.TABLE_NAME
            +"` SET "+MySQLContract.Quantities.QUANT+"=? " +
            "WHERE "+MySQLContract.Quantities.ID+"=?;";

    private String getProductSQL = "SELECT * FROM `"+ MySQLContract.Products.TABLE_NAME +
            "` NATURAL JOIN `"+MySQLContract.Quantities.TABLE_NAME+
            "` WHERE "+MySQLContract.Products.ID+"=? "+" LIMIT 1;";

    private String updateCDSQL = "UPDATE "+MySQLContract.Products.TABLE_NAME+
            " SET "+MySQLContract.Products.AUTHOR+"=? "+
            ", "+MySQLContract.Products.COUNTRY+"=? "+
            ", "+MySQLContract.Products.DESCRIPTION+"=? "+
            ", "+MySQLContract.Products.IMAGE+"=? "+
            ", "+MySQLContract.Products.NAME+"=? "+
            ", "+MySQLContract.Products.UNITARY_PRICE+"=?"+
            " WHERE "+MySQLContract.Products.ID+"=?; ";

    private String insertCDSQL = "INSERT INTO "+MySQLContract.Products.TABLE_NAME+
                                 " VALUES(NULL, ?,?,?,?,?,?);";
    private String createQuantitySQL = "INSERT INTO "+MySQLContract.Quantities.TABLE_NAME+" VALUES(?,?);";
    private String deleteCDSQL = "DELETE FROM "+MySQLContract.Quantities.TABLE_NAME+" WHERE id=?";
    private String deleteQuantitySQL = "DELETE FROM "+MySQLContract.Quantities.TABLE_NAME+" WHERE id=?;";
    private String getLastIdSQL = "SELECT max(id) FROM "+MySQLContract.Products.TABLE_NAME+";";

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
            try {
                if (getCD == null) {
                    getCD = getConnection().prepareStatement(getProductSQL);
                    if (updateCDQuantityStatement == null)
                        updateCDQuantityStatement = getConnection().prepareStatement(updateCDQuantitySQL);
                }

                getCD.setInt(1, cd.getId());

                ResultSet results = getCD.executeQuery();

                if (results.next()) {
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
            } finally {
                close(getCD);
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
            try {
                updateCDQuantityStatement.close();
                updateCDQuantityStatement=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean updateCD(VOCd cd) {
        try {
            if (updateCD == null)
                updateCD = getConnection().prepareStatement(updateCDSQL);

            updateCD.setString(1, cd.getAuthor());
            updateCD.setString(2, cd.getCountry());
            updateCD.setString(3, cd.getDescription());
            updateCD.setString(4, cd.getImage());
            updateCD.setString(5, cd.getTitle());
            updateCD.setFloat(6, cd.getUnitaryPrice());
            updateCD.setInt(7, cd.getId());

//            System.err.println("DEBUG");
//            System.err.println("=================");
//            System.err.println(updateCD.toString());

            updateCD.executeUpdate();
            updateCDQuantity(cd);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            close(updateCD);
        }
        return true;
    }

    private void close(PreparedStatement stat) {
        //TODO: Destruir esto
        if (stat != null)
            try {
                stat.close();
                //getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public boolean create(VOCd cd) {
        try {
            if (insertCD == null)
                insertCD = getConnection().prepareStatement(insertCDSQL);

            insertCD.setString(1, cd.getTitle());
            insertCD.setString(2, cd.getDescription());
            insertCD.setString(3, cd.getAuthor());
            insertCD.setString(4, cd.getCountry());
            insertCD.setFloat(5, cd.getUnitaryPrice());
            insertCD.setString(6, cd.getImage());
            System.err.println("Creating CD");
            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(insertCD.toString());

            insertCD.executeUpdate();
            cd.setId(getLastId());
            createQuant(cd);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            close(insertCD);
        }
        return true;
    }

    private boolean createQuant(VOCd cd) {
        String createQuantitySQL = "INSERT INTO "+MySQLContract.Quantities.TABLE_NAME+" VALUES("+cd.getId()+","+cd.getQuantity()+");";

        VOShoppingCart sc = new VOShoppingCart();
        try {
            getConnection().createStatement().executeUpdate(createQuantitySQL);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private int getLastId(){
        try {
            if (getLastId == null)
                getLastId = getConnection().prepareStatement(getLastIdSQL);

            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(getLastId.toString());

            ResultSet r = getLastId.executeQuery();

            if (r.next()){
                return r.getInt("max(id)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            close(getLastId);
        }
        return 0;
    }

    @Override
    public boolean deleteCD(VOCd cd) {
        String deleteCDSQL = "DELETE FROM "+MySQLContract.Quantities.TABLE_NAME+" WHERE id="+cd.getId();
        String deleteQuantitySQL = "DELETE FROM "+MySQLContract.Quantities.TABLE_NAME+" WHERE id="+cd.getId();

        try {
            getConnection().createStatement().executeUpdate(deleteQuantitySQL);
            getConnection().createStatement().executeUpdate(deleteCDSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
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
