package dh.com.proxy.impl;

import model.Usuario;

public class ServicioDescarga implements Descarga {
    @Override
    public String descargar(Usuario usuario, String cancion) {

        return "Se descarga la canción " + cancion;

    }
}
