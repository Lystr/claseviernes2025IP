/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import dto.HuespedDTO;
import model.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slaye
 */
public class HuespedDAO  implements BDOperations {
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT huesped_id, concat(huesped_id,'-',primer_nombre,' ',primer_apellido) huesped, edad, fecha_registro FROM hotel_reservas.huesped order by huesped_id";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new HuespedDTO(
                        rs.getInt("huesped_id"),
                        rs.getString("huesped"),
                        rs.getInt("edad"),
                        rs.getDate("fecha_registro")
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huespedDTOs: " + e.getMessage());
        }     
        return lista;
    }
    
    @Override
    public boolean insert(Object object){               
        Huesped huesped = (Huesped) object;
        String sql = "INSERT INTO huesped (primer_nombre, primer_apellido, edad) VALUES (?, ?, ?)" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huesped.getPrimer_nombre());
            pst.setString(2, huesped.getPrimer_apellido());
            pst.setInt(3, huesped.getEdad());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar huespedDTO: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean update(Object object){ 
        Huesped huesped = (Huesped) object;
        String sql = "UPDATE huesped SET primer_nombre=?, segundo_nombre=?, edad=? WHERE huesped_id=?" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, huesped.getPrimer_nombre());
            pst.setString(2, huesped.getPrimer_apellido());
            pst.setInt(3, huesped.getEdad());
            pst.setInt(4, huesped.getId());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar huesped: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean delete(int id){               
        String sql = "DELETE FROM huesped WHERE huesped_id=?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar huesped: " + e.getMessage());
            return false;
        }     
    }

    @Override
    public Object getById(int id) {
        Huesped huesped = new Huesped();
        String sql = "SELECT * FROM huesped Where huesped_id = ?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                huesped.setId(rs.getInt("huesped_id"));
                huesped.setPrimer_nombre(rs.getString("primer_nombre"));
                huesped.setPrimer_apellido(rs.getString("primer_apellido"));
                huesped.setEdad(rs.getInt("edad"));                        
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huesped: " + e.getMessage());
        }     
        return huesped;
    }
}
