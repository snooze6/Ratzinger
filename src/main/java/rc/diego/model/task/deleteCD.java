package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.persistence.DataManager;
import rc.diego.model.persistence.MySQL.AbstractFactoryMySQL;
import rc.diego.model.persistence.AbstractDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class deleteCD implements InterfaceTask{
    private VOCd cd;
    private boolean ok;

    public VOCd getCD() {
        return cd;
    }

    public deleteCD setCD(VOCd cd) {
        this.cd = cd;
        return this;
    }

    @Override
    public void run() {

        ok = DataManager.getDAOCds().deleteCD(cd);
    }

    public boolean isOk(){
        return ok;
    }
}
