package rc.diego.controller;

import rc.diego.model.entities.Product;
import rc.diego.model.entities.User;
import rc.diego.model.task.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by entakitos on 21/02/16.
 */
public class TaskMapper implements InterfaceTaskMapper{

    private TaskManager tm;

    @Override
    public void initializeShoppingCart(HashMap<String, Product> shoppingCart) {
        tm.runTask(new resetShoppingCart(shoppingCart));
    }

    @Override
    public void addToShoppingCart(HashMap<String, Product> shoppingCart, Product product) {
        tm.runTask(new addProduct(shoppingCart,product));
    }

    @Override
    public void removeFromShoppingCart(HashMap<String, Product> shoppingCart, Product product) {
        tm.runTask(new removeProduct(shoppingCart, product));
    }

    @Override
    public void updateShoppingCart(HashMap<String, Product> shoppingCart, Product product) {
        tm.runTask(new updateProduct(shoppingCart, product));
    }

    @Override
    public void initializeSession(HttpSession session) {
        tm.runTask(new initializeSesion(session));
    }

    @Override
    public void setUserData(String name, String email, User user) {
        tm.runTask(new setUserData(name, email, user));
    }

    @Override
    public void pay(User user) {
        //TODO not implemented yet
    }

    public TaskMapper() {
        this.tm=new TaskManager();
    }
}
