public abstract class Vendedor {
    private String nombre;
    private int ventas = 0;          

    public Vendedor(String nombre, int ventas) {
        this.nombre = nombre;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    protected String mostrarCategoria() {
        int puntos = calcularPuntos();
        return this.nombre + " tiene : " + puntos;
    }

    private void vender(int cantidadDeVentas) {
        this.ventas = +cantidadDeVentas;
    }

    public abstract int calcularPuntos();

}
