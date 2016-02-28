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

    private final String ACTION_SHOW_INDEX = "index";
    private final String ACTION_SHOW_SHOPPING_CART = "shoppingCart";
    private final String ACTION_BUY_ITEM = "buyItem";
    private final String ACTION_ERASE_ITEM = "eraseItem";
    private final String ACTION_UPDATE_ITEM = "updateItem";
    private final String ACTION_CHECKOUT = "checkout";
    private final String ACTION_CONFIRM_PAYMENT = "confirmPayment";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        viewManager.showIndex();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        HttpSession session=req.getSession(false);

        if(session == null) { //crease unha sesion si non existe
            session = req.getSession(true);
            taskMapper.initializeSession(session);
        }

        switch ((String)req.getAttribute("action")){
            case ACTION_SHOW_INDEX:
                viewManager.showIndex();
                break;
            case ACTION_SHOW_SHOPPING_CART:
                viewManager.showShoppingCart();
                break;
            case ACTION_CHECKOUT:
                viewManager.showPaymentData();
                break;
            case ACTION_CONFIRM_PAYMENT:
                viewManager.showPayment();
                break;
            case ACTION_BUY_ITEM:
                //TODO:FALTA REALIZAR ACCION DE COMPRAR
                viewManager.showShoppingCart();
                break;
            case ACTION_ERASE_ITEM:
                //TODO:FALTA REALIZAR ACCION DE BORRAR
                viewManager.showShoppingCart();
                break;
            case ACTION_UPDATE_ITEM:
                //TODO:FALTA REALIZAR ACCION DE ACTUALIZAR
                viewManager.showShoppingCart();
                break;
            default:
                viewManager.showIndex();
        }

    }

}

