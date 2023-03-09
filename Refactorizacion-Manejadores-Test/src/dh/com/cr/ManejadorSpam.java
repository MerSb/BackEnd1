package dh.com.cr;

import dh.com.cr.model.Mail;

public class ManejadorSpam extends Manejador {
    @Override
    public String comprobar(Mail mail) {
        String resultado;
        resultado = "Esto va a spam";

        return resultado;
    }
}
