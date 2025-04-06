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
public class ReservasDTO {
    
    
    /*
    select r.reserva_id, r.fecha_reserva, r.fecha_salida, r.habitacion_id, 
	   h.huesped_id, concat(h.primer_nombre , ' ', h.primer_apellido) huesped, 
           concat(e.primer_nombre ,' ' , e.primer_apellido) registro 
      from reserva r
      left join huesped h
        on r.huesped_id = h.huesped_id
      left join empleado e
        on r.empleado_id = e.empleado_id;
    */
    
    private int reserva_id;
    private Date  fecha_reserva;
    private Date  fecha_salida;
    private String habitacion;
    private String huesped;
    private String registro;

    public ReservasDTO(int reserva_id, Date fecha_reserva, Date fecha_salida, String habitacion, String huesped, String registro) {
        this.reserva_id = reserva_id;
        this.fecha_reserva = fecha_reserva;
        this.fecha_salida = fecha_salida;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.registro = registro;
    }

    public ReservasDTO() {
    }

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getHuesped() {
        return huesped;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.reserva_id;
        hash = 83 * hash + Objects.hashCode(this.fecha_reserva);
        hash = 83 * hash + Objects.hashCode(this.fecha_salida);
        hash = 83 * hash + Objects.hashCode(this.habitacion);
        hash = 83 * hash + Objects.hashCode(this.huesped);
        hash = 83 * hash + Objects.hashCode(this.registro);
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
        final ReservasDTO other = (ReservasDTO) obj;
        if (this.reserva_id != other.reserva_id) {
            return false;
        }
        if (!Objects.equals(this.habitacion, other.habitacion)) {
            return false;
        }
        if (!Objects.equals(this.huesped, other.huesped)) {
            return false;
        }
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        if (!Objects.equals(this.fecha_reserva, other.fecha_reserva)) {
            return false;
        }
        return Objects.equals(this.fecha_salida, other.fecha_salida);
    }

    
    
}
