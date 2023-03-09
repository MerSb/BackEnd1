package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ArbolFactory;

public class ArbolFactoryTest {

    @Test
    public void crear_arbol_existente() {

        ArbolFactory arbolFactory = new ArbolFactory();

        arbolFactory.crearArbol("Ornamental");
        arbolFactory.crearArbol("Ornamental");

        int cantidadDeArbolesEsperada = 1;

        Assertions.assertEquals(ArbolFactory.cache.size(), cantidadDeArbolesEsperada);

    }

    @Test
    public void crear_arbol_nuevo() {

        ArbolFactory arbolFactory = new ArbolFactory();

        arbolFactory.crearArbol("Ornamental");
        arbolFactory.crearArbol("Frutal");

        int cantidadDeArbolesEsperada = 2;

        Assertions.assertEquals(ArbolFactory.cache.size(), cantidadDeArbolesEsperada);

    }
}
