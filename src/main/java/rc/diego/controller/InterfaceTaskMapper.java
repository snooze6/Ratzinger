package rc.diego.controller;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by entakitos on 20/02/16.
 */
public interface InterfaceTaskMapper {
    void initializeShoppingCart(VOShoppingCart shoppingCart);
    void addToShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd);
    void removeFromShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd);
    void updateShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd);
    void initializeSession(HttpSession session);
    void setUserData(String dni, String firstName,String lastName, String email, String password, VOUser VOUser);
    void signUpUser( VOUser voUser);
    void pay(VOUser VOUser);

    void insertOrder(VOUser user, VOShoppingCart carrito);
    VOShoppingCart getAllCds();
}
