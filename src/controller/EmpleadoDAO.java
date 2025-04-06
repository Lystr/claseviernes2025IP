/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bd.ConnectionDB;
import dto.EmpleadoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author slaye
 */
public class EmpleadoDAO  implements BDOperations {
    @Override
    public List<Object> getAll(){
        List<Object> lista = new ArrayList<>();
        String sql = "SELECT empleado_id, concat(empleado_id,'-',primer_nombre, ' ', primer_apellido) as empleado FROM hotel_reservas.empleado order by empleado_id";
        try (Connection con = ConnectionDB.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                lista.add(new EmpleadoDTO(
                        rs.getInt("empleado_id"),
                        rs.getString("empleado")
                ));
            }           
            
        }catch(SQLException e){
            System.err.println("Error al listar huespedDTOs: " + e.getMessage());
        }     
        return lista;
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
