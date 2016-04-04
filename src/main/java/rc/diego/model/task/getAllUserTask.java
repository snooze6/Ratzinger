package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DataManager;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllUserTask implements InterfaceTask{
    private VOUser user;
    private boolean ok = false;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser cd) {
        this.user = cd;
    }

    @Override
    public void run() {
        try {
            ok = DataManager.getDAOUsers().getAllUser(user);
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            ok = false;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
