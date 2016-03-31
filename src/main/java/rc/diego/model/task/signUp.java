package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DAOFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;

/**
 * Created by entakitos on 31/03/16.
 */
public class signUp implements InterfaceTask{

    private InterfaceDAOFactory factory= new DAOFactoryMySQL();
    private VOUser user;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            factory.getDAOUsers().inserteUser(user);
        } catch (SQLException e) {
            //TODO falta gestionar que pasa si non se  pode registrar o usuario
            e.printStackTrace();
        }
    }

    public signUp(VOUser user) {
        this.user = user;
    }
}
