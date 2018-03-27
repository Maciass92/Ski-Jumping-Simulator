import java.util.Scanner;

public class UserInterface {

    Konkurs zawody;
    Scanner reader;

    public UserInterface(){
        this.reader = new Scanner(System.in);
        this.zawody = new Konkurs(reader);
    }

    public void start(){

        System.out.println("Kumpula ski jumping week");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        zawody.zapisyZawodnikow();

        System.out.println("The tournament begins!");

        zawody.przebiegZawodow(this.reader);

        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");

        zawody.printFinalResults();
    }




}
