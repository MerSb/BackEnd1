import model.Computadora;
import service.ComputadoraFactory;

import java.util.List;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        long ini = System.currentTimeMillis();
//        ComputadoraFactory factory = new ComputadoraFactory();
//
//        List<Computadora> compus = new ArrayList<>();
//        Computadora mac1 = factory.crearComputadora(16, 500);
//        for (int i = 0; i < 100; i++) {
//            compus.add(factory.crearComputadora(16, 500));
//        }
//        for (int i = 0; i < 100; i++) {
//            compus.add(factory.crearComputadora(2, 128));
//        }
//
//        long fin = System.currentTimeMillis();
//
//        System.out.println("Tardo :" + (fin - ini));
//    }


    long ini = System.currentTimeMillis();
    ComputadoraFactory factory = new ComputadoraFactory();

    List<Computadora> compus = new ArrayList<>();
    Computadora mac1 = factory.crearComputadoraConPatron(16, 500);
        for (int i = 0; i < 100; i++) {
        compus.add(factory.crearComputadoraConPatron(16, 500));
    }
        for (int i = 0; i < 100; i++) {
        compus.add(factory.crearComputadoraConPatron(2, 128));
    }

    long fin = System.currentTimeMillis();

        System.out.println("Tardo :" + (fin - ini));
}


}