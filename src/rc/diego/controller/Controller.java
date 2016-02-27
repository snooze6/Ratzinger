package rc.diego.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by entakitos on 19/02/16.
 */
public class Controller extends HttpServlet {

    private final String ACTION_INDEX="index";
    private final String ACTION_SHOPPING_CART="shoppingCart";
    private final String ACTION_CHECKOUT="checkout";
    private final String ACTION_CONFIRM_PAYMENT="confirmPayment";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        HttpSession session=req.getSession(false);

        if(session == null) //crease unha sesion si non existe
            session=req.getSession(true);

        switch ((String)req.getAttribute("action")){
            case ACTION_INDEX:

                break;
            case ACTION_SHOPPING_CART:

                break;
            case ACTION_CHECKOUT:

                break;
            case ACTION_CONFIRM_PAYMENT:

                break;
            default:

        }

    }

}
