package com.dh.liquidacion.main;

public class EmpleadoEfectivo extends Empleado {

    private Double sueldo;
    private Double descuento;
    private Double premio;

    public EmpleadoEfectivo(String nombre, String apellido, String cbu, Double sueldo, Double descuento, Double premio) {
        super(nombre, apellido, cbu);
        this.sueldo = sueldo;
        this.descuento = descuento;
        this.premio = premio;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }
}
