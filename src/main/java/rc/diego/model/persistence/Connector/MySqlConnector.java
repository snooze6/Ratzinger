package rc.diego.model.persistence.Connector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by entakitos on 1/03/16.
 */
public class MySqlConnector implements InterfaceConnector{

    public Connection getConnection()throws Exception{
        try {
            Context ctx = new InitialContext();
            return ((DataSource)ctx.lookup("java:comp/env/jdbc/localhost")).getConnection();

        } catch (NamingException e) {
            e.printStackTrace();
            System.out.println("Conexion NO establecida");
        } catch (java.sql.SQLException e) {
            System.out.println("Conexion NO establecida");
            throw (e);
        }
        return null;
    }

}
