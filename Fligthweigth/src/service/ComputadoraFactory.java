package service;

import model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {

    private static Map<String, Computadora> cache = new HashMap<>();

    public Computadora crearComputadora(int ram, int disco) {
        return new Computadora(ram, disco);
    }

    public Computadora crearComputadoraConPatron(int ram, int disco) {

        String clave = "key:" + ram + ":" + disco; // key:2:500

        Computadora newCompu = cache.get(clave);

        if (newCompu == null) {
            newCompu = new Computadora(ram, disco);
            cache.put(clave, newCompu);
        }

        return newCompu;
    }
}
