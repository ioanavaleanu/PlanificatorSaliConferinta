import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CoordonatorProiect extends Angajat {
    protected ArrayList<Conferinta> listaConfOrganizare;

    public void rezervareSala(String numeSala, String numeConferinta, LocalDate data, LocalTime ora) {

    }

    public void amanareConferinta(String numeSala, String numeConferinta, LocalDate data, LocalTime ora) {

    }

    public void anulareConferinta(String numeConferinta) {

    }
    public void mesajConferinta(String numeConferinta, String... mesaj) {

    }

    public void adaugareParticipant(String nume, String prenume, String numeConferinta) {

    }

    public Conferinta planificareConferinta(String nume, LocalDate data, int numarParticipanti) {
        Conferinta conferinta_noua = null;
        int nr = 0;

        if (!PlanificatorConferinte.validareData(data))
            return conferinta_noua;

        for (Sala sala : PlanificatorConferinte.listaSali) {
            if (sala.verificareDisponibilitate() &&
                    sala.getNrLocuri() >= numarParticipanti) {
                nr = 0;
                for (Conferinta conf : sala.getListaConferinte()) {
                    if (conf.getData().equals(data))
                        nr++;
                }
                if (nr < 4) {
                    ArrayList<Angajat> participanti = new ArrayList<>();
                    participanti.add(this);
                    conferinta_noua = new Conferinta(sala, nume, numarParticipanti, data,
                            sala.getAvailableTime(data), this, participanti);
                    sala.adaugareConferinta(conferinta_noua);
                    break;
                }
            }
        }
        return conferinta_noua;
    }
}
