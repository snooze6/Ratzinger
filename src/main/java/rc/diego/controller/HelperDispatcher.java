package rc.diego.controller;

import java.io.IOException;

import rc.diego.view.AbstractView;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by entakitos on 19/02/16.
 */
public class HelperDispatcher implements InterfaceHelperDispatcher{

    private ServletContext context;

    public HelperDispatcher(ServletContext context) {
        this.context = context;
    }

    @Override
    public void forward(AbstractView view) {

        try {
            context.getRequestDispatcher(view.getViewUrl()).forward(view.getRequest(),view.getResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void include(AbstractView view) {

        try {
            context.getRequestDispatcher(view.getViewUrl()).include(view.getRequest(),view.getResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
