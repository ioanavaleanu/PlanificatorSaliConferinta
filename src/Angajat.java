import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Angajat implements Serializable{
    protected String nume;
    protected String prenume;
    protected String username;
    protected String parola;
    protected File mesaje;
    protected Utilizator tipUtilizator;
    protected ArrayList<Conferinta> listaConferinte;
    protected boolean mesajeCitite;

    public Angajat(){

    }

    public void vizualizarePlanificareSali() {

    }

    public void vizualizareMesaje() {

    }

    public void afisareDateParticipare() {

    }
}
