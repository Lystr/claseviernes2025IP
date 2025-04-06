/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author slaye
 */
public class Huesped {
    private int id;
    private String primer_nombre;
    private String segundo_nombre;
    private String tercer_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private int edad;
    private Date fecha_registro;

    public Huesped(int id, String primer_nombre, String segundo_nombre, String tercer_nombre, String primer_apellido, String segundo_apellido, int edad, Date fecha_registro) {
        this.id = id;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.tercer_nombre = tercer_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.edad = edad;
        this.fecha_registro = fecha_registro;
    }

    public Huesped() {
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getTercer_nombre() {
        return tercer_nombre;
    }

    public void setTercer_nombre(String tercer_nombre) {
        this.tercer_nombre = tercer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
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
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.primer_nombre);
        hash = 67 * hash + Objects.hashCode(this.segundo_nombre);
        hash = 67 * hash + Objects.hashCode(this.tercer_nombre);
        hash = 67 * hash + Objects.hashCode(this.primer_apellido);
        hash = 67 * hash + Objects.hashCode(this.segundo_apellido);
        hash = 67 * hash + this.edad;
        hash = 67 * hash + Objects.hashCode(this.fecha_registro);
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
        final Huesped other = (Huesped) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.primer_nombre, other.primer_nombre)) {
            return false;
        }
        if (!Objects.equals(this.segundo_nombre, other.segundo_nombre)) {
            return false;
        }
        if (!Objects.equals(this.tercer_nombre, other.tercer_nombre)) {
            return false;
        }
        if (!Objects.equals(this.primer_apellido, other.primer_apellido)) {
            return false;
        }
        if (!Objects.equals(this.segundo_apellido, other.segundo_apellido)) {
            return false;
        }
        return Objects.equals(this.fecha_registro, other.fecha_registro);
    }

    
}
