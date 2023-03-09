package dao;

import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAOH2 implements Dao<Paciente> {

    private static final Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);

    private static final String DB_URL = "jdbc:h2:~/clinica;USER=sa;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DRIVER_URL = "org.h2.Driver";

    private static void crearDriver() {


        try {
            Class.forName(DRIVER_URL);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public void agregar(Paciente paciente) {


        Connection connection = null;
        try {

            crearDriver();
            connection = DriverManager.getConnection(DB_URL);



            String insertarPaciente = "INSERT INTO Paciente (apellido, nombre, dni, fecha_ingreso, id_domicilio) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement insertarStatement = connection.prepareStatement(insertarPaciente);

            insertarStatement.setString(1, paciente.getApellido());
            insertarStatement.setString(2, paciente.getNombre());
            insertarStatement.setString(3, paciente.getDni());
            insertarStatement.setString(4, paciente.getFechaIngreso());
            insertarStatement.setInt(5, paciente.getDomicilio().getId());

            insertarStatement.executeUpdate();

            LOGGER.info(String.format("Se agregó el paciente: %s ** %s ** %s ** %s ** %s", paciente.getApellido(),
                                      paciente.getNombre(), paciente.getDni(), paciente.getFechaIngreso(), paciente.getDomicilio().getId()));

        } catch (SQLException e) {

            LOGGER.error(e.getMessage());
        }



    }

    @Override
    public void borrar(Paciente paciente) {

    }

    @Override
    public void modificar(Paciente paciente) {

    }

    @Override
    public Paciente buscar(int id) {
        return null;
    }
}
