package dh.com.cr;

import dh.com.cr.model.Mail;

public abstract class Manejador {

    private Manejador siguenteManejador;

    public Manejador getSiguenteManejador() {
        return this.siguenteManejador;
    }

    public void setSiguenteManejador(Manejador manejador) {
        this.siguenteManejador = manejador;
    }

    public abstract String comprobar(Mail mail);

}
