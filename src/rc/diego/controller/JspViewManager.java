package rc.diego.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rc.diego.view.IndexJSP;
import rc.diego.view.paymentDataJSP;
import rc.diego.view.shoppingCartJSP;

/**
 * Created by entakitos on 20/02/16.
 */
public class JspViewManager implements InterfaceViewManager {

    private InterfaceHelperDispatcher dispatcher;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public JspViewManager(InterfaceHelperDispatcher dispatcher,HttpServletRequest request, HttpServletResponse response) {
        this.dispatcher=dispatcher;
        this.request = request;
        this.response = response;
    }

    @Override
    public void showIndex() {
        dispatcher.forward(new IndexJSP(request,response));
    }

    @Override
    public void showShoppingCart() {
        dispatcher.forward(new shoppingCartJSP(request,response));
    }


    @Override
    public void showPaymentData() {
        dispatcher.forward(new paymentDataJSP(request,response));
    }

    @Override
    public void showPayment() {
        dispatcher.forward(new IndexJSP(request,response));
    }
}
