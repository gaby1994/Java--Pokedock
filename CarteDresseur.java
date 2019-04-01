import java.util.Scanner;
import java.io.*;
import java.math.*;

public class CarteDresseur extends Carte implements Serializable{
    private String typeDresseur;
    private String extensionCarte;
    private String numeroCarte;
    private String nomDresseur;
    private String regleDresseur;
    private String texteDresseur;

    public CarteDresseur(){
	Scanner sc = new Scanner(System.in);
	int saisie;
	this.typeDresseur="indefini";
	do{
	    System.out.println("Tapez le type de dresseur souhaite : ");
	    System.out.println("Pour un dresseur de type Objet, tapez 1");
	    System.out.println("Pour un dresseur de type Supporter, tapez 2");
	    System.out.println("Pour un dresseur de type Stade, tapez 3");
	    saisie = sc.nextInt();
	    switch(saisie){
	    case 1:
		this.typeDresseur="Objet";
		break;
	    case 2:
	        this.typeDresseur="Supporter";
		break;
	    case 3:
		this.typeDresseur="Stade";
		break;
	    default:
		System.out.println("Vous devez entrer soit un 1, soit un 2, soit un 3");
	    }
	}while(this.typeDresseur=="indefini");

	sc.nextLine();
	System.out.println("Entrez l'extension de la carte");
        this.extensionCarte=sc.nextLine();
	System.out.println("Entrez le numero de la carte");
        this.numeroCarte=sc.nextLine();
	System.out.println("Entrez le nom du dresseur");
        this.nomDresseur=sc.nextLine();
        System.out.println("Entrez la regle du dresseur");
        this.regleDresseur=sc.nextLine();
	System.out.println("Entrez le texte du dresseur");
        this.texteDresseur=sc.nextLine();
    }

    public CarteDresseur(String tc,String tyD,String ec,String nc,String nd,String rd,String td){
	super(tc);
	this.typeDresseur=tyD;
	this.extensionCarte=ec;
	this.numeroCarte=nc;
	this.nomDresseur=nd;
	this.regleDresseur=rd;
	this.texteDresseur=td;
    }

    public String getTypeDresseur(){
	return typeDresseur;
    }

    public void setTypeDresseur(String tyD){
	this.typeDresseur=tyD;
    }

    public String getExtensionCarte(){
	return this.extensionCarte;
    }

    public void setExtensionCarte(String ec){
	this.extensionCarte=ec;
    }

    public String getNumeroCarte(){
	return this.numeroCarte;
    }

    public void setNumeroCarte(String nc){
	this.numeroCarte=nc;
    }

    public String getNomDresseur(){
	return nomDresseur;
    }

    public void setNomDresseur(String nd){
	this.nomDresseur=nd;
    }

    public String getTexteDresseur(){
	return texteDresseur;
    }

    public void setRegleDresseur(String rd){
	this.regleDresseur=rd;
    }

    public void setTexteDresseur(String td){
	this.texteDresseur=td;
    }

    public String getRegleDresseur(){
	return texteDresseur;
    }

    public String toString(){
	return super.toString()+"type de Dresseur : "+this.typeDresseur+" | "+
	    "extension de la carte : "+this.extensionCarte+" | "+
	    "numero de la carte : "+this.numeroCarte+" | "+
	    "nom du Dresseur : "+this.nomDresseur+" | "+
	    "regle du Dresseur : "+this.regleDresseur+"| "+
	    "texte du Dresseur : "+this.texteDresseur;
    }
}


