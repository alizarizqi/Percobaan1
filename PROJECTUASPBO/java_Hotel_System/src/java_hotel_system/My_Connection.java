package java_hotel_system;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Wahyu devi
 */
public class My_Connection {
    //kelas untuk membuat koneksi dengan msql database
    public Connection createConnection(){
       Connection connection = null;
       
       MysqlDataSource mds = new MysqlDataSource();
       mds.setServerName("localhost");
       mds.setPortNumber(3306);
       mds.setUser("root");
       mds.setPassword("");
       mds.setDatabaseName("java_hotel_db");
       
        try {
            connection = (Connection) mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(My_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return connection;
    }
    
}
