package rc.diego.controller;

import rc.diego.model.VO.VOCd;
import rc.diego.model.VO.VOShoppingCart;
import rc.diego.model.VO.VOUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
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

       doPost(req,resp);
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
                    VOShoppingCart shoppingCart=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

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
                            req.getParameter(VOUser.PARAMETER_NAME),
                            req.getParameter(VOUser.PARAMETER_MAIL),
                            (VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER)
                    );


                    final float[] total = {0};
                    ((VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART)).forEach((s, voCd) -> {
                        total[0] +=voCd.getQuantity() * voCd.getUnitaryPrice();
                    });

                    getTaskMapper().insertOrder(
                            (VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER),
                            (VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART)
                    );

                    getViewManager().showPayment();

                    break;
                case ACTION_BUY_ITEM:
                    VOCd p= obterProducto(
                            req.getParameter(PARAMETER_CD_LIST),
                            Integer.parseInt(req.getParameter(PARAMETER_QUANTITY))
                    );

                    VOShoppingCart sc=(VOShoppingCart)session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART);

                    getTaskMapper().addToShoppingCart(
                            sc,
                            p
                    );

                    getViewManager().showShoppingCart();
                    break;
                case ACTION_ERASE_ITEM:

                    Enumeration enumeration=req.getParameterNames();

                    while (enumeration.hasMoreElements()) {
                        String element = (String)enumeration.nextElement();

                        if(element.contains("checkbox-")) {

                            VOCd VOCd =new VOCd();
                            VOCd.setId(Integer.parseInt(element.replace("checkbox-", "").trim()));

                            try {
                                getTaskMapper().removeFromShoppingCart(
                                        (VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART),
                                        VOCd
                                );

                                /*
                                    Execútase dentro de un bloque try catch por si se dese a
                                    posibilidade de que se manipulara o html
                                    e se intentara borrar un elemento que non existe no carrito
                                 */
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }

                    getViewManager().showShoppingCart();
                    break;
                case ACTION_UPDATE_ITEM:
                    //TODO:FALTA REALIZAR ACCION DE ACTUALIZAR
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_RESET:
                    getTaskMapper().initializeShoppingCart(
                            (VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART)
                    );

                    VOShoppingCart shoppingCart2=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart2);

                    getViewManager().showIndex();

                    break;
                default:
                    VOShoppingCart shoppingCart3=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart3);

                    getViewManager().showIndex();
            }
        }catch (NullPointerException e){
            VOShoppingCart shoppingCart3=getTaskMapper().getAllCds();
            req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart3);
            getViewManager().showIndex();
        }

    }

    //TODO:quitar de aqui
    private VOCd obterProducto(String descripcionCD, int quantity){
        VOCd p=new VOCd();
        StringTokenizer t = new StringTokenizer(descripcionCD,"|");
        p.setId(Integer.parseInt(t.nextToken().trim()));
        p.setTitle(t.nextToken().trim());
        p.setDescription("Autor: " + t.nextToken().trim() + " de " + t.nextToken().trim());
        p.setUnitaryPrice(Float.parseFloat(t.nextToken().replace('€',' ').trim()));
        p.setQuantity(quantity);

        return p;
    }
}

