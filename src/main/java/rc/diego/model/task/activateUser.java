package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DataManager;

import java.sql.SQLException;

;

/**
 * Created by entakitos on 17/03/16.
 */
public class activateUser implements InterfaceTask{
    private VOUser users;

    public VOUser getUser() {
        return users;
    }

    public activateUser setUser(VOUser cd) {
        this.users = cd;
        return this;
    }

    @Override
    public void run() {
        try {
            DataManager.getDAOUsers().activateUser(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
