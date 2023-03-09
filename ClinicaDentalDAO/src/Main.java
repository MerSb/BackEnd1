import dao.DomicilioDAOH2;
import dao.PacienteDAOH2;
import model.Domicilio;
import model.Paciente;
import service.PacienteService;

public class Main {

    public static void main(String[] args) {

        PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
        DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
        PacienteService pacienteService = new PacienteService(pacienteDAOH2, domicilioDAOH2);

        Domicilio domicilio = new Domicilio(2, "Calle Falsa", 123, "Localidad", "Provincia");
        Paciente paciente = new Paciente(1, "Perez", "Pablo", "33333333", "22/12/2022", domicilio);

        pacienteService.agregarPaciente(paciente);

    }
}
