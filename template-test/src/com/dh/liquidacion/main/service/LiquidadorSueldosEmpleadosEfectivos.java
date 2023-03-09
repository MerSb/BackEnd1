package com.dh.liquidacion.main.service;

import com.dh.liquidacion.main.Empleado;
import com.dh.liquidacion.main.EmpleadoContratado;
import com.dh.liquidacion.main.EmpleadoEfectivo;

public class LiquidadorSueldosEmpleadosEfectivos extends LiquidadorSueldos {
    @Override
    public String liquidarSueldo(Empleado empleado) {

        if (empleado instanceof EmpleadoContratado) {
            return "No se puedo realizar la liquidación";

        } else {

            EmpleadoEfectivo empleadoEfectivo = (EmpleadoEfectivo) empleado;
            double sueldoFinal = empleadoEfectivo.getSueldo() + empleadoEfectivo.getPremio() - empleadoEfectivo.getDescuento();
            return "La liquidación generada es un documento impreso. Saldo a liquidar: " + (int) sueldoFinal;

        }


    }

}
