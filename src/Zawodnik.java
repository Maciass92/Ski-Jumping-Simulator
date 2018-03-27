import java.util.ArrayList;

public class Zawodnik implements Comparable<Zawodnik>{

    private ArrayList<Integer> listaPunktow;
    private ArrayList<Integer> listaSkokow;
    private ArrayList<ArrayList<Integer>> listaSzczegolowa;
    private String name;

    public Zawodnik(String name){

        this.listaPunktow = new ArrayList<Integer>();
        this.listaSkokow = new ArrayList<Integer>();
        this.listaSzczegolowa = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getListaSkokow() {
        return listaSkokow;
    }

    public ArrayList<ArrayList<Integer>> getListaSzczegolowa() {
        return listaSzczegolowa;
    }

    public void dodajDoListySkokow (Integer skok){

        listaSkokow.add(skok);
    }

    public void dodajPunktyDoListy (Integer sumaPunktow){

        listaPunktow.add(sumaPunktow);
    }

    public void dodajDoListySzczegolowej (ArrayList<Integer> skoki){

        listaSzczegolowa.add(skoki);
    }

    public int obliczSumePunktow(){

        int suma = 0;

        for (Integer i : listaPunktow)
            suma += i;

        return suma;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.obliczSumePunktow();
    }

    @Override
    public int compareTo(Zawodnik other) {
        return Integer.compare(this.obliczSumePunktow(), other.obliczSumePunktow());
    }
}
