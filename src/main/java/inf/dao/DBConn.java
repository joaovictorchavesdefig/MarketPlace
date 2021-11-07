package inf.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
    
    public Connection getConnection() throws Exception{
        try{
            Class.forName("org.postgresql.Driver"); // carrega o drive e registra no JDBC
            String url = "jdbc:postgresql://localhost/MarketPlace"; //caminho para o BD
            String usr = "admin";
            String pswrd = "admin";
            return DriverManager.getConnection(url, usr, pswrd);
        } catch (Exception e){
            throw e;
        }
    }
    
}
