package rc.diego.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by entakitos on 20/02/16.
 */
public class SignIn extends AbstractView {

    public SignIn(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        setViewUrl("/web/signIn.jsp");
    }
}
