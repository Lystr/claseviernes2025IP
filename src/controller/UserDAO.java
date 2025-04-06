/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.User;

/**
 *
 * @author slaye
 */
public class UserDAO  implements BDLogin {
    @Override
    public Object getUser(String name, String pass) {
        User user = new User();
        String sql = "select * from hotel_reservas.usuarios where username = ? and password_hash = ?;";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){   
                user.setId(rs.getInt("usuarios_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword_hash(rs.getString("password_hash"));
                user.setRol(rs.getString("rol"));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar reservasDTOs: " + e.getMessage());
        }     
        return user;
    }

    @Override
    public Boolean checkUser(String name, String pass) {
        String sql = "select * from hotel_reservas.usuarios where username = ? and password_hash = ?;";
        Boolean result = false;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){   
               result = true;
            }                    
        }catch(SQLException e){
          result = false;
        }  
        return result;
    }
}
