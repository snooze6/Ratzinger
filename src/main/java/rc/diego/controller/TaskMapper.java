package rc.diego.controller;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.task.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
    public boolean createCd(VOCd cd2) {
        createCD createcd = new createCD();
        createcd.setCD(cd2);
        tm.runTask(createcd);
        return createcd.isOk();
    }

    @Override
    public boolean signInUser(VOUser voUser) {
        signIn si=new signIn(voUser);
        tm.runTask(si);
        return si.isValid();
    }


    public VOShoppingCart getCdsByFilter(String filter) {
        getCDsByFilter task = new getCDsByFilter();
        task.setFilter(filter);
        tm.runTask(task);
        VOShoppingCart shoppingCart = task.getShoppingCart();
        return shoppingCart;
    }

    @Override
    public void sendConfirmPaymentMail(VOUser user, VOShoppingCart carrito) {
        tm.runAsyncTask(new sendConfirmPaymentMail(user,carrito));
    }

    @Override
    public void deleteCd(VOCd cd3) {
        tm.runTask(new deleteCD().setCD(cd3));

    }

    public TaskMapper() {
        this.tm=new TaskManager();
    }

    @Override
    public ArrayList<VOUser> getAllUsers() {
        getAllUsers ge = new getAllUsers();
        tm.runTask(ge);
        return ge.getUsers();
    }

    @Override
    public void deactivateUser(VOUser user) {
        tm.runTask(new deactivateUser().setUser(user));
    }

    @Override
    public void activateUser(VOUser user) {
        tm.runTask(new activateUser().setUser(user));
    }

    @Override
    public boolean getUser(VOUser user, boolean active) {
        getUserTask user1 = new getUserTask();
        user1.setUser(user);
        user1.setActive(active);
        tm.runTask(user1);
        return user1.isOk();
    }

    @Override
    public boolean getAllUser(VOUser user) {
        getAllUserTask ge = new getAllUserTask();
        ge.setUser(user);
        tm.runTask(ge);
        return ge.isOk();
    }

    @Override
    public void updateUser(VOUser user) {
        tm.runTask(new updateUser().setUser(user));
    }

}
