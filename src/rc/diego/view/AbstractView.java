package rc.diego.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by entakitos on 19/02/16.
 */
public abstract class AbstractView {

    protected String viewUrl;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public String getViewUrl() {
        return viewUrl;
    }

    protected void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public AbstractView(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
