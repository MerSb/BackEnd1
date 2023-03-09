public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("pablo", 2, 10);
        Empleado e2 = new Empleado("manu", 3, 20);
        Vendedor a3 = new Afiliado("gaston", 1);
        Vendedor A1 = new Afiliado("lucky", 2);

        e1.agregarAfiliado(e1);
        e1.agregarAfiliado(new Empleado("carlos", 2, 10));

        System.out.println( e1.mostrarCategoria());

    }
}