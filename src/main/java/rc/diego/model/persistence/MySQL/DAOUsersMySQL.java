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
            //TODO Test this
            if(insertUser == null)
                insertUser=getConnection().prepareStatement(insertUserSQL);

            insertUser.setString(1,user.getDNI());
            insertUser.setString(2,user.getFirstName());
            insertUser.setString(3,user.getLastName());
            insertUser.setString(4,user.geteMail());

            encriptpass(user);
            insertUser.setString(5,user.getPassword());

//                System.err.println("DEBUG");
//                System.err.println("=================");
//                System.err.println(updateCDQuantityStatement.toString());

            insertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserAlreadyExistsException("Ya existe un usuario con el mismo DNI");
        } finally {
            if(insertUser != null)
                insertUser.close();

//            getConnection().close();
        }

    }

    private void encriptpass(VOUser user) throws SQLException {
        String password;
        try {
            password= new PBKDF2Encrypt().generateStrongPasswordHash(user.getPassword());
            user.setPassword(password);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        String checkUser="SELECT * FROM `"+MySQLContract.Users.TABLE_NAME+
                "` WHERE "+MySQLContract.Users.active+"=1 AND "+
                MySQLContract.Users.DNI+"='"+user.getDNI()+"' LIMIT 1;";

        System.err.println("DEBUG [GETUSER]");
        System.err.println("=================");
        System.err.println(checkUser);

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);
        // Es gracioso como esto y la limitación de caracteres se carga la inyección SQL
        if(result.next()) {
            String hash = result.getString(MySQLContract.Users.password);
            if (new PBKDF2Encrypt().validatePassword(user.getPassword(),hash)) {
                boolean u = assignUser(user, result);
                System.err.println("Bien");
                System.err.println(user.toString());
                user.setActive(true);
                System.err.println(user.toString());
                return u;
            } else {
//                getConnection().close();
                encriptpass(user);
                System.err.println("Pass: "+user.getPassword());
                System.err.println("Good: "+hash);
                System.err.println("Difieren");
                return false;
            }
        }else {
            System.err.println("No such user");
            return false;
        }
    }

    private boolean assignUser(VOUser user, ResultSet result) throws SQLException {
        user.setFirstName(result.getString(MySQLContract.Users.firstName));
        user.setLastName(result.getString(MySQLContract.Users.lastName));
        user.seteMail(result.getString(MySQLContract.Users.mail));
//        System.err.println(user.toString());
        isAdmin(user);
//        System.err.println(user.toString());
        if (isVip(user))
            user.setVip(true);
        else
            user.setVip(false);
        user.setActive(result.getBoolean(MySQLContract.Users.active));
        System.err.println("Active: "+result.getBoolean(MySQLContract.Users.active));
//        System.err.println(user.toString());
//        getConnection().close();
        return true;
    }

    @Override
    public boolean getUser(VOUser user, boolean active) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        String checkUser="SELECT * FROM `"+MySQLContract.Users.TABLE_NAME+
                "` WHERE "+MySQLContract.Users.active+"="+active+" AND "+
                MySQLContract.Users.DNI+"='"+user.getDNI()+"' LIMIT 1;";
        return getDBUSer(user, checkUser);
    }

    @Override
    public boolean getAllUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        String checkUser="SELECT * FROM `"+MySQLContract.Users.TABLE_NAME+
                "` WHERE "+
                MySQLContract.Users.DNI+"='"+user.getDNI()+"' LIMIT 1;";
        return getDBUSer(user, checkUser);
    }

    private boolean getDBUSer(VOUser user, String checkUser) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
//        System.err.println("DEBUG");
//        System.err.println("=================");
//        System.err.println(checkUser);

        ResultSet result=getConnection().createStatement().executeQuery(checkUser);
        // Es gracioso como esto y la limitación de caracteres se carga la inyección SQL
        if(result.next()) {
            return assignUser(user, result);
        }else {
//            getConnection().close();
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
//            System.err.println("Es administrador");
        } else {
            user.setTipo(MySQLContract.Tipo.normal);
//            System.err.println("No es administrador");
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
//            getConnection().close();
            return true;
        }else{
//            getConnection().close();
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

//        getConnection().close();

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
                user.setActive(res.getBoolean(MySQLContract.Users.active));

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

    private PreparedStatement updateUser = null;
    private String updateUserSQL = "UPDATE "+MySQLContract.Users.TABLE_NAME+
            " SET "+MySQLContract.Users.firstName+"=? "+
            ", "+MySQLContract.Users.lastName+"=? "+
            ", "+MySQLContract.Users.mail+"=? "+
            " WHERE "+MySQLContract.Users.DNI+"=?; ";

    @Override
    public boolean updateUser(VOUser user) throws SQLException {
        try {
            if (updateUser == null)
                updateUser = getConnection().prepareStatement(updateUserSQL);

            updateUser.setString(1, user.getFirstName());
            updateUser.setString(2, user.getLastName());
            updateUser.setString(3, user.geteMail());
            updateUser.setString(4, user.getDNI());

            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(updateUser.toString());

            updateUser.executeUpdate();
            setTipo(user);
            setVip(user);
            setPassword(user);
            if (user.isActive()){
                activateUser(user);
            } else {
                deactivateUser(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            close(updateUser);
        }
        return true;
    }

    private void setTipo(VOUser user) throws SQLException {
        switch (user.getTipo()){
            case admin:
                getConnection().createStatement().executeUpdate(
                        "INSERT INTO "+MySQLContract.Admins.TABLE_NAME+
                                " VALUES ('"+user.getDNI()+"')"
                );
                break;
            case normal:
                getConnection().createStatement().executeUpdate(
                        "DELETE FROM "+MySQLContract.Admins.TABLE_NAME+
                        " WHERE "+MySQLContract.Admins.DNI+"='"+user.getDNI()+"'"
                );
                break;
        }
    }

    private void setVip(VOUser user) throws SQLException {
        if (user.isVip()){
            getConnection().createStatement().executeUpdate(
                    "INSERT INTO "+MySQLContract.Vips.TABLE_NAME+
                    " VALUES ('"+user.getDNI()+"')"
            );
        } else {
            getConnection().createStatement().executeUpdate(
                    "DELETE FROM "+MySQLContract.Vips.TABLE_NAME+
                    " WHERE "+MySQLContract.Vips.DNI+"='"+user.getDNI()+"'"
            );
        }
    }

    private PreparedStatement updateUserPass = null;
    private String updateUserSQLPass = "UPDATE "+MySQLContract.Users.TABLE_NAME+
            " SET "+MySQLContract.Users.password+"=? "+
            " WHERE "+MySQLContract.Users.DNI+"=?; ";
    private void setPassword(VOUser user) throws SQLException {
        if (user.getPassword()!=null){
            if (updateUserPass == null)
                updateUserPass = getConnection().prepareStatement(updateUserSQLPass);

            encriptpass(user);
            updateUserPass.setString(1, user.getPassword());
            updateUserPass.setString(2, user.getDNI());

            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(updateUserPass.toString());

            updateUserPass.executeUpdate();

            close(updateUserPass);
        }
    }

    private final String deactivateUserSQL = "UPDATE "+MySQLContract.Users.TABLE_NAME+
            " SET "+MySQLContract.Users.active+"=0 WHERE "+MySQLContract.Users.DNI+"=";
    @Override
    public boolean deactivateUser(VOUser user) throws SQLException {
        try {
            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(deactivateUserSQL+"'"+user.getDNI()+"'");
            getConnection().createStatement().executeUpdate(deactivateUserSQL+"'"+user.getDNI()+"'");
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private final String activateUserSQL = "UPDATE "+MySQLContract.Users.TABLE_NAME+
            " SET "+MySQLContract.Users.active+"=1 WHERE "+MySQLContract.Users.DNI+"=";
    @Override
    public boolean activateUser(VOUser user) throws SQLException {
        try {
            System.err.println("DEBUG");
            System.err.println("=================");
            System.err.println(activateUserSQL+"'"+user.getDNI()+"'");
            getConnection().createStatement().executeUpdate(activateUserSQL+"'"+user.getDNI()+"'");
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
