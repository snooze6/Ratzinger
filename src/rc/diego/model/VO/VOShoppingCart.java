package rc.diego.model.VO;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by entakitos on 17/03/16.
 */
public class VOShoppingCart extends HashMap<Integer,VOCd> implements Serializable{

    public final static String SESSION_ATTRIBUTE_SHOPPING_CART="cart";
    public final static String SESSION_ATTRIBUTE_CDS="cds";

}
