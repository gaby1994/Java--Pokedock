import java.util.*;

public class CarteEnergie extends Carte{
    private String typeEnergie;

    public CarteEnergie(){
	Scanner sc = new Scanner(System.in);
	int saisie;
	this.typeEnergie="indefini";
	do{
	    System.out.println("Tapez le type d'energie souhaitee : ");
	    System.out.println("Pour une energie de type Plante, tapez 1");
	    System.out.println("Pour une energie de type Feu, tapez 2");
	    System.out.println("Pour une energie de type Eau, tapez 3");
	    System.out.println("Pour une energie de type Electrique, tapez 4");
	    System.out.println("Pour une energie de type Psy, tapez 5");
	    System.out.println("Pour une energie de type Combat, tapez 6");
	    System.out.println("Pour une energie de type Obscurite, tapez 7");
	    System.out.println("Pour une energie de type Metal, tapez 8");
	    System.out.println("Pour une energie de type Fee, tapez 9");
	    System.out.println("Pour une energie de type Dragon, tapez 10");
	    System.out.println("Pour une energie de type Incolore, tapez 11");
	    saisie = sc.nextInt();
	    switch(saisie){
	    case 1:
		this.typeEnergie="Plante";
		break;
	    case 2:
	        this.typeEnergie="Feu";
		break;
	    case 3:
		this.typeEnergie="Eau";
		break;
	    case 4:
		this.typeEnergie="Electrique";
		break;
	    case 5:
		this.typeEnergie="Psy";
		break;
	    case 6:
		this.typeEnergie="Combat";
		break;
	    case 7:
		this.typeEnergie="Obscurite";
		break;
	    case 8:
		this.typeEnergie="Metal";
		break;
	    case 9:
		this.typeEnergie="Fee";
		break;
	    case 10:
		this.typeEnergie="Dragon";
		break;
	    case 11:
		this.typeEnergie="Incolore";
		break;	
	    default :
		System.out.println("Vous devez tapez un nombre compris entre 1 et 11");
	    }
	}while(typeEnergie=="indefini");
    }

    public CarteEnergie(String tc,String te){
	super(tc);
	this.typeEnergie=te;	
    }

    public String getTypeEnergie(){
	return typeEnergie;
    }

    public void setTypeEnergie(String te){
	this.typeEnergie=te;
    }

    public String toString(){
	return super.toString()+", Type d'energie : "+typeEnergie;
    }
}

