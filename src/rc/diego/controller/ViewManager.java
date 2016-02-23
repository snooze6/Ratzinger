package rc.diego.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rc.diego.view.Index;
import rc.diego.view.paymentData;
import rc.diego.view.shoppingCart;

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
    public void showShoppingCart() {
        dispatcher.forward(new shoppingCart(request,response));
    }


    @Override
    public void showPaymentData() {
        dispatcher.forward(new paymentData(request,response));
    }

    @Override
    public void showPayment() {
        dispatcher.forward(new Index(request,response));
    }
}
