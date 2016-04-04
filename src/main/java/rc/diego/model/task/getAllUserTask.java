package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllUserTask implements InterfaceTask{
    private VOUser user;
    private InterfaceDAOFactory daoFactory;
    private boolean ok = false;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser cd) {
        this.user = cd;
    }

    @Override
    public void run() {
        daoFactory = new AbstractFactoryMySQL();

        try {
            ok = daoFactory.getDAOUsers().getAllUser(user);
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            ok = false;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
