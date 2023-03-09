package dh.com.proxy.impl;

import model.TipoUsuario;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {

    @Test
    public void usuario_free() {

        Usuario usuario = new Usuario(12345, TipoUsuario.FREE);
        Descarga proxy = new ServicioDescargaProxy();
        String cancion = "Bombón Asesino";

        String resultadoEsperado = "Deme dinero";

        Assertions.assertEquals(proxy.descargar(usuario, cancion), resultadoEsperado);

    }

    @Test
    public void usuario_premium() {

        Usuario usuario = new Usuario(12345, TipoUsuario.PREMIUM);
        Descarga proxy = new ServicioDescargaProxy();

        String cancion = "Bombón Asesino";

        String resultadoEsperado = "Se descarga la canción " + cancion;

        Assertions.assertEquals(proxy.descargar(usuario, cancion), resultadoEsperado);

    }
}