import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        Empleado empleado1 = new Empleado(1, "Pedro", "Perez", 25, 2);
        Empleado empleado2 = new Empleado(2, "Juan", "Gonzalez", 25, 2);
        Empleado empleado3 = new Empleado(3, "Julian", "Gutierrez", 25, 2);

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = null;

        try {
            c = DriverManager.getConnection("jdbc:h2:~/test;USER=sa");

            Statement statement = c.createStatement();
            statement.execute("DROP TABLE IF EXISTS EMPLEADO;\n" +
                                      "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), EDAD INT, ANTIGUEDAD INT);\n");

            String query = String.format("INSERT INTO EMPLEADO VALUES(%s, '%s', '%s', %s, %s);\n" +
                                                 "INSERT INTO EMPLEADO VALUES(%s, '%s', '%s', %s, %s);\n" +
                                                 "INSERT INTO EMPLEADO VALUES(%s, '%s', '%s', %s, %s);",
                                         empleado1.getId(),
                                         empleado1.getNombre(), empleado1.getApellido(), empleado1.getEdad(),
                                         empleado1.getAntigueadad(), empleado2.getId(), empleado2.getNombre(),
                                         empleado2.getApellido(),
                                         empleado2.getEdad(),
                                         empleado2.getAntigueadad(), empleado3.getId(), empleado3.getNombre(),
                                         empleado3.getApellido(),
                                         empleado3.getEdad(),
                                         empleado3.getAntigueadad());

            statement.execute(query);


            String apellidoViejo = empleado2.getApellido();
            empleado2.setApellido("NuevoApellido");

            String queryUpdate = String.format("UPDATE EMPLEADO SET APELLIDO = '%s' WHERE ID = 2",
                                               empleado2.getApellido());


            statement.execute(queryUpdate);
            LOGGER.debug(String.format("Se actualizó el apellido del empleado: %s, %s, %s, %s, %s por %s",
                                      empleado2.getId(), empleado2.getNombre(), apellidoViejo, empleado2.getEdad(),
                                      empleado2.getAntigueadad(), empleado2.getApellido()));

            String queryDeletePorId = String.format("DELETE FROM EMPLEADO WHERE ID = %s",
                                                    empleado2.getId());
            statement.execute(queryDeletePorId);
            LOGGER.info("El empleado " + empleado2 + " fue eliminado de la base");

            String queryDeletePorNombre = String.format("DELETE FROM EMPLEADO WHERE NOMBRE = '%s'",
                                                    empleado3.getNombre());

            statement.execute(queryDeletePorNombre);
            LOGGER.info("El empleado " + empleado3 + " fue eliminado de la base");

        } catch (SQLException e) {

            LOGGER.error(e);
        }
    }
}