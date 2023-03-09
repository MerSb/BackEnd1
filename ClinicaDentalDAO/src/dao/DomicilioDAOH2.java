package dao;

import model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;

public class DomicilioDAOH2 implements Dao<Domicilio> {

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
    public void agregar(Domicilio domicilio) {

        crearDriver();

        Connection connection = null;
        try {

            connection = DriverManager.getConnection(DB_URL);

            String insertarDomicilio = "INSERT INTO Domicilio (calle, numero, localidad, provincia) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement insertarStatement = connection.prepareStatement(insertarDomicilio);

            insertarStatement.setString(1, domicilio.getCalle());
            insertarStatement.setInt(2, domicilio.getNumero());
            insertarStatement.setString(3, domicilio.getLocalidad());
            insertarStatement.setString(4, domicilio.getProvincia());

            insertarStatement.executeUpdate();

            LOGGER.info(String.format("Se agregó el domicilio: %s ** %s ** %s ** %s", domicilio.getCalle(),
                                      domicilio.getNumero(), domicilio.getLocalidad(), domicilio.getProvincia()));

        } catch (SQLException e) {

            LOGGER.error(e.getMessage());

        }
    }

    @Override
    public void borrar(Domicilio o) {

    }

    @Override
    public void modificar(Domicilio o) {

    }

    @Override
    public Domicilio buscar(int id) {

        Connection connection = null;
        try {

            crearDriver();
            connection = DriverManager.getConnection(DB_URL);

            String buscarDomicilio = "SELECT * FROM DOMICILIO WHERE ID = ?";

            PreparedStatement buscarStatement = connection.prepareStatement(buscarDomicilio);

            buscarStatement.setInt(1, id);

            ResultSet rs = buscarStatement.executeQuery();

            Domicilio domicilio = null;
            while (rs.next()) {

                domicilio = new Domicilio();

                domicilio.setCalle(rs.getString(1));
                domicilio.setNumero(rs.getInt(2));
                domicilio.setLocalidad(rs.getString(3));
                domicilio.setProvincia(rs.getString(4));
            }

            return domicilio;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
