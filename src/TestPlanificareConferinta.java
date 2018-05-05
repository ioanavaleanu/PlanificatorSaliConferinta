import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TestPlanificareConferinta {
    private CoordonatorProiect scheduler = new CoordonatorProiect();


    public void setup(boolean disponibilitate, int nr_conferinta) {
        for (int j = 0; j < 10; j++) {
            Sala sala = new Sala("Sala " + j, 30,
                    new ArrayList<Conferinta>(), disponibilitate,
                    null, new Administrator());
            PlanificatorConferinte.listaSali.add(sala);
            for (int i = 0; i < 40; i++) {
                int d = i / 4;
                int h = 2 * (i % 4);
                if (nr_conferinta > 0 && i == nr_conferinta) {
                    nr_conferinta = -1;
                    continue;
                }
                /*if (nr_conferinta == -1)
                    System.out.print("Nu bun " + i + "\n");*/
                Conferinta conf = new Conferinta(sala, "Conferinta " + i,
                        30, LocalDate.of(2018, 5, 10 + d),
                        LocalTime.of(10 + h, 0), null, null);
                sala.getListaConferinte().add(conf);
            }
        }
       /* System.out.println("Ora " + PlanificatorConferinte.listaSali.get(0).getListaConferinte().get(29).getTime().getHour() +
                "\n Ora " + PlanificatorConferinte.listaSali.get(0).getListaConferinte().get(30).getTime().getHour());
        System.out.println("Ora " + PlanificatorConferinte.listaSali.get(0).getListaConferinte().get(29).getData().getDayOfMonth() +
                "\n Ora " + PlanificatorConferinte.listaSali.get(0).getListaConferinte().get(30).getData().getDayOfMonth());*/

    }

    @Test
    public void testDataIncorecta() {
        Conferinta[] test = new Conferinta[3];
        Conferinta[] valoriCorecte = {null, null, null};

        setup(true, -1);
        //Test zi incorecta
        test[0] = scheduler.planificareConferinta("TestDataIncorecta",
                LocalDate.of(2018, 5, 3), 20);
        //Test luna incorecta
        test[1] = scheduler.planificareConferinta("TestDataIncorecta",
                LocalDate.of(2018, 4, 30), 20);
        //Test an incorect
        test[2] = scheduler.planificareConferinta("TestDataIncorecta",
                LocalDate.of(2017, 5, 30), 20);
        Assert.assertArrayEquals(valoriCorecte, test);

    }

    @Test
    public void testPlanificareCorecta() {
        LocalDate data = LocalDate.of(2018, 5, 17);
        LocalTime time = LocalTime.of(14, 0);
        Conferinta test;

        setup(true, 30);
        test = scheduler.planificareConferinta("TestPlanificareConrecta", data, 10);
        Assert.assertEquals(data, test.getData());
        Assert.assertEquals(time, test.getTime());
    }

    @Test
    public void testInsuficienteLocuri() {
        Conferinta test;

        setup(false, -1);
        test = scheduler.planificareConferinta("TestInsuficienteLocuri",
                LocalDate.of(2018, 5, 24), 40);
        Assert.assertEquals(null, test);
    }

    @Test
    public void testSaliIndisponibile() {
        setup(false, -1);
        Conferinta test;

        test = scheduler.planificareConferinta("TestSaliIndisponibile",
                LocalDate.of(2018,5,24), 20);
        Assert.assertEquals(null, test);
    }

    @Test
    public void testFaraSali() {
        Assert.assertEquals(null, scheduler.planificareConferinta("TestFaraSali",
                LocalDate.of(2018,5,30), 20));
    }

    @After
    public void unset() {
        PlanificatorConferinte.listaSali = new ArrayList<Sala>();
    }
}
