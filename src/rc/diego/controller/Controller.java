package rc.diego.controller;

import rc.diego.model.entities.Product;
import rc.diego.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by entakitos on 19/02/16.
 */
public class Controller extends CustomHttpServlet {

    private final String PARAMETER_ACTION = "action";
    private final String PARAMETER_CD_LIST = "listaCds";
    private final String PARAMETER_QUANTITY = "cantidad";

    private final String ACTION_SHOW_INDEX = "index";
    private final String ACTION_SHOW_SHOPPING_CART = "shoppingCart";
    private final String ACTION_BUY_ITEM = "buyItem";
    private final String ACTION_ERASE_ITEM = "eraseItem";
    private final String ACTION_UPDATE_ITEM = "updateItem";
    private final String ACTION_CHECKOUT = "checkout";
    private final String ACTION_CONFIRM_PAYMENT = "confirmPayment";
    private final String ACTION_RESET = "reset";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(false);

        if(session == null) { //crease unha sesion si non existe
            session = req.getSession(true);
            getTaskMapper().initializeSession(session);
        }

        getViewManager().showIndex();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(false);

        if(session == null) { //crease unha sesion si non existe
            session = req.getSession(true);
            getTaskMapper().initializeSession(session);
        }

//        try {
            switch ((String) req.getParameter(PARAMETER_ACTION)) {
                case ACTION_SHOW_INDEX:
                    getViewManager().showIndex();
                    break;
                case ACTION_SHOW_SHOPPING_CART:
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_CHECKOUT:
                    getViewManager().showPaymentData();
                    break;
                case ACTION_CONFIRM_PAYMENT:

                    getTaskMapper().setUserData(
                            req.getParameter(User.PARAMETER_NAME),
                            req.getParameter(User.PARAMETER_MAIL),
                            (User) session.getAttribute(User.SESSION_ATTRIBUTE_USER)
                    );

                    getViewManager().showPayment();

                    break;
                case ACTION_BUY_ITEM:
                    //TODO:FALTA REALIZAR ACCION DE COMPRA
                    Product p= obterProducto(
                            req.getParameter(PARAMETER_CD_LIST),
                            Integer.parseInt(req.getParameter(PARAMETER_QUANTITY))
                    );

                    User u = (User) session.getAttribute(User.SESSION_ATTRIBUTE_USER);
                    HashMap<String, Product> m=u.getShoppingCart();
                    getTaskMapper().addToShoppingCart(
                            m,
                            p
                    );

                    getViewManager().showShoppingCart();
                    break;
                case ACTION_ERASE_ITEM:
                    //TODO:FALTA REALIZAR ACCION DE BORRAR
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_UPDATE_ITEM:
                    //TODO:FALTA REALIZAR ACCION DE ACTUALIZAR
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_RESET:
                    //TODO:FALTA REALIZAR ACCION DE ACTUALIZAR
                    User u2 = (User) session.getAttribute(User.SESSION_ATTRIBUTE_USER);
                    getTaskMapper().initializeShoppingCart(u2.getShoppingCart());
                    getViewManager().showIndex();

                    break;
                default:
                    getViewManager().showIndex();
            }
//        }catch (NullPointerException e){
//            getViewManager().showIndex();
//        }

    }

    //TODO:quitar de aqui
    private Product obterProducto(String descripcionCD,int quantity){
        Product p=new Product();
        StringTokenizer t = new StringTokenizer(descripcionCD,"|");
        p.setName(t.nextToken());
        p.setDescription("Autor: " + t.nextToken() + " de " + t.nextToken());
        p.setUnitaryPrice(Float.parseFloat(t.nextToken().replace('$',' ').trim()));
        p.setQuantity(quantity);

        return p;
    }
}

