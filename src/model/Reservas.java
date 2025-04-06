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
public class Reservas {
    private int reserva_id;
    private Date fecha_reserva;
    private Date fecha_salida;
    private int huesped_id;
    private int habitacion_id;
    private int dias;
    private double costo;
    private double impuesto;
    private double monto_total;
    private int empleado_id;
    private int estado_id;
    private Date fecha_registro;

    public Reservas(int reserva_id, Date fecha_reserva, Date fecha_salida, int huesped_id, int habitacion_id, int dias, double costo, double impuesto, double monto_total, int empleado_id, int estado_id, Date fecha_registro) {
        this.reserva_id = reserva_id;
        this.fecha_reserva = fecha_reserva;
        this.fecha_salida = fecha_salida;
        this.huesped_id = huesped_id;
        this.habitacion_id = habitacion_id;
        this.dias = dias;
        this.costo = costo;
        this.impuesto = impuesto;
        this.monto_total = monto_total;
        this.empleado_id = empleado_id;
        this.estado_id = estado_id;
        this.fecha_registro = fecha_registro;
    }
    
    
    public Reservas(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public Reservas() {
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

    public int getHuesped_id() {
        return huesped_id;
    }

    public void setHuesped_id(int huesped_id) {
        this.huesped_id = huesped_id;
    }

    public int getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(int habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
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
        hash = 97 * hash + this.reserva_id;
        hash = 97 * hash + Objects.hashCode(this.fecha_reserva);
        hash = 97 * hash + Objects.hashCode(this.fecha_salida);
        hash = 97 * hash + this.huesped_id;
        hash = 97 * hash + this.habitacion_id;
        hash = 97 * hash + this.dias;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.impuesto) ^ (Double.doubleToLongBits(this.impuesto) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.monto_total) ^ (Double.doubleToLongBits(this.monto_total) >>> 32));
        hash = 97 * hash + this.empleado_id;
        hash = 97 * hash + this.estado_id;
        hash = 97 * hash + Objects.hashCode(this.fecha_registro);
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
        final Reservas other = (Reservas) obj;
        if (this.reserva_id != other.reserva_id) {
            return false;
        }
        if (this.huesped_id != other.huesped_id) {
            return false;
        }
        if (this.habitacion_id != other.habitacion_id) {
            return false;
        }
        if (this.dias != other.dias) {
            return false;
        }
        if (Double.doubleToLongBits(this.costo) != Double.doubleToLongBits(other.costo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.impuesto) != Double.doubleToLongBits(other.impuesto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.monto_total) != Double.doubleToLongBits(other.monto_total)) {
            return false;
        }
        if (this.empleado_id != other.empleado_id) {
            return false;
        }
        if (this.estado_id != other.estado_id) {
            return false;
        }
        if (!Objects.equals(this.fecha_reserva, other.fecha_reserva)) {
            return false;
        }
        if (!Objects.equals(this.fecha_salida, other.fecha_salida)) {
            return false;
        }
        return Objects.equals(this.fecha_registro, other.fecha_registro);
    }

    
    
}
