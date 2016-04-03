package rc.diego.controller;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.task.*;

import javax.servlet.http.HttpSession;

/**
 * Created by entakitos on 21/02/16.
 */
public class TaskMapper implements InterfaceTaskMapper{

    private TaskManager tm;

    @Override
    public void initializeShoppingCart(VOShoppingCart shoppingCart) {
        tm.runTask(new resetShoppingCart(shoppingCart));
    }

    @Override
    public void addToShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd) {
        tm.runTask(new addProduct(shoppingCart, VOCd));
    }

    @Override
    public void removeFromShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd) {
        tm.runTask(new removeProduct(shoppingCart, VOCd));
    }

    @Override
    public void updateShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd) {
        tm.runTask(new updateProduct(shoppingCart, VOCd));
    }

    @Override
    public void initializeSession(HttpSession session) {
        tm.runTask(new initializeSesion(session));
    }

    @Override
    public void setUserData(String dni, String firstName,String lastName, String email, String password, VOUser VOUser) {
        tm.runTask(new setUserData(dni,firstName,lastName, email, password,VOUser));
    }

    @Override
    public boolean signUpUser(VOUser voUser) {
        signUp su=new signUp(voUser);
        tm.runTask(su);
        return !su.isAlreadyExists();
    }

    @Override
    public void pay(VOUser VOUser) {
        //TODO not implemented yet
    }

    @Override
    public boolean insertOrder(VOUser user, VOShoppingCart carrito) {
        insertOrder order=new insertOrder(user,carrito);
        tm.runTask(order);
        return order.isEnough();
    }

    @Override
    public VOShoppingCart getAllCds() {
        getAllCdsFromDataBase task= new getAllCdsFromDataBase();
        tm.runTask(task);
        VOShoppingCart shoppingCart = task.getShoppingCart();
        return shoppingCart;
    }

    @Override
    public boolean getCd(VOCd cd) {
        getCD ge = new getCD();
        ge.setCD(cd);
        tm.runTask(ge);
        return ge.isOk();
    }

    @Override
    public boolean updateCd(VOCd cd) {
        updateCD ge = new updateCD();
        ge.setCD(cd);
        tm.runTask(ge);
        return ge.isOk();
    }

    @Override
    public boolean signInUser(VOUser voUser) {
        signIn si=new signIn(voUser);
        tm.runTask(si);
        return si.isValid();
    }

    public TaskMapper() {
        this.tm=new TaskManager();
    }
}
