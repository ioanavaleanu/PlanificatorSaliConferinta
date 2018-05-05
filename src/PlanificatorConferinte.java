import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlanificatorConferinte {
    static public ArrayList<Sala> listaSali = new ArrayList<Sala>();
    static public ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();

    public static void salvareDateConferinta(Conferinta object, String fisier) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(fisier));
        objstream.writeObject(object);
        objstream.close();
    }

    public static Conferinta incarcareDateConferinta(String fisier) throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(fisier));
        Conferinta object = (Conferinta) objstream.readObject();
        objstream.close();
        return object;
    }

    public void serializareSala(Sala sala, String fisier) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(fisier));
        objstream.writeObject(sala);
        objstream.close();
    }

    public Sala incarcareSala(String fisier) throws IOException, ClassNotFoundException {
        ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(fisier));
        Sala object = (Sala) objstream.readObject();
        objstream.close();
        return object;
    }

    static public boolean validareData(LocalDate data) {
        LocalDate data_curenta = LocalDate.now();
        if (data_curenta.getYear() < data.getYear())
            return true;
        else if (data_curenta.getYear() == data.getYear() && data_curenta.getMonthValue() < data.getMonthValue())
            return true;
        else if (data_curenta.getYear() == data.getYear() && data_curenta.getMonthValue() == data.getMonthValue() &&
                data_curenta.getDayOfMonth() <= data.getDayOfMonth())
            return true;
        else
            return false;
    }

    public Angajat incarcareDateAngajati(String fisier) {
        return new Angajat();
    }

    public boolean autentificare() {
        return true;
    }

    public void serializareAngajat(Angajat angajat, String fisier) {

    }

}
