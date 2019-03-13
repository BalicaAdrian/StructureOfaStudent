package Facultate;

public class Facultate1 {
private String nume;
private String oras;
private int numarStudenti;

    public String getNume() {
        return nume;
    }

    public String getOras() {
        return oras;
    }

    public int getNumarStudenti() {
        return numarStudenti;
    }

    public void setNumarStudenti(int numarStudenti) {
        this.numarStudenti = numarStudenti;
    }

    public Facultate1(String nume, String oras) {
       this(nume,oras,0);

    }

    public Facultate1(String nume, String oras, int numarStudenti){

        this.nume=nume;
        this.oras=oras;
        this.numarStudenti=numarStudenti;


    }
    public String toString(){

        return this.getNume();
    }

}
