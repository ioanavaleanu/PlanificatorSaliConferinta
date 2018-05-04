import java.util.ArrayList;
import java.util.Date;

public class Sala {
    private String nume;
    private int nrLocuri;
    private ArrayList<Conferinta> listaConferinte;
    private boolean disponibilitate;
    private Date dataMentenanta;
    private Administrator admin;

    public boolean verificareDisponibilitate() {
        return disponibilitate;
    }

    public boolean adaugareConferinta(Conferinta conferinta) {
        return true;
    }

    public boolean eliminareConferinta(String nume) {
        return true;
    }

    public void modificareDisponibilitate(boolean stare) {

    }
}
