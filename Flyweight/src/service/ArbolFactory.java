package service;

import model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {


    public static Map<String, Arbol> cache = new HashMap<>();

    public Arbol crearArbol(String tipo) {

        String clave = "key:" + tipo;

        Arbol nuevoArbol = cache.get(clave);

        if (nuevoArbol == null) {
            nuevoArbol = new Arbol(tipo);
            cache.put(clave, nuevoArbol);
        }

        return nuevoArbol;
    }

}
