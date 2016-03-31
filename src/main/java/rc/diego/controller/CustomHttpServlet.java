package rc.diego.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by entakitos on 27/02/16.
 */
public abstract class CustomHttpServlet extends HttpServlet{

    private InterfaceTaskMapper taskMapper;
    private InterfaceViewManager viewManager;

    protected InterfaceTaskMapper getTaskMapper() {
        return taskMapper;
    }

    protected InterfaceViewManager getViewManager() {
        return viewManager;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        taskMapper = new TaskMapper();
        HelperDispatcher hd=new HelperDispatcher(getServletContext());
        viewManager = new ViewManager(hd,req,resp);

        super.service(req, resp);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

    }



}
