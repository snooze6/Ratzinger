package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.persistence.AbstractFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class deleteCD implements InterfaceTask{
    private VOCd cd;
    private InterfaceDAOFactory daoFactory;
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
        daoFactory = new AbstractFactoryMySQL();
        ok = daoFactory.getDAOCds().deleteCD(cd);
    }

    public boolean isOk(){
        return ok;
    }
}
