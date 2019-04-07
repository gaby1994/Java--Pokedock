import java.util.*;
import java.io.*;
import java.math.*;

public class Carte implements Serializable{
    private String typeCarte;
    private int numeroCarteDeck;
   
 

    public Carte(String tc){
	this.typeCarte=tc;
	this.numeroCarteDeck=0;
    }

    public Carte(){
        Scanner sc = new Scanner(System.in);
	int saisie;
	this.numeroCarteDeck=0;
	this.typeCarte="indefini";
	do{
	    System.out.println("Tapez le numero du type de Carte souhaitee : ");
	    System.out.println("Pour une carte Pokemon, tapez 1");
	    System.out.println("Pour une carte Dresseur, tapez 2");
	    System.out.println("Pour une carte Energie, tapez 3");
	    saisie = sc.nextInt();
	    switch(saisie){
	    case 1:
		this.typeCarte="Pokemon";
		break;
	    case 2:
		this.typeCarte="Dresseur";
		break;
	    case 3:
		this.typeCarte="Energie";
		break;
	    default :
		System.out.println("Vous devez tapez un 1, un 2 ou un 3");
	    }
	}while(typeCarte=="indefini");
    }

    public String getTypeCarte(){
	return typeCarte;
    }

    public void setTypeCarte(String tc){
	typeCarte=tc;
    }

    public int getNumeroCarteDeck(){
	return this.numeroCarteDeck;
    }

    public void setNumeroCarteDeck(int ncd){
	this.numeroCarteDeck=ncd;
    }

    /*public String toString(){
	return "Type de Carte : "+typeCarte+" | "+
	    "numero de Carte dans le deck : "+numeroCarteDeck+" | ";
	    }*/

    public String toString(){
	return "Carte numero "+numeroCarteDeck+"\n"
	    +"*************\n"
	    +"Carte "+typeCarte+"\n";
    }
}
