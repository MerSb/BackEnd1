package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

public class ListaConCalculos {

    private static final Logger LOGGER = Logger.getLogger(ListaConCalculos.class);
    List<Integer> lista = new ArrayList<>();


    public ListaConCalculos(int... values) {
        for (int value : values) {
            lista.add(value);
        }
        if (lista.size()>10){
            LOGGER.info("La longitud de la lista es mayor a 10");
        }else if (lista.size()>5){
            LOGGER.info("La longitud de la lista es mayor a 5");
        } else if (lista.size() == 0){
            LOGGER.error("La lista es igual a cero");
        }
    }

    public Double getPromedio() {
        Double total = 0D;
        for (int value : lista) {
            total += value;
        }
        Double promedio = total / lista.size();
        LOGGER.info(promedio);
        return promedio;
    }

    public int getMax() {
        int max = Collections.max(lista);
        System.out.println(max);
        return max;
//otra opción:
//        int max = 0;
//        for (int value: lista) {
//            if (value> max){
//                max = value;
//            }
//        }
//        return max;
    }


    public int getMin() {
        int min = Collections.min(lista);
        System.out.println(min);
        return min;
    }
}