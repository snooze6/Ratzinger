package rc.diego.model.task;

import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DAOFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

import java.sql.SQLException;

/**
 * Created by entakitos on 31/03/16.
 */
public class signIn implements InterfaceTask{

    private InterfaceDAOFactory factory= new DAOFactoryMySQL();
    private VOUser user;
    private boolean valid=false;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser user) {
        this.user = user;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public void run() {
        try {
            valid=factory.getDAOUsers().getUser(user);
        } catch (Exception e) {
            //TODO falta gestionar que pasa si non se  pode registrar o usuario
            e.printStackTrace();
        }
    }

    public signIn(VOUser user) {
        this.user = user;
    }
}
