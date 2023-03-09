import dh.com.proxy.impl.Descarga;
import dh.com.proxy.impl.ServicioDescargaProxy;
import model.TipoUsuario;
import model.Usuario;

public class Main {

    public static void main(String[] args) {


        Usuario usuario = new Usuario(12345, TipoUsuario.PREMIUM);
        Descarga proxy = new ServicioDescargaProxy();
        proxy.descargar(usuario, "Bombón Asesino");

    }
}
