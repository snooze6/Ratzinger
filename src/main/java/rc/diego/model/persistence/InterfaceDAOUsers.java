package rc.diego.model.persistence;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.MySQL.DAOUsersMySQL;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by entakitos on 31/03/16.
 */
public interface InterfaceDAOUsers {
    //TODO:pendiente de mirar como cachear

    void insertUser(VOUser user) throws SQLException, DAOUsersMySQL.UserAlreadyExistsException;
    boolean getUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException;
    boolean getUser(VOUser user, boolean active) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException;
    boolean getAllUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException;

    boolean isAdmin(VOUser user) throws SQLException;
    boolean isVip(VOUser user) throws SQLException;
    boolean checkVipCondition(VOUser user) throws SQLException;
    boolean makeVip(VOUser user) throws SQLException;

    ArrayList<VOUser> getUsers() throws SQLException;
    boolean updateUser(VOUser user) throws SQLException;
    boolean deactivateUser(VOUser user) throws SQLException;
    boolean activateUser(VOUser user) throws SQLException;

}
