package com.company;

import com.company.model.ListaConCalculos;

public class Main {

    public static void main(String[] args) {
        ListaConCalculos l = new ListaConCalculos(1,5,7,8);
        ListaConCalculos l1 = new ListaConCalculos(1,5,7,8,9, 9);
        ListaConCalculos l2 = new ListaConCalculos(1,5,7,8,9, 3, 4, 5, 5, 5, 5,5 ,5 ,54);
        ListaConCalculos l3 = new ListaConCalculos();
        l.getPromedio();
        l.getMax();
        l.getMin();
        System.out.println("FINAL");
    }
}
