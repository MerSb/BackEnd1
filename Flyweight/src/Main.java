import model.Arbol;
import service.ArbolFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArbolFactory arbolFactory = new ArbolFactory();

        List<Arbol> campito = new ArrayList<>();


        for (int i = 0; i < 1000000; i++) {

            if (i % 2 == 0) {

                campito.add(arbolFactory.crearArbol("Ornamental"));

            } else {

                campito.add(arbolFactory.crearArbol("Frutales"));
            }
        }

        System.out.println("Tamaño cache: " + ArbolFactory.cache.size());
        System.out.println("La cantidad de árboles es: " + campito.size());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }
}
