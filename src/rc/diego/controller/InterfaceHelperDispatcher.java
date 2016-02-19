package rc.diego.controller;

import rc.diego.view.AbstractJspView;

/**
 * Created by entakitos on 19/02/16.
 */
public interface InterfaceHelperDispatcher {

    void forward(AbstractJspView view);
    void include(AbstractJspView view);
}
