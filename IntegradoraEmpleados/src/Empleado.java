public class Empleado {

    private int id;
    private String nombre;

    private String apellido;
    private int edad;
    private int antigueadad;

    public Empleado(int id, String nombre, String apellido, int edad, int antigueadad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.antigueadad = antigueadad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntigueadad() {
        return antigueadad;
    }

    public void setAntigueadad(int antigueadad) {
        this.antigueadad = antigueadad;
    }

    @Override
    public String toString() {
        return "id: " + id + " nombre: " + nombre + " apellido: " + apellido + " edad: " + edad + " antigüedad: " + antigueadad;
    }
}
