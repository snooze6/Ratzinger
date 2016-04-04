package rc.diego.view.admin.users;

import rc.diego.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by snooze on 4/1/16.
 */
public class editUser extends AbstractView {

    public editUser(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        setViewUrl("/web/editUser.jsp");
    }
}
