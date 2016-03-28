package rc.diego.model.persistence;

import rc.diego.model.persistence.Connector.MySqlConnector;

import java.sql.Connection;

/**
 * Created by entakitos on 17/03/16.
 */
public abstract class AbstractDAOMySQL {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public AbstractDAOMySQL() {
        try {
            this.connection = new MySqlConnector().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
