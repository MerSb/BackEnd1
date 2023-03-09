package service;

import dao.DomicilioDAOH2;
import dao.PacienteDAOH2;
import model.Domicilio;
import model.Paciente;

public class PacienteService {


    private PacienteDAOH2 pacienteDAOH2;
    private DomicilioDAOH2 domicilioDAOH2;

    public PacienteService(PacienteDAOH2 pacienteDAOH2, DomicilioDAOH2 domicilioDAOH2) {
        this.pacienteDAOH2 = pacienteDAOH2;
        this.domicilioDAOH2 = domicilioDAOH2;
    }


    public void agregarPaciente(Paciente paciente) {

        int idDomicilio = paciente.getDomicilio().getId();

        Domicilio domicilioBase = domicilioDAOH2.buscar(idDomicilio);

        if(domicilioBase == null) {
            domicilioDAOH2.agregar(paciente.getDomicilio());
        }

        pacienteDAOH2.agregar(paciente);

    }
}
