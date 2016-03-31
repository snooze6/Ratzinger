package rc.diego.model.persistence;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.Connector.MySQLContract;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    }

    @Override
    public boolean getUser(VOUser user) throws SQLException {

        String checkUser="SELECT * FROM `"+MySQLContract.Users.TABLE_NAME+
                "` WHERE "+
                MySQLContract.Users.DNI+"='"+user.getDNI()+"' AND "+
                MySQLContract.Users.password+"='"+user.getPassword()+"' LIMIT 1;";

        System.err.println("DEBUG");
        System.err.println("=================");
        System.err.println(checkUser);

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);

        if(result.next()) {

            user.setFirstName(result.getString(MySQLContract.Users.firstName));
            user.setLastName(MySQLContract.Users.lastName);
            user.seteMail(MySQLContract.Users.mail);

            return true;
        }else {
            return false;
        }
    }
}
