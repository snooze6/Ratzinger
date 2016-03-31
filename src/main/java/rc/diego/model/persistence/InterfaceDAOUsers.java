package rc.diego.model.persistence;

import rc.diego.model.VO.VOUser;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

/**
 * Created by entakitos on 31/03/16.
 */
public interface InterfaceDAOUsers {
    void inserteUser(VOUser user) throws SQLException;
    boolean getUser(VOUser user) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException;
}
