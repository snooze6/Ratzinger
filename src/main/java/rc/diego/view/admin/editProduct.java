package rc.diego.view.admin;

import rc.diego.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by snooze on 4/1/16.
 */
public class editProduct extends AbstractView {

    public editProduct(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        setViewUrl("/web/editProducts.jsp");
    }
}
