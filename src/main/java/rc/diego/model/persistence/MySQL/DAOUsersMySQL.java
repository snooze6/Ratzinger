package rc.diego.model.persistence.MySQL;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.InterfaceDAOUsers;
import rc.diego.model.utils.encryption.PBKDF2Encrypt;
import rc.diego.model.persistence.MySQL.Connector.MySQLContract;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by entakitos on 31/03/16.
 */
public class DAOUsersMySQL extends AbstractDAOMySQL implements InterfaceDAOUsers {

    public class UserAlreadyExistsException extends Exception{
        public UserAlreadyExistsException(String s) {
            super(s);
        }
    }

    private PreparedStatement insertUser = null;
    private String insertUserSQL = "INSERT INTO `"+ MySQLContract.Users.TABLE_NAME+"` (`"+
            MySQLContract.Users.DNI+"`,`"+
            MySQLContract.Users.firstName+"`,`"+
            MySQLContract.Users.lastName+"`,`"+
            MySQLContract.Users.mail+"`,`"+
            MySQLContract.Users.password+
            "`)  VALUES(?,?,?,?,?);";

    @Override
    public void insertUser(VOUser user) throws SQLException, UserAlreadyExistsException {

        try {

            if(insertUser == null)
                insertUser=getConnection().prepareStatement(insertUserSQL);

            insertUser.setString(1,user.getDNI());
            insertUser.setString(2,user.getFirstName());
            insertUser.setString(3,user.getLastName());
            insertUser.setString(4,user.geteMail());

            String password;
            try {
                 password= new PBKDF2Encrypt().generateStrongPasswordHash(user.getPassword());

                insertUser.setString(5,password);

//                System.err.println("DEBUG");
//                System.err.println("=================");
//                System.err.println(updateCDQuantityStatement.toString());

                insertUser.executeUpdate();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserAlreadyExistsException("Ya existe un usuario con el mismo DNI");
        } finally {
            if(insertUser != null)
                insertUser.close();

            getConnection().close();
        }

    }

    @Override
    public boolean getUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {

        String checkUser="SELECT * FROM `"+MySQLContract.Users.TABLE_NAME+
                "` WHERE "+
                MySQLContract.Users.DNI+"='"+user.getDNI()+"' LIMIT 1;";

//        System.err.println("DEBUG");
//        System.err.println("=================");
//        System.err.println(checkUser);

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);

        // Es gracioso como esto y la limitación de caracteres se carga la inyección SQL
        if(result.next() &&  new PBKDF2Encrypt().validatePassword(user.getPassword(),result.getString(MySQLContract.Users.password))) {

            user.setFirstName(result.getString(MySQLContract.Users.firstName));
            user.setLastName(result.getString(MySQLContract.Users.lastName));
            user.seteMail(result.getString(MySQLContract.Users.mail));

            isAdmin(user);

            if (isVip(user))
                user.setVip(true);
            else
                user.setVip(false);

            getConnection().close();
            return true;
        }else {
            getConnection().close();
            return false;
        }
    }

    @Override
    public boolean isAdmin(VOUser user) throws SQLException {
        String checkUser="SELECT * FROM `"+MySQLContract.Admins.TABLE_NAME+
                "` WHERE "+ MySQLContract.Users.DNI+"='"+user.getDNI()+"'  LIMIT 1;";

//        System.err.println("DEBUG");
//        System.err.println("=================");
//        System.err.println(checkUser);

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);

        boolean b= result.next();

        if (b){
            user.setTipo(MySQLContract.Tipo.admin);
            System.err.println("Es administrador");
        } else {
            user.setTipo(MySQLContract.Tipo.normal);
            System.err.println("No es administrador");
        }

        return b;
    }

    @Override
    public boolean isVip(VOUser user) throws SQLException {
        String checkUser="SELECT * FROM `"+MySQLContract.Vips.TABLE_NAME+
                "` WHERE "+ MySQLContract.Users.DNI+"='"+user.getDNI()+"'  LIMIT 1;";


        ResultSet result=getConnection().createStatement().executeQuery(checkUser);

        boolean b= result.next();



        return b;
    }

    @Override
    public boolean checkVipCondition(VOUser user) throws SQLException {
        String checkUser="SELECT sum("+MySQLContract.Orders.TOTAL+") as "+MySQLContract.Orders.TOTAL+
                " FROM "+MySQLContract.Orders.TABLE_NAME+
                " GROUP BY "+MySQLContract.Orders.USER_DNI+
                " HAVING "+MySQLContract.Orders.USER_DNI+"='"+user.getDNI()+"' LIMIT 1;";

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);

        if(result.next() && result.getFloat(MySQLContract.Orders.TOTAL) >= 100){
            getConnection().close();
            return true;
        }else{
            getConnection().close();
            return false;
        }

    }

    @Override
    public boolean makeVip(VOUser user) throws SQLException {
        String checkUser="INSERT INTO "+MySQLContract.Vips.TABLE_NAME+
                "("+MySQLContract.Vips.DNI+")" +
                " VALUES" +
                "('"+user.getDNI()+"');";

        System.out.println(checkUser);

        int i=getConnection().createStatement().executeUpdate(checkUser);

        getConnection().close();

        if(i > 0){
            return true;
        }else{
            return false;
        }

    }


    private PreparedStatement getUsers = null;
    private final String getUsersSQL = "SELECT * FROM "+MySQLContract.Users.TABLE_NAME;

    @Override
    public ArrayList<VOUser> getUsers() throws SQLException {
        ArrayList<VOUser> ret = new ArrayList<>();
        try {
            if (getUsers == null)
                getUsers = getConnection().prepareStatement(getUsersSQL);

            ResultSet res = getUsers.executeQuery();

            while (res.next()){
                VOUser user = new VOUser();
                user.setFirstName(res.getString(MySQLContract.Users.firstName));
                user.setLastName(res.getString(MySQLContract.Users.lastName));
                user.seteMail(res.getString(MySQLContract.Users.mail));
                user.setDNI(res.getString(MySQLContract.Users.DNI));

                isAdmin(user);
                if (isVip(user))
                    user.setVip(true);
                else
                    user.setVip(false);
                ret.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(getUsers);
        }
        return ret;
    }

    @Override
    public boolean updateUser(VOUser user) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteUser(VOUser user) throws SQLException {
        return false;
    }
}
