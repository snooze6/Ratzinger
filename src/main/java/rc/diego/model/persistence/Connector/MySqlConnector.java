package rc.diego.model.persistence.Connector;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by entakitos on 1/03/16.
 */
public class MySqlConnector implements InterfaceConnector{
    private String host="ratztest.cdh6gtvsyebq.us-east-1.rds.amazonaws.com";
    private String database="ratztest";
    private String user="ratztest";
    private String passwd="ratztest";

//    private String host="localhost";
//    private String database="dawa_04_test";
//    private String user="root";
//    private String passwd="root";


    public Connection getConnection()throws Exception
    {
        String url = "";
        try
        {
            url = "jdbc:mysql://"+host+"/"+database+"?user="+user+"&password="+passwd;
            Class.forName("com.mysql.jdbc.Driver");
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
