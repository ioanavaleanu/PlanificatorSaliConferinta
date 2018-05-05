import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sala implements Serializable{
    private String nume;
    private int nrLocuri;
    private ArrayList<Conferinta> listaConferinte;
    private boolean disponibilitate;
    private LocalDate dataMentenanta;
    private Administrator admin;

    public Sala() {
        listaConferinte = new ArrayList<Conferinta>();
    }

    public Sala(String nume, int nrLocuri, ArrayList<Conferinta> listaConferinte,
                boolean disponibilitate, LocalDate dataMentenanta, Administrator admin) {
        this.nume = nume;
        this.nrLocuri = nrLocuri;
        this.listaConferinte = listaConferinte;
        this.disponibilitate = disponibilitate;
        this.dataMentenanta = dataMentenanta;
        this.admin = admin;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }
    public ArrayList<Conferinta> getListaConferinte() {
        return listaConferinte;
    }

    public boolean adaugareConferinta(Conferinta conferinta) {
        return true;
    }

    public boolean eliminareConferinta(String nume) {
        return true;
    }

    public void modificareDisponibilitate(boolean stare) {

    }

    public LocalTime getAvailableTime(LocalDate data) {
        int []time = {0, 0, 0, 0};
        int goodTime = -1;

        for (Conferinta conf : this.getListaConferinte()) {
            if (conf.getData().equals(data)) {
                for (int i = 0; i < 4; i++) {
                    if (conf.getTime().getHour() == i * 2 + 10)
                        time[i] = 1;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (time[i] != 1) {
                goodTime = i;
                break;
            }
        }
        if (goodTime != -1)
            return LocalTime.of(10 + goodTime * 2, 0);
        else
            return null;
    }

    public boolean verificareDisponibilitate() {
        return disponibilitate;
    }
}
