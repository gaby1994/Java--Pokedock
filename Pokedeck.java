import java.util.*;

public class Pokedeck{
    public static void main(String [] args) throws Exception {
	//Creation du deck
	Deck d=new Deck();
	int reponse;
	//Gestion de la saisie au clavier
	Scanner sc=new Scanner(System.in);

	d.sauvegarderRestaurer();

	//affichage du menu
	do{
	    System.out.println("Entrez un nombre compris entre 1 et 8");
	    System.out.println("Pour ajouter une carte, tapez 1");	    
	    System.out.println("Pour lire le fichier, tapez 2");
	    System.out.println("Pour retirer une carte, tapez 3");
	    System.out.println("Pour modifier une carte, tapez 4");
	    System.out.println("Pour rechercher une carte, tapez 5");
	    System.out.println("Pour creer un nouveau deck, tapez 6");
	    System.out.println("Pour vider le deck, tapez 7");
	    System.out.println("Pour sortir, tapez 8");
	    reponse=sc.nextInt();
	    switch(reponse) {
	    case 1:
		d.ajouterCarteInteractive();		
		System.out.println("\n Affichage du deck \n");
		System.out.println(d);
		break;
	    case 2:
		d.lectureFichier();
		break;	   
	    case 3:
		int numeroRetire=-1;
		do{
		    System.out.println("Le numero saisi doit correspondre a un indice de la liste");
		    numeroRetire=sc.nextInt();
		}while(numeroRetire<0 && numeroRetire>(d.taille()-1));
		d.retirerCarte(numeroRetire);
		System.out.println(d);
		break;
	    case 4:
		int numeroModifie=-1;
		do{
		    System.out.println("Le numero saisi doit correspondre a un indice de la liste");
		    numeroModifie=sc.nextInt();
		}while(numeroModifie<0 && numeroModifie>(d.taille()-1));		    
       
		d.modifierCarte(numeroModifie);
		System.out.println(d);		    		    
		break;
	    case 5:
		d.rechercherCarte();
		break;
	    case 6 :
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
		    System.out.println("Vous devez entrer un nombre compris entre 1 et 6");
		    switch(reponse2){
	      		 
		    case 1 :
			d2.ajouterCarteInteractive();
			System.out.println(d);
			break;
		    case 2:
			d2.lectureFichier();
			break;
		    case 3:
			int numeroRetire2;
			do{
			    System.out.println("Saisissez un numero d'indice");
			    numeroRetire2=sc.nextInt();
			}while(numeroRetire2<0 && numeroRetire2>(d.taille()-1));
			d2.retirerCarte(numeroRetire2);
			System.out.println(d);
			break;
		    case 4:
			int numeroModifie2;
			do{
			    System.out.println("Saisissez un numero d'indice");
			    numeroModifie2=sc.nextInt();
			}while(numeroModifie2<0 && numeroModifie2>(d.taille()-1));		    
       
			d2.modifierCarte(numeroModifie2);
			System.out.println(d);		    		    
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
		break;
	    case 7:
		System.out.println("Sortie");
		System.exit(0);
		break;
	    default:
		System.out.println("Vous devez entrer un nombre compris entre 1 et 7");
	    }	
	}while(reponse != 7);
    }
}

