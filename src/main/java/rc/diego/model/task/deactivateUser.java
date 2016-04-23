package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;

;

/**
 * Created by entakitos on 17/03/16.
 */
public class deactivateUser implements InterfaceTask{
    private VOUser users;

    public VOUser getUser() {
        return users;
    }

    public deactivateUser setUser(VOUser cd) {
        this.users = cd;
        return this;
    }

    @Override
    public void run() {
        try {
            DataManager.getDAOUsers().deactivateUser(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
