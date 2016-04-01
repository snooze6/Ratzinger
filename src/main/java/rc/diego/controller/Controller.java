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
    private final String PARAMETER_ERROR = "error";

    private final String ACTION_SHOW_INDEX = "index";
    private final String ACTION_SHOW_STOCK = "stock";
    private final String ACTION_EDIT_ITEM = "edit";

    private final String ACTION_SHOW_SHOPPING_CART = "shoppingCart";
    private final String ACTION_SHOW_SIGN_IN = "signIn";
    private final String ACTION_SHOW_SIGN_UP = "signUp";
    private final String ACTION_BUY_ITEM = "buyItem";
    private final String ACTION_ERASE_ITEM = "eraseItem";
    private final String ACTION_UPDATE_ITEM = "updateItem";
    private final String ACTION_CHECKOUT = "checkout";
    private final String ACTION_SIGN_IN = "signInUser";
    private final String ACTION_SIGN_UP = "signUpUser";
    private final String ACTION_CONFIRM_PAYMENT = "confirmPayment";
    private final String ACTION_RESET = "reset";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VOShoppingCart shoppingCart;
        VOUser user;

        HttpSession session=req.getSession(false);

        if(session == null) { //crease unha sesion si non existe
            session = req.getSession(true);
            getTaskMapper().initializeSession(session);
        }

        try {
            switch ((String) req.getParameter(PARAMETER_ACTION)) {
                case ACTION_SHOW_INDEX:
                    shoppingCart=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

                    getViewManager().showIndex();
                    break;
                case ACTION_SHOW_SHOPPING_CART:
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_SHOW_SIGN_IN:
                    getViewManager().showSignIn();
                    break;
                case ACTION_SHOW_SIGN_UP:
                    getViewManager().showSignUp();
                    break;
                case ACTION_CHECKOUT:
                    getViewManager().showPaymentData();
                    break;
                case ACTION_EDIT_ITEM:
                    getViewManager().showEditProduct();
                    break;
                case ACTION_SHOW_STOCK:
                    shoppingCart=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

                    getViewManager().showStocks();
                    break;
                case ACTION_CONFIRM_PAYMENT:
                    //TODO:comprobar que o ususario se encontra registrado ates de realizar este punto
                    user = user=((VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER));

                    if(user.getFirstName() != null && user.getFirstName().length() > 0) {
                        getTaskMapper().insertOrder(
                                (VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER),
                                (VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART)
                        );

                        getViewManager().showPayment();

                    }else{
                        getViewManager().showSignIn();
                    }

                    break;
                case ACTION_BUY_ITEM:
                    VOCd p= obterProducto(
                            req.getParameter(PARAMETER_CD_LIST),
                            Integer.parseInt(req.getParameter(PARAMETER_QUANTITY))
                    );

                    shoppingCart=(VOShoppingCart)session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART);

                    getTaskMapper().addToShoppingCart(
                            shoppingCart,
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
                    //TODO:FALTA REALIZAR ACCION DE ACTUALIZAR UN ITEM
                    getViewManager().showShoppingCart();
                    break;
                case ACTION_RESET:

                    session.setAttribute(VOUser.SESSION_ATTRIBUTE_USER,new VOUser());

                    getTaskMapper().initializeShoppingCart(
                            (VOShoppingCart) session.getAttribute(VOShoppingCart.SESSION_ATTRIBUTE_SHOPPING_CART)
                    );

                    shoppingCart=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

                    getViewManager().showIndex();

                    break;
                case ACTION_SIGN_IN:
                    user=((VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER));

                    getTaskMapper().setUserData(
                            req.getParameter(VOUser.PARAMETER_DNI),
                            null,
                            null,
                            null,
                            req.getParameter(VOUser.PARAMETER_PASSWORD),
                            user
                    );

                    if(getTaskMapper().signInUser(user)){  //usuario logueado correctamente
                        shoppingCart=getTaskMapper().getAllCds();
                        req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

                        getViewManager().showIndex();
                    }else{
                        req.setAttribute(PARAMETER_ERROR,"Los datos de usuario no son correctos o el usuario no existe. Por favor, inténtelo de nuevo.");

                        getViewManager().showError();
                    }

                    break;
                case ACTION_SIGN_UP:


                    //TODO:mensaxe de error ao rexistrar o usuario
                    user=((VOUser) session.getAttribute(VOUser.SESSION_ATTRIBUTE_USER));

                    getTaskMapper().setUserData(
                            req.getParameter(VOUser.PARAMETER_DNI),
                            req.getParameter(VOUser.PARAMETER_FIRST_NAME),
                            req.getParameter(VOUser.PARAMETER_LAST_NAME),
                            req.getParameter(VOUser.PARAMETER_MAIL),
                            req.getParameter(VOUser.PARAMETER_PASSWORD),
                            user
                    );

                    //TODO: Intentar registraro ususario na base de datos
                    if(getTaskMapper().signUpUser(user)) {
                        //TODO: por ahora unha vez se registra un usuario, se mostraa páxina inicial
                        shoppingCart = getTaskMapper().getAllCds();
                        req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS, shoppingCart);

                        getViewManager().showIndex();
                    }else{
                        req.setAttribute(PARAMETER_ERROR,"Se ha producido un error. No se puede registrar un usuario con ese DNI");

                        getViewManager().showError();
                    }

                    break;
                default:
                    shoppingCart=getTaskMapper().getAllCds();
                    req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

                    getViewManager().showIndex();

            }
        }catch (NullPointerException e){
            shoppingCart=getTaskMapper().getAllCds();
            req.setAttribute(VOShoppingCart.SESSION_ATTRIBUTE_CDS,shoppingCart);

            getViewManager().showIndex();
        }

    }

    //TODO:REFACER A SELECCION DE PRODUCTOS
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

