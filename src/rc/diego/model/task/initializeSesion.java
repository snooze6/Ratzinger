package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;

import javax.servlet.http.HttpSession;

/**
 * Created by entakitos on 28/02/16.
 */
public class initializeSesion implements InterfaceTask{

    private HttpSession session;

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public void run() {
        this.session.setAttribute(VOUser.SESSION_ATTRIBUTE_USER, new VOUser());
        this.session.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART,new VOShoppingCart());
    }

    public initializeSesion(HttpSession session) {
        this.session = session;
    }
}
