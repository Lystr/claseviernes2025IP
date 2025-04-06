/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import dto.HabitacionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Habitacion;

/**
 *
 * @author slaye
 */
public class HabitacionDAO  implements BDOperations {
    
    public List<Object> getComboBox(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT habitacion_id, concat(habitacion_id,'-','Habitacion') as habitacion FROM hotel_reservas.habitacion  order by habitacion_id";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new HabitacionDTO(
                        rs.getInt("habitacion_id"),
                        rs.getString("habitacion")
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar habitacion: " + e.getMessage());
        }     
        return lista;
    }
    
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "select h.*, c.costo from hotel_reservas.habitacion h\n" +
                     "  left join hotel_reservas.costo c\n" +
                     "    on h.costo_id = c.costo_id";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new HabitacionDTO(
                        rs.getInt("habitacion_id"),
                        rs.getString("ubicacion"),
                        rs.getInt("acomodacion"),
                        rs.getDouble("costo")
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar habitacion: " + e.getMessage());
        }     
        return lista;
    }
    
    @Override
    public boolean insert(Object object){               
        Habitacion habitacion = (Habitacion) object;
        String sql = "INSERT INTO habitacion (ubicacion, acomodacion, costo_id) VALUES (?, ?, ?)" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, habitacion.getUbicacion());
            pst.setInt(2, habitacion.getAcomodacion());
            pst.setInt(3, habitacion.getCosto_id());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar habitacion: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean update(Object object){ 
        Habitacion habitacion = (Habitacion) object;
        String sql = "UPDATE habitacion SET ubicacion=?, acomodacion=?, costo_id=? WHERE habitacion_id=?" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, habitacion.getUbicacion());
            pst.setInt(2, habitacion.getAcomodacion());
            pst.setInt(3, habitacion.getCosto_id());
            pst.setInt(4, habitacion.getId());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar habitacion: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean delete(int id){               
        String sql = "DELETE FROM habitacion WHERE habitacion_id=?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar habitacion: " + e.getMessage());
            return false;
        }     
    }

    @Override
    public Object getById(int id) {
        Habitacion habitacion = new Habitacion();
        String sql = "SELECT *, concat(c.costo_id,'-', c.costo) as costo_d FROM habitacion  h\n" +
                     "  left join hotel_reservas.costo c\n" +
                     "    on h.costo_id = c.costo_id Where habitacion_id = ?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                habitacion.setId(rs.getInt("habitacion_id"));
                habitacion.setUbicacion(rs.getString("ubicacion"));
                habitacion.setAcomodacion(rs.getInt("acomodacion"));
                habitacion.setCosto_id(rs.getInt("costoid")); 
                habitacion.setCosto_d(rs.getString("costo_d"));               
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar habitacion: " + e.getMessage());
        }     
        return habitacion;
    }
    
}
