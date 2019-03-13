package Facultate;

public class Student extends Persoana {
    private String specializare;
    private String oras;
    private Facultate1 facultatea;

    public Facultate1 getFacultatea() {
        return facultatea;
    }

    public Student(String nume, String prenume, int varsta, String specializare, String oras, Facultate1 facultatea) {
        super(nume, prenume, varsta);
        this.specializare = specializare;
        this.oras = oras;
        this.facultatea = facultatea;
        facultatea.setNumarStudenti(facultatea.getNumarStudenti()+1); // INCREMENTAREA NUMARULUI DE STUDENTI AFLATI LA FACULTATEA RESPECTIVA
    }

    public Student(String nume, String prenume, int varsta, String specializare, String oras) {
        super(nume, prenume, varsta);
        this.specializare = specializare;
        this.oras = oras;
    }

    public String getSpecializare() {
        return specializare;
    }

    public String getOras() {
        return oras;
    }

    public String toString(){
        return super.toString()+" Specializare :" + this.getSpecializare()+ " Facultatea "+ this.facultatea+ " Oras: "+ this.getOras()+  "\n";


    }


}
