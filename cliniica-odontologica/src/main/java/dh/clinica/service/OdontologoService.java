package dh.clinica.service;

import dh.clinica.dao.IDao;
import dh.clinica.dao.impl.OdontologoDaoH2;
import dh.clinica.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;
    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);


    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo registrar(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listar() {

        List<Odontologo> odontologos = odontologoDao.listar();

        for (Odontologo odontologo: odontologos) {

            LOGGER.info(odontologo.toString());
        }

        return odontologos;
    }
}
