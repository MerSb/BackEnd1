import dh.com.cr.model.Mail;
import dh.com.cr.service.CompruebaMails;

public class Main {
    public static void main(String[] args) {
        CompruebaMails comprobadordeMails = new CompruebaMails();
        comprobadordeMails.comprobarMails(new Mail("pablo.vidal@digital.house" , "gerencia@colmena.com" , "aumento de sueldo"));
        comprobadordeMails.comprobarMails(new Mail("pablo.vidal@digital.house" , "tecnica@colmena.com" , "no me anda wifi"));
        comprobadordeMails.comprobarMails(new Mail("pablo.vidal@digital.house" , "clienteenojado@gmail.com" , "gerencia"));
        comprobadordeMails.comprobarMails(new Mail("pablo.vidal@digital.house" , "comercial@colmena.com" , "madame el presupuesto"));
    }
}