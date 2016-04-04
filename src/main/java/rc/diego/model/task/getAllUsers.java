package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.MySQL.AbstractFactoryMySQL;
import rc.diego.model.persistence.AbstractDAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllUsers implements InterfaceTask{
    private ArrayList<VOUser> users;

    public ArrayList<VOUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<VOUser> cd) {
        this.users = cd;
    }

    @Override
    public void run() {

        try {
            users = DataManager.getDAOUsers().getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            users = new ArrayList<>();
        }
    }
}
