import java.util.*;

public class Carte{
    private String typeCarte;
    
    public Carte(){
        Scanner sc = new Scanner(System.in);
	int saisie;
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

    public Carte(String tc){
	this.typeCarte=tc;
    }

    public String getTypeCarte(){
	return typeCarte;
    }

    public void setTypeCarte(String tc){
	typeCarte=tc;
    }

    public String toString(){
	return "Type de Carte : "+typeCarte;
    }
}
