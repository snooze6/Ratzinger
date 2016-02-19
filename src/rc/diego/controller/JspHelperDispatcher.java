package rc.diego.controller;

import rc.diego.view.AbstractJspView;

import javax.servlet.ServletContext;

/**
 * Created by entakitos on 19/02/16.
 */
public class JspHelperDispatcher implements InterfaceHelperDispatcher{

    private ServletContext context;

    public JspHelperDispatcher(ServletContext context) {
        this.context = context;
    }

    @Override
    public void forward(AbstractJspView view) {
        context.getRequestDispatcher(view.getViewUrl()).forward(view.getRequest(),view.getResponse());
    }

    @Override
    public void include(AbstractJspView view) {
        context.getRequestDispatcher().include();
    }
}
