package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.MySQL.AbstractFactoryMySQL;
import rc.diego.model.persistence.MySQL.DAOUsersMySQL;
import rc.diego.model.persistence.AbstractDAOFactory;

import java.sql.SQLException;

/**
 * Created by entakitos on 31/03/16.
 */
public class signUp implements InterfaceTask{

    private VOUser user;
    private boolean alreadyExists=false;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser user) {
        this.user = user;
    }

    public boolean isAlreadyExists() {
        return alreadyExists;
    }

    @Override
    public void run() {
        try {
            DataManager.getDAOUsers().insertUser(user);
        } catch (SQLException e) {
            //TODO falta gestionar que pasa si non se  pode registrar o usuario
            e.printStackTrace();
        } catch (DAOUsersMySQL.UserAlreadyExistsException e) {
            e.printStackTrace();
            alreadyExists=true;
        }
    }

    public signUp(VOUser user) {
        this.user = user;
    }
}
