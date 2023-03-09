package dh.com.cr.service;

import dh.com.cr.*;
import dh.com.cr.model.Mail;

public class CompruebaMails {

    Manejador eslabonInicial;

    public CompruebaMails() {
        // configurar la cadena de responsabildad
        Manejador comercial = new ManejadorComercial();
        Manejador tecnica = new ManejadorTecnica();
        Manejador spam = new ManejadorSpam();
        Manejador gerencia = new ManejadorGerencia();

        gerencia.setSiguenteManejador(comercial);
        comercial.setSiguenteManejador(tecnica);
        tecnica.setSiguenteManejador(spam);

        this.eslabonInicial = gerencia;

    }

    public String comprobarMails(Mail mail) {
        return eslabonInicial.comprobar(mail);

    }


}


//        if (mail.getDestino().equals("gerencia@colmena.com") || mail.getTema().equals("gerencia")) {
//            System.out.println("este es un mail para la gerencia");
//        } else if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
//            System.out.println("este es un mail para la comercial");
//        } else if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
//            System.out.println("este es un mail para la comercial");
//        } else if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
//            System.out.println("este es un mail para la comercial");
//        } else if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
//            System.out.println("este es un mail para la comercial");
//        } else if (mail.getDestino().equals("comercial@colmena.com") || mail.getTema().equals("comercial")) {
//            System.out.println("este es un mail para la comercial");
//        }
//

