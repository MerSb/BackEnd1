package dh.com.cr;

import dh.com.cr.model.Mail;

public class ManejadorComercial extends Manejador {
    @Override
    public String comprobar(Mail mail) {
        String resultado;
        if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
            resultado = "este es un mail para la comercial";
            return resultado;
        } else {
            return this.getSiguenteManejador().comprobar(mail);
        }
    }
}
