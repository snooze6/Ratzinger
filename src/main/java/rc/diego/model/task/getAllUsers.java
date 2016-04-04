package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by entakitos on 17/03/16.
 */
public class getAllUsers implements InterfaceTask{
    private ArrayList<VOUser> users;
    private InterfaceDAOFactory daoFactory;

    public ArrayList<VOUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<VOUser> cd) {
        this.users = cd;
    }

    @Override
    public void run() {
        daoFactory = new AbstractFactoryMySQL();
        try {
            users = daoFactory.getDAOUsers().getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            users = new ArrayList<>();
        }
    }
}
