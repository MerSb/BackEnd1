package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problema con la conexion");
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:./test4;PASSWORD=sa;USER=sa");

            String delete = "DROP TABLE IF EXISTS FIGURAS;";

            Statement statementDelete = connection.createStatement();
            statementDelete.execute(delete);

            String create = "CREATE TABLE FIGURAS (ID INT PRIMARY KEY, TIPO VARCHAR(100) NOT NULL, COLOR VARCHAR(100) NOT NULL)";

            Statement statementCreate = connection.createStatement();
            statementCreate.execute(create);

            String insert = "INSERT INTO FIGURAS VALUES(1, 'CIRCULO', 'ROJO')";
            String insert2 = "INSERT INTO FIGURAS VALUES(2, 'CIRCULO', 'VERDE')";
            String insert3 = "INSERT INTO FIGURAS VALUES(3, 'CUADRADO', 'VERDE')";
            String insert4 = "INSERT INTO FIGURAS VALUES(4, 'CUADRADO', 'VERDE')";
            String insert5 = "INSERT INTO FIGURAS VALUES(5, 'CUADRADO', 'VERDE')";

            Statement statementInsert = connection.createStatement();
            statementInsert.execute(insert);

            Statement statementInsert2 = connection.createStatement();
            statementInsert2.execute(insert2);

            Statement statementInsert3 = connection.createStatement();
            statementInsert3.execute(insert3);

            Statement statementInsert4 = connection.createStatement();
            statementInsert4.execute(insert4);

            Statement statementInsert5 = connection.createStatement();
            statementInsert5.execute(insert5);

            String mostrarCirculosRojos = "SELECT * FROM FIGURAS WHERE COLOR = 'ROJO' AND TIPO = 'CIRCULO'";

            Statement listarCirculosRojos = connection.createStatement();

            ResultSet resultado0 = listarCirculosRojos.executeQuery(mostrarCirculosRojos);

            while (resultado0.next()){
                System.out.println(resultado0.getInt(1)+"***"+resultado0.getString(2)+"***"+resultado0.getString(3));
            }

            String listar = "SELECT * FROM FIGURAS";

            Statement statement = connection.createStatement();

            ResultSet resultado = statement.executeQuery(listar);

            System.out.println("NUEVO RESULTSET:");
            while (resultado.next()){
                System.out.println(resultado.getInt(1)+"***"+resultado.getString(2)+"***"+resultado.getString(3));
            }


        } catch (SQLException e) {
            System.out.println("tuve un problema con la conexion: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }

    }
}
//
//        Mostrar todas las figuras en pantalla con un ResultSet y un System.out.println.

