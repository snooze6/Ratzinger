package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.MySQL.DAOCdsMySQL;

/**
 * Created by entakitos on 17/03/16.
 */
public class createCD implements InterfaceTask{
    private VOCd cd;
    private boolean ok = false;
    private DAOCdsMySQL.CdAlreadyExistsException e = null;

    public VOCd getCD() {
        return cd;
    }

    public void setCD(VOCd cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        try {
            ok = DataManager.getDAOCds().create(cd);
        } catch (DAOCdsMySQL.CdAlreadyExistsException e1) {
            e = e1;
        }
    }

    public boolean isOk() throws DAOCdsMySQL.CdAlreadyExistsException{
        if (e!=null){
            throw e;
        }
        return ok;
    }
}
