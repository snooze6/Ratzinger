package rc.diego.model.task;

import rc.diego.model.entities.User;

import javax.servlet.http.HttpSession;

/**
 * Created by entakitos on 28/02/16.
 */
public class initializeSesion implements InterfaceTask{

    private HttpSession session;

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public void run() {
        this.session.setAttribute(User.SESSION_ATTRIBUTE_USER, new User());
    }

    public initializeSesion(HttpSession session) {
        this.session = session;
    }
}
