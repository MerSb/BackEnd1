package com.dh.liquidacion.main;

public class EmpleadoContratado extends Empleado {

    private Integer cantidadHoras;
    private Integer valordHora;

    public EmpleadoContratado(String nombre, String apellido, String cbu, Integer cantidadHoras, Integer valordHora) {
        super(nombre, apellido, cbu);
        this.cantidadHoras = cantidadHoras;
        this.valordHora = valordHora;
    }

    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Integer getValordHora() {
        return valordHora;
    }

    public void setValordHora(Integer valordHora) {
        this.valordHora = valordHora;
    }
}
