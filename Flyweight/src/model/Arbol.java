package model;

public class Arbol {

    private double alto;
    private double ancho;
    private String color;
    private String tipo;


    public Arbol(String tipo) {

        if (tipo.equals("Ornamental")) {

            this.alto = 200.00;
            this.ancho = 400.00;
            this.color = "Verde";
            this.tipo = tipo;

        } else if (tipo.equals("Frutales")) {

            this.alto = 500.00;
            this.ancho = 300.00;
            this.color = "Rojo";
            this.tipo = tipo;

        } else {

            this.alto = 100.00;
            this.ancho = 200.00;
            this.color = "Celeste";
            this.tipo = tipo;
        }
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
