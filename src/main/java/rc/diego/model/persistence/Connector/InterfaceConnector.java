package rc.diego.model.persistence.Connector;

import java.sql.Connection;

/**
 * Created by entakitos on 1/03/16.
 */
public interface InterfaceConnector {
    public default Connection getConnection() throws Exception {
        return null;
    }
}
