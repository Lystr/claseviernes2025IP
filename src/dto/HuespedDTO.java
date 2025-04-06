/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author slaye
 */
public class HuespedDTO {
    private int id;
    private String huesped;
    private int edad;
    private Date fecha_registro;

    public HuespedDTO(int id, String huesped, int edad, Date fecha_registro) {
        this.id = id;
        this.huesped = huesped;
        this.edad = edad;
        this.fecha_registro = fecha_registro;
    }

    public HuespedDTO() {
    }
    
   
    public int getId() {
        return id;
    }

    public String getHuesped() {
        return huesped;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.huesped);
        hash = 83 * hash + this.edad;
        hash = 83 * hash + Objects.hashCode(this.fecha_registro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HuespedDTO other = (HuespedDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.huesped, other.huesped)) {
            return false;
        }
        return Objects.equals(this.fecha_registro, other.fecha_registro);
    }
    
    
    
}
