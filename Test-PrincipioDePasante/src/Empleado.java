
import java.util.ArrayList;

public class Empleado extends Vendedor {

    public static final int VALOR_CANTIDAD_AFILIADOS = 10;
    public static final int VALOR_VENTA = 5;
    public static final int VALOR_ANTIGUEDAD = 5;
    private int antiguedad;
    private ArrayList<Vendedor> listaAfiliados = new ArrayList<>();

    public Empleado(String nombre, int antiguedad, int ventas) {
        super(nombre, ventas);
        this.antiguedad = antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void agregarAfiliado(Vendedor afiliado) {
        this.listaAfiliados.add(afiliado);
    }

    @Override
    public int calcularPuntos() {
        return this.listaAfiliados.size() * VALOR_CANTIDAD_AFILIADOS +
                this.getVentas() * VALOR_VENTA +
                this.antiguedad * VALOR_ANTIGUEDAD;
    }
}
