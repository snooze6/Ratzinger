package rc.diego.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rc.diego.view.*;
import rc.diego.view.Error;
import rc.diego.view.admin.products.editProduct;
import rc.diego.view.admin.products.stock;
import rc.diego.view.admin.users.editUser;
import rc.diego.view.admin.users.showusers;

/**
 * Created by entakitos on 20/02/16.
 */
public class ViewManager implements InterfaceViewManager {

    private InterfaceHelperDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ViewManager(InterfaceHelperDispatcher dispatcher, HttpServletRequest request, HttpServletResponse response) {
        this.dispatcher=dispatcher;
        this.request = request;
        this.response = response;
    }

    @Override
    public void showIndex() {
        dispatcher.forward(new Index(request,response));
    }

    @Override
    public void showProductInfo(){
        dispatcher.forward(new product(request,response));
    }

    @Override
    public void showShoppingCart() {
        dispatcher.forward(new shoppingCart(request,response));
    }


    @Override
    public void showPaymentData() {
        dispatcher.forward(new paymentData(request,response));
    }

    @Override
    public void showPayment() {
        dispatcher.forward(new payment(request,response));
    }

    @Override
    public void showSignIn() {
        dispatcher.forward(new SignIn(request,response));
    }

    @Override
    public void showSignUp() {
        dispatcher.forward(new SignUp(request,response));
    }

    @Override
    public void showError() {
        dispatcher.forward(new Error(request,response));
    }

    @Override
    public void showStocks() {
        dispatcher.forward(new stock(request,response));
    }

    @Override
    public void showEditProduct() {
        dispatcher.forward(new editProduct(request,response));
    }

    @Override

    public void showSearch() {dispatcher.forward(new Search(request,response));}


    public void showUsers() {
        dispatcher.forward(new showusers(request,response));
    }

    @Override
    public void showEditUsers() {
        dispatcher.forward(new editUser(request,response));
    }
}
