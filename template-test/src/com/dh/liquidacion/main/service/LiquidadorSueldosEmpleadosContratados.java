package com.dh.liquidacion.main.service;

import com.dh.liquidacion.main.Empleado;
import com.dh.liquidacion.main.EmpleadoContratado;
import com.dh.liquidacion.main.EmpleadoEfectivo;

public class LiquidadorSueldosEmpleadosContratados extends LiquidadorSueldos {
    @Override
    public String liquidarSueldo(Empleado empleado) {

        if( empleado instanceof EmpleadoEfectivo) {
            return "No se puedo realizar la liquidación";
        } else {

            EmpleadoContratado empleadoContratado = (EmpleadoContratado) empleado;
            int sueldoTotal = empleadoContratado.getCantidadHoras() * empleadoContratado.getValordHora();

            return "La liquidación generada es un documento digital. Saldo a liquidar: " + sueldoTotal;

        }
    }


}
