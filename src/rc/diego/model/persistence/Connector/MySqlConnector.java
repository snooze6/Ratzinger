package rc.diego.model.persistence.Connector;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by entakitos on 1/03/16.
 */
public class MySqlConnector {

    public Connection getConnection(String host, String database,String user,String passwd)throws Exception
    {
        String url = "";
        try
        {
            url = "jdbc:mysql://" + host + "/" + database;
            Connection con = DriverManager.getConnection(url);
            System.out.println("Conexion establecida con " + url + "...");
            return con;
        }
        catch (java.sql.SQLException e)
        {
            System.out.println("Conexion NO establecida con " + url);
            throw (e);
        }
    }

}
