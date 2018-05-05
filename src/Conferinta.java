import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Conferinta {
    private Sala sala;
    private String nume;
    private int nrParticipanti;
    private LocalDate data;
    private LocalTime ora;
    private Angajat organizator;
    private ArrayList<Angajat> listaParticipanti;

    public Conferinta(Sala sala, String nume, int nrParticipanti, LocalDate data,
                      LocalTime ora, Angajat organizator, ArrayList<Angajat> listaParticipanti) {
        this.sala = sala;
        this.nume = nume;
        this.nrParticipanti = nrParticipanti;
        this.data = data;
        this.ora = ora;
        this.organizator = organizator;
        this.listaParticipanti = listaParticipanti;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getTime() {
        return ora;
    }

    public void adaugareParticipant(Angajat angajat) {

    }

    public void modificareSala(Sala sala) {

    }

    public void modificareData(LocalDate data) {

    }

    public void mesajParticipanti(String mesaj) {

    }
}
