package rc.diego.controller;

import rc.diego.view.AbstractView;

/**
 * Created by entakitos on 19/02/16.
 */
public interface InterfaceHelperDispatcher {

    public void forward(AbstractView view);
    public void include(AbstractView view);
}
