import java.util.*;
import java.io.*;

public class Attaque implements Serializable{
    private String nomAttaque;
    private String typeAttaque;
    private int nbEnergies;
    private int nbDegatsAttaque;
    private int nbIncolore;
    private String descriptionAttaque;

    public Attaque(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Entrez le nom de l'attaque : ");
	this.nomAttaque=sc.nextLine();
	System.out.println("Entrez le type de l'attaque : ");
	this.typeAttaque=sc.nextLine();
	System.out.println("Entrez le nombre d'energies : ");
	this.nbEnergies=sc.nextInt();
	System.out.println("Entrez le nombre de degats de l'attaque : ");
	this.nbDegatsAttaque=sc.nextInt();
	System.out.println("Entrez le nombre de cartes Incolore : ");
	this.nbIncolore=sc.nextInt();
	sc.nextLine();
	System.out.println("Entrez la description de l'attaque : ");
	this.descriptionAttaque=sc.nextLine();
	
    }
    
    //classe testee dans une classe de test
    public Attaque(String na,String ta,int nbE,int nbD,int nbI,String da){
	this.nomAttaque=na;
	this.descriptionAttaque=da;
	this.typeAttaque=ta;
	this.nbEnergies=nbE;
	this.nbDegatsAttaque=nbD;
	this.nbIncolore=nbI;
    }

    public String getNomAttaque(){
	return nomAttaque;
    }

    public void setNomAttaque(String na){
        this.nomAttaque=na;
    }

    public String getTypeAttaque(){
	return typeAttaque;
    }

    public void setTypeAttaque(String ta){
        this.typeAttaque=ta;
    }

    public int getNbEnergies(){
	return nbEnergies;
    }

    public void setNbEnergies(int nbE){
        this.nbEnergies=nbE;
    }

    public int getNbDegatsAttaque(){
	return nbDegatsAttaque;
    }

    public void setNbDegatsAttaque(int nbD){
        this.nbDegatsAttaque=nbD;
    }

    public int getNbIncolore(){
	return nbIncolore;
    }

    public void setNbIncolore(int nbI){
        this.nbIncolore=nbI;
    }

    public String getDescriptionAttaque(){
	return descriptionAttaque;
    }

    public void setDescriptionAttaque(String da){
        this.descriptionAttaque=da;
    }

    public String toString(){
	return "[nom Attaque : "+nomAttaque+"\n"+
	    "        descriptionAttaque : "+descriptionAttaque+"\n"+
	    "        type Attaque : "+typeAttaque+"\n"+
	    "        nombre d'energies : "+nbEnergies+"\n"+
	    "        nombre Incolore : "+nbIncolore+"\n"+
	    "        nombre de degats : "+nbDegatsAttaque+"]";
    }
}
