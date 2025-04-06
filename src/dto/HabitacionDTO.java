/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author slaye
 */
public class HabitacionDTO {
    private int id;
    private String habitacion;
	private String ubicacion;
	private int acomodacion;
	private int costo_id;
	private double costo;

    public HabitacionDTO(int id, String habitacion) {
        this.id = id;
        this.habitacion = habitacion;
    }

    public HabitacionDTO(int id, String ubicacion, int acomodacion, int costo_id) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.acomodacion = acomodacion;
        this.costo_id = costo_id;
    }

    public HabitacionDTO(int id, String ubicacion, int acomodacion, double costo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.acomodacion = acomodacion;
        this.costo = costo;
    }

    public HabitacionDTO() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
   
}
