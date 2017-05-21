package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe implementa a interface database e realiza conexoes com banco
 * de dados mysql.
 * @author junior
 */
public class DatabaseMySQL implements Database{
    private Connection mConnection;
    private String mUser;
    private String mPassword;
    private String mUrl;

    public DatabaseMySQL() {
        mUrl = "jdbc:mysql://localhost:3306/contplus";
        mUser = "contador";
        mPassword = "Pern@long4";
    }
    /**
     * @since 8/04/2017
     * @return Conexão com o banco de dados mysql se ocorrer tudo bem 
     */    
    @Override
    public Connection getConnection() {
        try{
           DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Resolve o problema do driver jdbc
           mConnection = DriverManager.getConnection(mUrl, mUser, mPassword);
           return mConnection;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Fecha a conexao com o DB
     */
    @Override
    public void desconnect() {
        try {
            mConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    @Override
    public void desconnect(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
