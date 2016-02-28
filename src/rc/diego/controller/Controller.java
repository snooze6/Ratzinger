package rc.diego.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by entakitos on 19/02/16.
 */
public class Controller extends CustomHttpServlet {

    private final String PARAMETER_ACTION = "action";
    private final String ACTION_SHOW_INDEX = "index";
    private final String ACTION_SHOW_SHOPPING_CART = "shoppingCart";
    private final String ACTION_BUY_ITEM = "buyItem";
    private final String ACTION_ERASE_ITEM = "eraseItem";
    private final String ACTION_UPDATE_ITEM = "updateItem";
    private final String ACTION_CHECKOUT = "checkout";
    private final String ACTION_CONFIRM_PAYMENT = "confirmPayment";

    protected InterfaceTaskMapper taskMapper;
    protected InterfaceViewManager viewManager;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getViewManager().showIndex();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession(false);

        if(session == null) { //crease unha sesion si non existe
            session = req.getSession(true);
            getTaskMapper().initializeSession(session);
        }

        try {
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
                    getViewManager().showPayment();
                    break;
                case ACTION_BUY_ITEM:
                    //TODO:FALTA REALIZAR ACCION DE COMPRAR
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
                default:
                    getViewManager().showIndex();
            }
        }catch (NullPointerException e){
            getViewManager().showIndex();
        }

    }

}

