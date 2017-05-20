package model.database;

import java.sql.Connection;

/**
 * Esta interface fornece os metodos padrões para conexao e desconexao com  o banco de dados.
 *@version 1
 * @author junior
 */
public interface Database {
    public Connection getConnection();
    public void desconnect();
    public void desconnect(Connection con);
}
