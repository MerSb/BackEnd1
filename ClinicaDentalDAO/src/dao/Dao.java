package dao;

public interface Dao<T> {

    public void agregar(T t);
    public void borrar(T t);
    public void modificar(T t);
    T buscar(int id);


}
