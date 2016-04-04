package rc.diego.controller;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.persistence.DAOCdsMySQL;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
    boolean signUpUser(VOUser voUser);
    boolean signInUser( VOUser voUser);
    void pay(VOUser VOUser);

    boolean insertOrder(VOUser user, VOShoppingCart carrito);
    VOShoppingCart getAllCds();
    VOShoppingCart getCdsByFilter(String filter);

    void sendConfirmPaymentMail(VOUser user, VOShoppingCart carrito);

    boolean getCd(VOCd cd);
    boolean updateCd(VOCd cd);

    boolean createCd(VOCd cd2) throws DAOCdsMySQL.CdAlreadyExistsException;

    void deleteCd(VOCd cd3);

    ArrayList<VOUser> getAllUsers();

    void deactivateUser(VOUser user);
    void activateUser(VOUser user);
    void updateUser(VOUser user);
    boolean getUser(VOUser user, boolean active);
    boolean getAllUser(VOUser user);
}

