package dh.com.proxy.impl;

import model.TipoUsuario;
import model.Usuario;

public class ServicioDescargaProxy implements Descarga {

    ServicioDescarga servicioDescarga;

    public ServicioDescargaProxy() {
        this.servicioDescarga = new ServicioDescarga();
    }

    @Override
    public String descargar(Usuario usuario, String cancion) {

        if (usuario.getTipo().equals(TipoUsuario.PREMIUM)) {

            return servicioDescarga.descargar(usuario, cancion);

        } else {

            return "Deme dinero";
        }

    }
}
