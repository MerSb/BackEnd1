package dh.clinica.service;

import dh.clinica.dao.impl.OdontologoDaoH2;
import dh.clinica.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {


    @Test
    public void test_guardar_odontologo() {
        //Arrange
        OdontologoDaoH2 dao = new OdontologoDaoH2();
        OdontologoService odontologoService = new OdontologoService(dao);
        Odontologo odontologo = new Odontologo(1, "Pablo", "Vidal");
        //Act
        Odontologo result = odontologoService.registrar(odontologo);
        //Assert
        System.out.println(result.getId());
        Assertions.assertTrue(result.getId() != null);

    }

    @Test
    public void test_listar_odontologos() {
        //Arrange
        OdontologoDaoH2 dao = new OdontologoDaoH2();
        OdontologoService odontologoService = new OdontologoService(dao);
        //Odontologo odontologo = new Odontologo(1, "Pablo", "Vidal");
        //Act
        List<Odontologo> odontologos = odontologoService.listar();
        //Assert

        Assertions.assertTrue(odontologos.size() != 0);
    }


}