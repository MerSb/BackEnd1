package dh.com.cr.service;

import dh.com.cr.model.Mail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaMailsTest {

    @Test
    public void enviar_mail_de_gerencia() {

        CompruebaMails comprobadordeMails = new CompruebaMails();
        Mail nuevoMail = new Mail("pablo.vidal@digital.house" , "gerencia@colmena.com" , "aumento de sueldo");


        String resultadoEsperado = "este es un mail para la gerencia";

        Assertions.assertEquals(comprobadordeMails.comprobarMails(nuevoMail), resultadoEsperado);

    }

    @Test
    public void enviar_mail_de_comercial() {

        CompruebaMails comprobadordeMails = new CompruebaMails();
        Mail nuevoMail = new Mail("pablo.vidal@digital.house" , "comercial@colmena.com" , "aumento de sueldo");


        String resultadoEsperado = "este es un mail para la comercial";

        Assertions.assertEquals(comprobadordeMails.comprobarMails(nuevoMail), resultadoEsperado);

    }

    @Test
    public void enviar_mail_de_tecnica() {

        CompruebaMails comprobadordeMails = new CompruebaMails();
        Mail nuevoMail = new Mail("pablo.vidal@digital.house" , "tecnica@colmena.com" , "aumento de sueldo");


        String resultadoEsperado = "este es un mail para el equipo técnico";

        Assertions.assertEquals(comprobadordeMails.comprobarMails(nuevoMail), resultadoEsperado);

    }

    @Test
    public void enviar_mail_de_spam() {

        CompruebaMails comprobadordeMails = new CompruebaMails();
        Mail nuevoMail = new Mail("pablo.vidal@digital.house" , "spam@colmena.com" , "aumento de sueldo");


        String resultadoEsperado = "Esto va a spam";

        Assertions.assertEquals(comprobadordeMails.comprobarMails(nuevoMail), resultadoEsperado);

    }

}