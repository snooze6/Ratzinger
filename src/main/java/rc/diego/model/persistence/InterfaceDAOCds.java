package rc.diego.model.persistence;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;

/**
 * Created by entakitos on 17/03/16.
 */
public interface InterfaceDAOCds {
    VOShoppingCart getAllCDs();
    boolean getCD(VOCd cd);
    boolean updateCDQuantity(VOCd cd);
    boolean updateCD(VOCd cd);
    boolean create(VOCd cd);

    boolean deleteCD(VOCd cd);
}
