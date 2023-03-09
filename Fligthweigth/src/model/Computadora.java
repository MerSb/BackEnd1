package model;

public class Computadora {

    private int id;
    private int ram;
    private int disco;
    private int nroInstancias;

    public Computadora(int id, int ram, int disco, int nroInstancias) {
        this.id = id;
        this.ram = ram;
        this.disco = disco;
        this.nroInstancias = nroInstancias;
    }

    public Computadora(int ram, int disco) {
        if (ram > 2) {
            System.out.println("cuesta mucho tiempo crear ram de mas de 2 gb");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.ram = ram;
        this.disco = disco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public int getNroInstancias() {
        return nroInstancias;
    }

    public void setNroInstancias(int nroInstancias) {
        this.nroInstancias = nroInstancias;
    }
}
