/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author louis
 */

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_reservas";
    private static final String USUARIO = "link_db";
    private static final String PASSWORD = "Hotel123$";
    
    private static HikariDataSource dataSource;
    
    static{        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(3000);
        config.setMaxLifetime(200000);
        config.setConnectionTimeout(10000);
        
        dataSource = new HikariDataSource(config);                
    }
    
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void closePool(){
        if(dataSource != null){
            dataSource.close();
        }
    }   
    
}
