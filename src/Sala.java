import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

public class Sala {
    private String nume;
    private int nrLocuri;
    private ArrayList<Conferinta> listaConferinte;
    private boolean disponibilitate;
    private LocalDate dataMentenanta;
    private Administrator admin;

    public boolean verificareDisponibilitate() {
        return disponibilitate;
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
        int []time = new int[4];
        int i;
        int goodTime;
        for (Conferinta conf : this.getListaConferinte()) {
            if (conf.getData().equals(data)) {
                for (i = 0; i < 4; i++) {
                    if (conf.getTime().getHour() == i * 2 + 10)
                        time[i] = 1;
                }
            }
        }
        for (i = 0; i < 4; i++) {
            if (time[i] != 1) {
                goodTime = i;
                break;
            }
        }
        return LocalTime.of(10 + i * 2, 0);
    }
}
