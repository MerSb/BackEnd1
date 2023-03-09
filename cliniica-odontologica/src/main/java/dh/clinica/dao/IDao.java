package dh.clinica.dao;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);

    public List<T> listar();


}
