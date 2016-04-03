package rc.diego.model.task;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;
import rc.diego.model.utils.mail.JavaMail;

/**
 * Created by entakitos on 3/04/16.
 */
public class sendConfirmPaymentMail implements InterfaceTask{

    private VOUser user;
    private VOShoppingCart cart;

    public VOUser getUser() {
        return user;
    }

    public void setUser(VOUser user) {
        this.user = user;
    }

    public VOShoppingCart getCart() {
        return cart;
    }

    public void setCart(VOShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {

    }

    public sendConfirmPaymentMail(VOUser user, VOShoppingCart cart) {
        this.user = user;
        new JavaMail().sendMail(user.geteMail(),user,cart);
    }
}
