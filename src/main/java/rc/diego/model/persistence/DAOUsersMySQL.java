package rc.diego.model.persistence;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by entakitos on 31/03/16.
 */
public class DAOUsersMySQL extends AbstractDAOMySQL implements  InterfaceDAOUsers{

    PreparedStatement insertUser = null;

    String insertUserSQL = "INSERT INTO `"+ MySQLContract.Users.TABLE_NAME+"` (`"+
            MySQLContract.Users.DNI+"`,`"+
            MySQLContract.Users.firstName+"`,`"+
            MySQLContract.Users.lastName+"`,`"+
            MySQLContract.Users.mail+"`,`"+
            MySQLContract.Users.password+
            "`)  VALUES(?,?,?,?,?);";

    @Override
    public void inserteUser(VOUser user) throws SQLException {

        try {

            if(insertUser == null)
                insertUser=getConnection().prepareStatement(insertUserSQL);

            insertUser.setString(1,user.getDNI());
            insertUser.setString(2,user.getFirstName());
            insertUser.setString(3,user.getLastName());
            insertUser.setString(4,user.geteMail());
            insertUser.setString(5,user.getPassword());

            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(insertUser.toString());

            insertUser.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(insertUser != null)
                insertUser.close();
        }

//        if(insertOrder == null)
//            insertOrder = getConnection().prepareStatement(insertOrderSQL);
//
//        insertOrder.setString(1, user.getFirstName());
//        insertOrder.setString(2, user.geteMail());
//
//        final float[] total = {0};
//        carrito.forEach((s, voCd) -> {
//            total[0] +=voCd.getQuantity()*voCd.getUnitaryPrice();
//        });
//
//        insertOrder.setFloat(3, total[0]);
//
//        int row=insertOrder.executeUpdate();
    }
}
