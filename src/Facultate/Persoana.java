package Facultate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Persoana {

    private String nume;
    private String prenume;
    private int varsta;
    private int nrordin;
    private static int id;

    public Persoana() {
    }

    public int getNrordin() {
        return nrordin;
    }

    static {
        id = 0;
    }

    {
        id++;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public static void setId(int id) {
        Persoana.id = id;
    }

    public static int getId() {
        return id;
    }

    protected Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        nrordin = id;
    }

    public String toString() {

        return "Id: " + this.getNrordin() + " Nume " + this.getNume() + " Prenume" + this.getPrenume() + " \n";
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Persoana s1=new Persoana("Balica","Adrian",21);
//        Persoana s2=new Persoana("Alinaa","Geo",22);
//        Persoana s3=new Persoana("Gigi","lara",25);
//        System.out.println( s1.toString());
//        System.out.println(s2.toString());
//        System.out.println(s3.toString());
//
//        Student studetn1= new Student("Gigi","Balica",27,"cti","FMI","Bucuresti");
//        System.out.println(studetn1.toString());
//
//        Facultate1 facultatea= new Facultate1("Facultate Mate info ","Bucale",10);
//        Student Studentie1= new Student("mancila","Doru",19,"Ctii","Mate-info","Bucurestii",facultatea);
//        System.out.println(Studentie1.toString());

        // ---------------------CREARE FACULTATI-----------------
        File file = new File("D:\\Facultatean2Sem2\\Java\\StructureOfaStudent\\src\\Facultate\\facultate.txt");
        Scanner in = new Scanner(file);
        ArrayList<Facultate1> vector = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            String numeFacultate = "";
            for (int i = 0; i < parts.length-1; i++) {

                numeFacultate = numeFacultate + parts[i] + " ";
            }
            String orasFacultate = parts[parts.length - 1];
            //  System.out.println(numeFacultate+ " dada " +orasFacultate);
            boolean gasit = false;
            for (Facultate1 f : vector) {

                if (f.getNume().equals(numeFacultate) && f.getOras().equals((orasFacultate)))
                    gasit = true;
            }
            if (gasit == false)
                vector.add(new Facultate1(numeFacultate, orasFacultate));
        }

//        for(int i=0; i< vector.size();i++){
//            System.out.println(vector.get(i).toString());



//-------------------CITIRE STUDENTI---------------


        File studentiin = new File("D:\\Facultatean2Sem2\\Java\\StructureOfaStudent\\src\\Facultate\\studenti.txt");
        Scanner cin = new Scanner(studentiin);
ArrayList<Student> studentii = new ArrayList<>();
        while (cin.hasNextLine()) {
            String line = cin.nextLine();
            String[] parts = line.split(",");
            String nume;
            String prenume;
            String oras;
            String facultate;
            String specializare;
            int varsta;
           // System.out.println(parts[0]);
            nume = parts[0];
            prenume = parts[1];
            oras = parts[2];
            specializare=parts[3];
            varsta = Integer.parseInt(parts[4]);
            facultate = parts[5];
            Facultate1 fac = null;

            for(int i=0;i<vector.size();i++){
                if(vector.get(i).getNume().trim().equals(facultate.trim()))
                    fac= vector.get(i);

            }

           // System.out.println(nume + prenume + oras+specializare + varsta + facultate+" ");


//-----------------CREARE STUDENT SI INSCRIEREA LA O FACULTATE(Principiu HAS_A)----------------



studentii.add(new Student(nume,prenume,varsta,specializare,oras,fac));

        }

        for(int i=0; i< studentii.size();i++){
            if( vector.get((i)).getOras().equals(studentii.get(i).getOras()))
            System.out.println(studentii.get(i).toString());
        }

        for(int i=0; i< vector.size();i++){
            System.out.println("Numele facultatii este"+ vector.get(i).getNume()+"si are "+ vector.get((i)).getNumarStudenti()+" studenti");
        }


        //-------------------------- SORTARE FACULTATI IN FUNCTIE DE NUMARUL DE STUDENTI-------------------



        File fileout= new File("D:\\Facultatean2Sem2\\Java\\StructureOfaStudent\\src\\Facultate\\facultate.out");
        PrintWriter out=new PrintWriter(fileout);

        Collections.sort(vector, new Comparator<Facultate1>() {
            @Override
            public int compare(Facultate1 o1, Facultate1 o2) {
                if( o1.getNumarStudenti()<o2.getNumarStudenti())
                    return 1;
                else return -1;

            }
        });
        System.out.println("\n----------------------------------");
        for(int i=0; i< vector.size();i++){
            out.print("Numele facultatii este"+ vector.get(i).getNume()+"si are "+ vector.get((i)).getNumarStudenti()+" studenti \n");
        }
out.close();

    }

}
