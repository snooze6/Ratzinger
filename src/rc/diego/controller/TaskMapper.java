package rc.diego.controller;

import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOUser;
import rc.diego.model.task.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by entakitos on 21/02/16.
 */
public class TaskMapper implements InterfaceTaskMapper{

    private TaskManager tm;

    @Override
    public void initializeShoppingCart(HashMap<String, VOCd> shoppingCart) {
        tm.runTask(new resetShoppingCart(shoppingCart));
    }

    @Override
    public void addToShoppingCart(VOShoppingCart shoppingCart, VOCd VOCd) {
        tm.runTask(new addProduct(shoppingCart, VOCd));
    }

    @Override
    public void removeFromShoppingCart(HashMap<String, VOCd> shoppingCart, VOCd VOCd) {
        tm.runTask(new removeProduct(shoppingCart, VOCd));
    }

    @Override
    public void updateShoppingCart(HashMap<String, VOCd> shoppingCart, VOCd VOCd) {
        tm.runTask(new updateProduct(shoppingCart, VOCd));
    }

    @Override
    public void initializeSession(HttpSession session) {
        tm.runTask(new initializeSesion(session));
    }

    @Override
    public void setUserData(String name, String email, VOUser VOUser) {
        tm.runTask(new setUserData(name, email, VOUser));
    }

    @Override
    public void pay(VOUser VOUser) {
        //TODO not implemented yet
    }

    @Override
    public void insertOrder(VOUser user, VOShoppingCart carrito) {
        tm.runTask(new insertOrder(user,carrito));
    }

    public TaskMapper() {
        this.tm=new TaskManager();
    }
}
