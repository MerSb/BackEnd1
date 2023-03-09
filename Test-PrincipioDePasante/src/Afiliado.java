public class Afiliado extends Vendedor {


    public static final int VALOR_VENTA_AFILIADO = 15;

    public Afiliado(String nombre, int ventas) {
        super(nombre, ventas);
    }

    @Override
    public int calcularPuntos() {
        return this.getVentas() * VALOR_VENTA_AFILIADO;
    }
}
