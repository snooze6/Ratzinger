package rc.diego.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by entakitos on 20/02/16.
 */
public class SignUp extends AbstractView {

    public SignUp(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        setViewUrl("/web/signUp.jsp");
    }
}
