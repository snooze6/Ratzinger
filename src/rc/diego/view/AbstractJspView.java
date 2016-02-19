package rc.diego.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by entakitos on 19/02/16.
 */
public abstract class AbstractJspView {

    protected String viewUrl;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public String getViewUrl() {
        return viewUrl;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public AbstractJspView(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
