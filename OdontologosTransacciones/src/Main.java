import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Logger LOGGER = Logger.getLogger(Main.class);


        try {

            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e ){
            throw new RuntimeException(e);

        }

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:h2:~/test;USER=sa");
            connection.setAutoCommit(false);

            Odontologo odontologo1 = new Odontologo("ODO123", "Cinthia", "Perez");

            String crearTabla = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO (Matricula VARCHAR(15) " +
                    "PRIMARY KEY, Nombre VARCHAR(255), Apellido VARCHAR(255))";

            PreparedStatement statCreate = connection.prepareStatement(crearTabla);

            statCreate.executeUpdate();

            connection.commit();

            String insertarOdontologo = "INSERT INTO ODONTOLOGO (Matricula, Nombre, Apellido) VALUES (?, ?, ?)";

            PreparedStatement statInsert = connection.prepareStatement(insertarOdontologo);

            statInsert.setString(1, odontologo1.getMatricula());
            statInsert.setString(2, odontologo1.getNombre());
            statInsert.setString(3, odontologo1.getApellido());

            statInsert.executeUpdate();

            connection.commit();

            String selectOdontologo = "SELECT * FROM ODONTOLOGO";

            PreparedStatement statSelect = connection.prepareStatement(selectOdontologo);

            ResultSet rs1 = statSelect.executeQuery();

            while (rs1.next()) {
                System.out.println(rs1.getString(1) + "***" + rs1.getString(2) + "***" + rs1.getString(3));
            }

            String updateOdontologo = "UPDATE ODONTOLOGO SET Matricula = ? WHERE Matricula = ?";

            PreparedStatement statUpdate = connection.prepareStatement(updateOdontologo);

            statUpdate.setString(1, "ODO-1000");
            statUpdate.setString(2, odontologo1.getMatricula());

            statUpdate.executeUpdate();

            connection.commit();

            ResultSet rs2 = statSelect.executeQuery();

            while (rs2.next()) {
                System.out.println(rs2.getString(1) + "***" + rs2.getString(2) + "***" + rs2.getString(3));
            }


        } catch (SQLException e ) {

            LOGGER.error(e);
        } finally {
            if (connection != null) {
                connection.close();

            }
        }



    }
}
