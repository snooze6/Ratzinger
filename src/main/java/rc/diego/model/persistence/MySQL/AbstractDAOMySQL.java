package rc.diego.model.persistence.MySQL;

import rc.diego.model.persistence.MySQL.Connector.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void close(PreparedStatement stat) {
        //TODO: Destruir esto
        if (stat != null)
            try {
                stat.close();
                //getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
