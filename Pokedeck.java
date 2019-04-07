import java.util.*;
/*
public class Pokedeck{
    public static void main(String [] args) throws Exception {
	//Creation du deck
	Deck d1=new Deck();
	int reponse1;
	//Gestion de la saisie au clavier
	Scanner sc=new Scanner(System.in);
	int lecture;

	//initialisation du fichier de depart
	d1.fichierDepart();

	//on demande a l'utilisateur s'il veut utiliser le fichier de depart
	System.out.println("Voulez vous restaurer le fichier"+d1.getNomFichier()+"?");
	System.out.println("Si c'est le cas, tapez 1");
	lecture=sc.nextInt();	   

	//affichage du menu
	if(lecture==1){
	    d1.lectureFichier();
	    do{
		System.out.println("Entrez un nombre compris entre 1 et 7");
		System.out.println("Pour ajouter une carte dans le deck, tapez 1");	    
		System.out.println("Pour lire le fichier, tapez 2");
		System.out.println("Pour retirer une carte du deck, tapez 3");
		System.out.println("Pour modifier une carte dans le deck, tapez 4");
		System.out.println("Pour rechercher une carte dans le deck, tapez 5");
		System.out.println("Pour vider le deck, tapez 6");
		System.out.println("Pour sortir, tapez 7");
		reponse1=sc.nextInt();
		switch(reponse1) {
		case 1:
		    d1.ajouterCarteInteractive();		
		    System.out.println("\n Affichage du deck \n");
		    System.out.println(d1);
		    break;
		case 2:
		    d1.lectureFichier();
		    break;	   
		case 3:
		    int numeroRetire=-1;
		    do{
			System.out.println("Le numero saisi doit correspondre a un indice de la liste");
			numeroRetire=sc.nextInt();
		    }while(numeroRetire<0 && numeroRetire>(d1.taille()-1));
		    d1.retirerCarte(numeroRetire);
		    System.out.println(d1);
		    break;
		case 4:
		    int numeroModifie=-1;
		    do{
			System.out.println("Le numero saisi doit correspondre a un indice de la liste");
			numeroModifie=sc.nextInt();
		    }while(numeroModifie<0 && numeroModifie>(d1.taille()-1));		    
       
		    d1.modifierCarte(numeroModifie);
		    System.out.println(d1);		    		    
		    break;
		case 5:
		    d1.rechercherCarte();
		    break;
		case 6:
		    d1.viderDeck();
		    break;
		case 7:
		    System.out.println("Sortie");
		    System.exit(0);
		    break;
		default:
		    System.out.println("Vous devez entrer un nombre compris entre 1 et 7");
		}	
	    }while(reponse1 != 7);
	    d1.fermetureFichier();
	}else{
	    //création d'un deuxieme deck
	    Deck d2=new Deck();
	    int reponse2;
	    do{
		System.out.println("Entrez un nombre compris entre 1 et 6");
		System.out.println("Pour ajouter une carte, tapez 1");
		System.out.println("Pour lire le fichier, tapez 2");
		System.out.println("Pour retirer une carte, tapez 3");
		System.out.println("Pour modifier une carte, tapez 4");
		System.out.println("Pour rechercher une carte, tapez 5");
		System.out.println("Pour vider le deck, tapez 6");
		System.out.println("Pour sortir, tapez 7");
		reponse2=sc.nextInt();
		System.out.println("Vous devez entrer un nombre compris entre 1 et 7");
		switch(reponse2){
	      		 
		case 1 :
		    d2.ajouterCarteInteractive();
		    System.out.println(d2);
		    break;
		case 2:
		    d2.lectureFichier();
		    break;
		case 3:
		    int numeroRetire2;
		    do{
			System.out.println("Saisissez un numero d'indice");
			numeroRetire2=sc.nextInt();
		    }while(numeroRetire2<0 && numeroRetire2>(d2.taille()-1));
		    d2.retirerCarte(numeroRetire2);
		    System.out.println(d2);
		    break;
		case 4:
		    int numeroModifie2;
		    do{
			System.out.println("Saisissez un numero d'indice");
			numeroModifie2=sc.nextInt();
		    }while(numeroModifie2<0 && numeroModifie2>(d2.taille()-1));		    
       
		    d2.modifierCarte(numeroModifie2);
		    System.out.println(d2);		    		    
		    break;
		case 5:
		    d2.rechercherCarte();
		    break;
		case 6 :
		    d2.viderDeck();
		    break;
		case 7 :
		    System.out.println("Sortie");
		    System.exit(0);
		    break;
		}
	    }while(reponse2 != 7);
	    d2.fermetureFichier();
	}
    }
}

*/

public class Pokedeck{
    public static void main(String[] args){
	Deck d1=new Deck();
	Scanner sc=new Scanner(System.in);
	int reponse;
	do{
	    System.out.println("\nMenu : Tapez le numero correspondant a votre choix : \n");
	    System.out.println(" 1  - restaurer un deck a partir d'un fichier de sauvegarde");
	    System.out.println(" 2  - ajouter une carte au deck");
	    System.out.println(" 3  - rechercher une carte a partir de plusieurs critères");
	    System.out.println(" 4  - afficher une carte");
	    System.out.println(" 5  - modifier une carte");
	    System.out.println(" 6  - afficher le deck complet");
	    System.out.println(" 7  - melanger les cartes du deck");
	    System.out.println(" 8  - retirer une carte du deck");
	    System.out.println(" 9  - sauvegarder le deck dans un fichier de sauvegarde");
	    System.out.println(" 10 - sortir\n");
	    reponse=sc.nextInt();
	    switch(reponse){
	    case 1:
		d1.restaureFichier(d1);
		break;
	    case 2:
		d1.ajouterCarteInteractive();
		break;
	    case 3:
		d1.rechercherCarte();
		break;
	    case 4:
		int indiceRecherche;
     
		do{
		    indiceRecherche=sc.nextInt();
		}while(indiceRecherche <0 && indiceRecherche >d1.taille()-1);

		System.out.println(d1.getCarte(indiceRecherche));
		break;
	    case 5:       	
		int indiceModifie;	       
		do{
		    indiceModifie=sc.nextInt();
		}while(indiceModifie <0 && indiceModifie >d1.taille()-1);
		d1.modifierCarte(indiceModifie);
		break;
	    case 6:
		System.out.println(d1);
		break;
	    case 7:
		d1.melange();
		break;
	    case 8:      
		d1.retirerCarte();
		break;
	    case 9:
		d1.sauvegardeFichier(d1);
		break;
	    case 10:
		System.out.println("Sortie");
		System.exit(0);
		break;
	    default :
		System.out.println("Entrez un nombre entre 1 et 10");
		break;
	    }
		
	}while(reponse!=10);
    }
}
