import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contacto> listaContactos = new ArrayList<Contacto>();


        listaContactos.add(new Contacto("Persona1", "mail1@mail.com", 666666666));
        listaContactos.add(new Contacto("Persona2", "mail2@mail.com", 55555555));

        try {
            FileOutputStream fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream os = new ObjectOutputStream(fo);

            os.writeObject(listaContactos);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Contacto> listaRecuperada = null;
        ObjectInputStream oi = null;
        try {
            FileInputStream fi = new FileInputStream("OutputFile.txt");
            oi = new ObjectInputStream(fi);

            listaRecuperada = (ArrayList) oi.readObject();

        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        for (Contacto c : listaRecuperada) {
            System.out.println(c.getNombre() + "-" + c.getMail() + "-" + c.getTelefono());
        }

    }
}
