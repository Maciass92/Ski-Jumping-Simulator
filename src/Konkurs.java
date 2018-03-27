import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Konkurs {

    private Scanner reader;
    private ArrayList<Zawodnik> listaZawodnikow = new ArrayList<>();
    private Random rand;

    public Konkurs(Scanner reader){
        this.reader = reader;
        this.rand = new Random();
    }


    public void zapisyZawodnikow(){

        String name = "";

        while(true){

            System.out.println("  Participant name: ");
            name = reader.nextLine();

            if (name.equals(""))
                break;

            listaZawodnikow.add(new Zawodnik(name));
        }
    }

    public void przebiegZawodow (Scanner reader){

        String command = "";
        int runda = 1;

        while(true) {

            System.out.println("Write \"jump\" to jump; otherwise you quit: ");

            command = reader.nextLine();

            if (command.equals("jump")) {
                Collections.sort(listaZawodnikow);

                System.out.println("Round " + runda + "\n");
                System.out.println("Jumping order:");

                this.printKolejnosc();
                this.skakanko();
                this.printRoundResults(runda);

                runda++;
            }

            else
                break;
        }
    }

    public void printFinalResults(){

        Collections.sort(listaZawodnikow);
        Collections.reverse(listaZawodnikow);

        for (Zawodnik gracz : listaZawodnikow){
            String odl = "";

            System.out.println((listaZawodnikow.indexOf(gracz) + 1) + "           " + gracz.getName() + " (" + gracz.obliczSumePunktow() + " points)");

            for(int i = 0; i < gracz.getListaSkokow().size(); i++)
                odl += gracz.getListaSkokow().get(i) + " m, ";
            System.out.println("            jump lengths: " + odl);

        }
    }


    public void printKolejnosc(){

        for(int i = 0; i < listaZawodnikow.size(); i++)
            System.out.println("  " + (i+1) + ". " + this.listaZawodnikow.get(i).getName() + " (" + this.listaZawodnikow.get(i).obliczSumePunktow() + " points)");
    }

    public void skakanko(){

        int skok = 0;
        int sumaPunktow = 0;

        for (Zawodnik skoczek : this.listaZawodnikow){

            ArrayList<Integer> punktyZaSkok = new ArrayList<>();

            skok = 60 + rand.nextInt(60);
            skoczek.dodajDoListySkokow(skok);

            for(int i = 0; i < 5; i++)
                punktyZaSkok.add(10 + rand.nextInt(10));

            skoczek.dodajDoListySzczegolowej(punktyZaSkok);

            for(int i = 0; i < 5; i++)
                sumaPunktow += punktyZaSkok.get(i);

            sumaPunktow = sumaPunktow + skok - Collections.min(punktyZaSkok) - Collections.max(punktyZaSkok);

            skoczek.dodajPunktyDoListy(sumaPunktow);

            sumaPunktow = 0;
        }
    }


    public void printRoundResults(int runda) {
        System.out.println("\nResults of round " + runda);

        for (Zawodnik gracz : listaZawodnikow) {
            System.out.println("  " + gracz.getName());
            System.out.println("    length: " + gracz.getListaSkokow().get(runda - 1));
            System.out.println("    judge votes: " + gracz.getListaSzczegolowa().get(runda - 1));
        }
    }

}
