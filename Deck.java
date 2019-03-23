import java.util.*;
import java.io.*;
import java.math.*;

public class Deck implements Serializable{
    private ArrayList<Carte> d;
    private int cpt;
    private final int TAILLE=60;

    public Deck(){
	d=new ArrayList<Carte>();	
	cpt=0;
    }

    public void ajouterCarte(Carte c){
	if(d.size()<TAILLE){
	    cpt++;
	    c.setNumeroCarteDeck(cpt);
	    d.add(c);
	}
    }

    public void retirerCarte(int i){
	d.remove(i);
    }

    public Carte getCarte(int i){
	return d.get(i);
    }

    public void rechercherCarte(){
	int saisie;
	String te,nd,np,nc;
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> res=new ArrayList<Integer>();

	//Saisie du nombre determinant le type de Carte
	do{
	    System.out.println("Quel type de carte souhiatez-vous ?");
	    System.out.println("Pour une carte Energie, tapez 1");
	    System.out.println("Pour une carte Dresseur, tapez 2");
	    System.out.println("Pour une carte Pokemon, tapez 3");
	    saisie=sc.nextInt();
	}while(saisie<1 && saisie>3);

	sc.nextLine();

	//Choix des critères de recherche
	if(saisie == 1){
	    System.out.println("Entrez un type d'energie");
	    te=sc.nextLine();
	    for(int i=0;i<d.size();i++){
		if(d.get(i).getTypeCarte()=="Energie"){
		    CarteEnergie ce=(CarteEnergie)(getCarte(i));
		    if(ce.getTypeEnergie().compareTo(te)==0){
			res.add(ce.getNumeroCarteDeck());
		    }
		}
	    }
	}else{
	    if(saisie == 2){
		System.out.println("Entrez un nom de dresseur");
		td=sc.nextLine();
		System.out.println("Entrez un numero de carte");
		nc=sc.nextLine();
		for(int i=0;i<d.size();i++){
		    if(d.get(i).getTypeCarte()=="Dresseur"){
			CarteDresseur cd=(CarteDresseur)(getCarte(i));
			if((cd.getNomDresseur().compareTo(td)==0) || (cd.getNumeroCarte().compareTo(nc)==0)){
			    res.add(cd.getNumeroCarteDeck());
			}
		    }
		}
	    }
	    else{
		System.out.println("Entrez un nom de pokemon");
		tp=sc.nextLine();
		System.out.println("Entrez un numero de carte");
		nc=sc.nextLine();
		for(int i=0;i<d.size();i++){
		    if(d.get(i).getTypeCarte()=="Pokemon"){
			CartePokemon cp=(CartePokemon)(getCarte(i));
			if((cp.getNomPokemon().compareTo(tp)==0) || (cp.getNumeroCarte().compareTo(nc)==0)){
			    res.add(cp.getNumeroCarteDeck());
			}
		    }
		} 
	    }
	}
	
	if(res.size()>0){
	    System.out.println("Voici les numeros des cartes dans le deck correspondant aux critères recherchés : "):
	    for(int i=0;i<res.size();i++){
		System.out.println(res.get(i));
	    }
	}else{
	    System.out.println("Aucune carte ne correspond aux critères recherchés");
	}
    }

    //melande du deck
    public void melange(){
	Carte tmp=new Carte("");
	int r;

	for(int i=0;i<d.size();i++){
	    tmp=getCarte(i);
	    r=(int)(Math.random()*d.size());
	    d.set(i,getCarte(r));
	    d.set(r,tmp);
	}
	    
    }

    //ecriture dans le fichier
    public void ecritureFichier(){
	try {  
	    // ouverture d'un flux de sortie vers le fichier "deck.serial"
	    FileOutputStream fos = new FileOutputStream("deck.serial");

	    // création d'un "flux objet" avec le flux fichier
	    ObjectOutputStream oos= new ObjectOutputStream(fos);
	    try {
		// sérialisation : écriture de l'objet dans le flux de sortie
		for(int i=0;i<d.size();i++){
		    oos.writeObject(getCarte(i));
		}
		// on vide le tampon
		oos.flush();
		for(int i=0;i<d.size();i++){
		    System.out.println(getCarte(i) + " a ete serialise");
		}
	    } finally {
		//fermeture des flux
		try {
		    oos.close();
		} finally {
		    fos.close();
		}
	    }
	} catch(IOException ioe) {
	    ioe.printStackTrace();
	}
    }

    public void lectureFichier(){
	Carte c = null;
	try {
	    // ouverture d'un flux d'entrée depuis le fichier "deck.serial"
	    FileInputStream fis = new FileInputStream("deck.serial");
	    // création d'un "flux objet" avec le flux fichier
	    ObjectInputStream ois= new ObjectInputStream(fis);
	    try {	
		// désérialisation : lecture de l'objet depuis le flux d'entrée
		for(int i=0;i<d.size();i++){
		    c=getCarte(i);
		    c=(Carte)ois.readObject();
		}
	    } finally {
		// on ferme les flux
		try {
		    ois.close();
		} finally {
		    fis.close();
		}
	    }
	} catch(IOException ioe) {
	    ioe.printStackTrace();
	} catch(ClassNotFoundException cnfe) {
	    cnfe.printStackTrace();
	}
        
	for(int i=0;i<d.size();i++){
	    System.out.println(getCarte(i) + " a ete deserialise");
	}
	
    }

    public void interactionUtilisateur(Carte c){
	int saisie;
	do{
	    System.out.println("Que voulez-vous faire ?");
	    System.out.println("Si vous voulez ajouter une carte, tapez 1");
	    System.out.println("Si vous voulez modifier une carte, tapez 2");
	    System.out.println("Si vous voulez retirer une carte, tapez 3");
	    System.out.println("Si vous voulez rechercher une Carte selon des criteres tapez 4");
	    System.out.println("Si vous voulez ecrire dans un fichier, tapez 5");
	    System.out.println("Si vous voulez lire dans un fichier, tapez 6");
	    System.out.println("Si vous voulez rien faire, tapez 7");
	}while(saisie < 0 && saisie > 7);

	if(saisie == 1){
	    ajouterCarte(c);
	}else{
	    if(saisie == 2){	    
		c=new Carte();
	    }else{
		if(saisie == 3){
		    retirerCarte(c);
		}else{
		    if(saisie == 4){
			rechercherCarte();
		    }else{
			if(saisie == 5){
			    ecritureFichier();
			}else{
			    if(saisie == 6){
				lectureFichier();
			    }
			}
		    }
		}
	    }
	}
    }

    public String toString(){
	String s="";

	for(int i=0;i<d.size();i++){
	    s=s+d.get(i)+"\n";
	}
	return s;
    }
    
}

