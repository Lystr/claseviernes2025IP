/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author slaye
 */
public class Habitacion {
    private int id;
    private String ubicacion;
    private int acomodacion;
    private int costo_id;
    private String costo_d;

    public Habitacion() {
    }

    public Habitacion(int id, String ubicacion, int acomodacion, int costo_id, String costo_d) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.acomodacion = acomodacion;
        this.costo_id = costo_id;
        this.costo_d = costo_d;
    }

    public Habitacion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getAcomodacion() {
        return acomodacion;
    }

    public void setAcomodacion(int acomodacion) {
        this.acomodacion = acomodacion;
    }

    public int getCosto_id() {
        return costo_id;
    }

    public void setCosto_id(int costo_id) {
        this.costo_id = costo_id;
    }

    public String getCosto_d() {
        return costo_d;
    }

    public void setCosto_d(String costo_d) {
        this.costo_d = costo_d;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.ubicacion);
        hash = 37 * hash + this.acomodacion;
        hash = 37 * hash + this.costo_id;
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
        final Habitacion other = (Habitacion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.acomodacion != other.acomodacion) {
            return false;
        }
        if (this.costo_id != other.costo_id) {
            return false;
        }
        return Objects.equals(this.ubicacion, other.ubicacion);
    }
    
}
