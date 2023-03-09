package dh.clinica.dao.impl;

import dh.clinica.dao.IDao;
import dh.clinica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private static final String DRIVER_URL = "org.h2.Driver";
    private static final String CONNECTION_STRING = "jdbc:h2:~/odontologosMaven;USER=sa;INIT=RUNSCRIPT FROM 'create" +
            ".sql'";


    private Connection createConnection() {

        Connection connection = null;
        try {
            Class.forName(DRIVER_URL);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;

        try {

            connection = createConnection();

            String insertQuery = "INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?);";

            PreparedStatement insertStatement = connection.prepareStatement(insertQuery,
                                                                            Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, odontologo.getMatricula());
            insertStatement.setString(2, odontologo.getNombre());
            insertStatement.setString(3, odontologo.getApellido());

            insertStatement.executeUpdate();

            ResultSet keyDomicilio = insertStatement.getGeneratedKeys();

            while (keyDomicilio.next()) {
                odontologo.setId(keyDomicilio.getInt(1));
            }

            LOGGER.info("guardando odontologo con matricula:" + odontologo.getMatricula());

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());

        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {

        List<Odontologo> odontologos = new ArrayList<>();

        Connection connection = null;

        try {

            connection = createConnection();

            String selectQuery = "SELECT * FROM ODONTOLOGO;";

            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);


            ResultSet odontologosBase = selectStatement.executeQuery();

            while (odontologosBase.next()) {

                Odontologo odontologo = new Odontologo();
                odontologo.setId(odontologosBase.getInt(1));
                odontologo.setMatricula(odontologosBase.getInt(2));
                odontologo.setNombre(odontologosBase.getString(3));
                odontologo.setApellido(odontologosBase.getString(4));

                odontologos.add(odontologo);

            }


        } catch (SQLException e) {
            LOGGER.error(e.getMessage());

        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return odontologos;

    }

}
