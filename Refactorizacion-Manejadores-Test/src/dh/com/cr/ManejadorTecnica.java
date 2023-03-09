package dh.com.cr;

import dh.com.cr.model.Mail;

public class ManejadorTecnica extends Manejador {
    @Override
    public String comprobar(Mail mail) {

        String resultado;
        if (mail.getDestino().equals("tecnica@colmena.com") || mail.getTema().equals("tecnica")) {
            resultado = "este es un mail para el equipo técnico";
            return resultado;
        } else {
            return this.getSiguenteManejador().comprobar(mail);
        }

    }
}
