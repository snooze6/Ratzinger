package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.DAOCdsMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class createCD implements InterfaceTask{
    private VOCd cd;
    private InterfaceDAOFactory daoFactory;
    private boolean ok;
    DAOCdsMySQL.CdAlreadyExistsException e;

    public VOCd getCD() {
        return cd;
    }

    public void setCD(VOCd cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        daoFactory = new AbstractFactoryMySQL();
        try {
            ok = daoFactory.getDAOCds().create(cd);
        } catch (DAOCdsMySQL.CdAlreadyExistsException e1) {
            e = e1;
        }
    }

    public boolean isOk() throws DAOCdsMySQL.CdAlreadyExistsException{
        if (e==null){
            return ok;
        } else {
            System.err.println("Lanzando excepción");
            throw e;
        }
    }
}
