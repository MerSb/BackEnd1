package com.dh.liquidacion.test;

import com.dh.liquidacion.main.Empleado;
import com.dh.liquidacion.main.EmpleadoContratado;
import com.dh.liquidacion.main.EmpleadoEfectivo;
import com.dh.liquidacion.main.service.LiquidadorSueldos;
import com.dh.liquidacion.main.service.LiquidadorSueldosEmpleadosContratados;
import com.dh.liquidacion.main.service.LiquidadorSueldosEmpleadosEfectivos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidadorSueldosTest {

    @Test
    public void caso1_emite_documento_digital_para_empleado_efectivo() {
        //Arrange
        Empleado empleado = new EmpleadoEfectivo("Martin", "Martini", "123456", 400.00
                , 40.00, 60.00);
        LiquidadorSueldos liquidadorSueldos = new LiquidadorSueldosEmpleadosEfectivos();
        String resultadoEsperado = "La liquidación generada es un documento impreso. Saldo a liquidar: 420";
        //Act
        String resultado = liquidadorSueldos.liquidarSueldo(empleado);
        //Assert
        Assertions.assertEquals(resultadoEsperado, resultado);

    }


    @Test
    public void caso2_emite_documento_digital_para_empleado_contrado() {
        //Arrange
        Empleado empleado = new EmpleadoContratado("Pompila", "Pompini", "123456", 120
                , 7);
        LiquidadorSueldos liquidadorSueldos = new LiquidadorSueldosEmpleadosContratados();
        String resultadoEsperado = "La liquidación generada es un documento digital. Saldo a liquidar: 840";
        //Act
        String resultado = liquidadorSueldos.liquidarSueldo(empleado);
        //Assert
        Assertions.assertEquals(resultadoEsperado, resultado);

    }


    @Test
    public void caso3_no_se_puede_calcular_la_liquidacion() {
        //Arrange
        EmpleadoContratado empleado = new EmpleadoContratado("Pompila", "Pompini", "123456", 120
                , 7);
        LiquidadorSueldosEmpleadosEfectivos liquidadorSueldos = new LiquidadorSueldosEmpleadosEfectivos();
        String resultadoEsperado = "No se puedo realizar la liquidación";
        //Act
        String resultado = liquidadorSueldos.liquidarSueldo(empleado);
        //Assert
        Assertions.assertEquals(resultadoEsperado, resultado);

    }

    @Test
    public void caso3bis_no_se_puede_calcular_la_liquidacion() {
        //Arrange
        EmpleadoEfectivo empleado = new EmpleadoEfectivo("Pompila", "Pompini", "123456", 120.00
                , 7.00, 8.00);
        LiquidadorSueldosEmpleadosContratados liquidadorSueldos = new LiquidadorSueldosEmpleadosContratados();
        String resultadoEsperado = "No se puedo realizar la liquidación";
        //Act
        String resultado = liquidadorSueldos.liquidarSueldo(empleado);
        //Assert
        Assertions.assertEquals(resultadoEsperado, resultado);

    }
}
