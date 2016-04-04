package rc.diego.view.admin.users;

import rc.diego.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by entakitos on 20/02/16.
 */
public class showusers extends AbstractView {

    public showusers(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        setViewUrl("/web/users.jsp");
    }
}
