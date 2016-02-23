package rc.diego.controller;

import rc.diego.view.AbstractView;

/**
 * Created by entakitos on 19/02/16.
 */
public interface InterfaceHelperDispatcher {

    void forward(AbstractView view);
    void include(AbstractView view);
}
