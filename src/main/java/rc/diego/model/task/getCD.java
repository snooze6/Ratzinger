package rc.diego.model.task;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.persistence.DAOFactoryMySQL;
import rc.diego.model.persistence.InterfaceDAOFactory;

/**
 * Created by entakitos on 17/03/16.
 */
public class getCD implements InterfaceTask{
    private VOCd cd;
    private InterfaceDAOFactory daoFactory;
    private boolean ok;

    public VOCd getShoppingCart() {
        return cd;
    }

    public void setShoppingCart(VOCd cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        daoFactory = new DAOFactoryMySQL();
        ok = daoFactory.getDAOCds().getCD(cd);
    }

    public boolean isOk(){
        return ok;
    }
}
