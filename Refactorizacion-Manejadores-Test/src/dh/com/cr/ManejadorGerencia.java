package dh.com.cr;

import dh.com.cr.model.Mail;

public class ManejadorGerencia extends Manejador {
    @Override
    public String comprobar(Mail mail) {
        String resultado;
        if (mail.getDestino().equals("gerencia@colmena.com") || mail.getTema().equals("gerencia")) {
            resultado = "este es un mail para la gerencia";
            return resultado;
        } else {
            return this.getSiguenteManejador().comprobar(mail);
        }
    }
}
