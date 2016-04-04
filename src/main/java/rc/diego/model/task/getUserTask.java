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
public class getUserTask implements InterfaceTask{
    private VOUser user;
    private InterfaceDAOFactory daoFactory;
    private boolean active = true;
    private boolean ok = false;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser cd) {
        this.user = cd;
    }

    public boolean isActive() {
        return active;
    }

    public getUserTask setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public void run() {
        daoFactory = new AbstractFactoryMySQL();

        try {
             ok = daoFactory.getDAOUsers().getUser(user, active);
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace(); ok = false;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
