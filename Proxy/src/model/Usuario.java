package model;

public class Usuario {

    private int identificador;
    TipoUsuario tipo;

    public Usuario(int identificador, TipoUsuario tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public int identificador() {
        return identificador;
    }

    public void identificador(int identificador) {
        this.identificador = identificador;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
