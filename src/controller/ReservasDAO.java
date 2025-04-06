/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import dto.ReservasDTO;
import model.Reservas;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservasDAO  implements BDOperations {
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "select r.reserva_id, r.fecha_reserva, r.fecha_salida, concat(habitacion_id,'-','Habitacion') as habitacion, \n" +
"	   concat(h.huesped_id,'-',h.primer_nombre , ' ', h.primer_apellido) huesped, \n" +
"       concat(e.empleado_id,'-',e.primer_nombre ,' ' , e.primer_apellido) registro \n" +
"  from reserva r\n" +
"  left join huesped h\n" +
"    on r.huesped_id = h.huesped_id\n" +
"  left join empleado e\n" +
"    on r.empleado_id = e.empleado_id;";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new ReservasDTO(
                        rs.getInt("reserva_id"),
                        rs.getDate("fecha_reserva"),
                        rs.getDate("fecha_salida"),
                        rs.getString("habitacion"),
                        rs.getString("huesped"),
                        rs.getString("registro")
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar reservasDTOs: " + e.getMessage());
        }     
        return lista;
    }
    
    @Override
    public boolean insert(Object object){               
        Reservas reservas = (Reservas) object;
        String sql = "INSERT INTO reserva (fecha_reserva, fecha_salida, habitacion_id, huesped_id,  empleado_id) VALUES (?, ?, ?, ?, ?)" ;
        //String sql = "INSERT INTO reserva (habitacion_id, huesped_id,  empleado_id) VALUES (?, ?, ?)" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(reservas.getFecha_reserva().getTime()));
            pst.setDate(2, new java.sql.Date(reservas.getFecha_salida().getTime()));
            pst.setInt(3, reservas.getHabitacion_id());
            pst.setInt(4, reservas.getHuesped_id());
            pst.setInt(5, reservas.getEmpleado_id());
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean update(Object object){ 
        Reservas reservas = (Reservas) object;
        String sql = "UPDATE reserva SET fecha_reserva=?, fecha_salida=?, habitacion_id=?, huesped_id=?, empleado_id=? WHERE reserva_id=?" ;
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(reservas.getFecha_reserva().getTime()));
            pst.setDate(2, new java.sql.Date(reservas.getFecha_salida().getTime()));
            pst.setInt(3, reservas.getHabitacion_id());
            pst.setInt(4, reservas.getHuesped_id());
            pst.setInt(5, reservas.getEmpleado_id());
            pst.setInt(6, reservas.getReserva_id());
            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al actualizar reserva: " + e.getMessage());
            return false;
        }     
    }
    
    @Override
    public boolean delete(int id){               
        String sql = "DELETE FROM reserva WHERE reserva_id=?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);            
            return pst.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("Error al eliminar reservasDTO: " + e.getMessage());
            return false;
        }     
    }

    @Override
    public Object getById(int id) {
        ReservasDTO reservas = new ReservasDTO();
        String sql = "select r.reserva_id, r.fecha_reserva, r.fecha_salida, concat(habitacion_id,'-','Habitacion') as habitacion, \n" +
"	   concat(h.huesped_id,'-',h.primer_nombre , ' ', h.primer_apellido) huesped, \n" +
"       concat(e.empleado_id,'-',e.primer_nombre ,' ' , e.primer_apellido) registro \n" +
"  from reserva r\n" +
"  left join huesped h\n" +
"    on r.huesped_id = h.huesped_id\n" +
"  left join empleado e\n" +
"    on r.empleado_id = e.empleado_id Where r.reserva_id = ?";
        try (Connection con = ConnectionDB.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){                
                reservas.setReserva_id(rs.getInt("reserva_id"));
                reservas.setFecha_reserva(rs.getDate("fecha_reserva"));
                reservas.setFecha_salida(rs.getDate("fecha_salida"));
                reservas.setHabitacion(rs.getString("habitacion"));
                reservas.setHuesped(rs.getString("huesped"));
                reservas.setRegistro(rs.getString("registro"));                   
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar reservasDTOs: " + e.getMessage());
        }     
        return reservas;
    }
}
