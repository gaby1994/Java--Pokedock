import java.util.*;
import java.io.*;
import java.math.*;

public class Deck implements Serializable{
    private ArrayList<Carte> d;
    private int cpt;
    private final int TAILLE=60;
  
    //initialisation du scanner
    Scanner sc=new Scanner(System.in);
    
    //creation du deck
    public Deck(){
	d=new ArrayList<Carte>();
	cpt=0;
    }
    
    //ajout d'une carte dans le Deck, tant qu'on ne depasse pas 60 cartes
    //en entree : une classe Carte
    //en sortie : rien
    public void ajouterCarte(Carte c){
	if(d.size()<TAILLE){	
	d.add(c);
	cpt++;
	c.setNumeroCarteDeck(cpt);
	}	
    }

    //suppression de la carte en haut de la pile du Deck
    //en entree : rien
    //en sortie : rien
    public void retirerCarte(){
	d.remove(d.get(d.size()-1));
	cpt--;
    }

    //acces a une carte dans le Deck : methode utilisee pour balayer le deck dans la fonction sauvegarde
    //en entree : un int i representant l'indice de la carte dans le deck (indice de l'arrayList)
    //en sortie : la carte d'indice i
    public Carte getCarte(int i){
	return d.get(i);
    }

    //recherche d'une carte dans le Deck sur plusieurs criteres dependant du type de Carte
    //Carte energie : un seul critere possible (type)
    //Carte dresseur : deux criteres possibles (nom du dresseur ou numero de la Carte)
    //Carte pokemon : deux criteres possibles (nom du pokemon ou numero de la Carte)
    //en entree : rien
    //en sortie : une liste avec les numeros de cartes dans le deck correspondant aux cartes recherchees
    public void rechercherCarte(){
	int saisie;
	String te,nd,np,nc,td,tp;
	//initialisation du scanner
	Scanner sc = new Scanner(System.in);
	//arrayList d'entiers pour stocker les numeros de carte trouvees , correspondantes aux criteres de recherche
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

	//Choix des criteres de recherche
	if(saisie == 1){
	    System.out.println("Entrez le type d'energie recherche");
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
		System.out.println("Entrez le nom du dresseur recherche");
		td=sc.nextLine();
		System.out.println("Entrez le numero de carte recherche");
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
	    System.out.println("Voici les numeros des cartes dans le deck correspondant aux criteres recherches : ");
	    for(int i=0;i<res.size();i++){
		System.out.println(res.get(i));
	    }
	}else{
	    System.out.println("Aucune carte ne correspond aux criteres recherches");
	}
    }

    //taille de la liste : methode utilisee pour fournir la taille de la liste de carte contenue dans l'objet "deck" a la methode sauvegarde
    //entree : rien
    //sortie : int
    public int taille(){
	return d.size();
    }

    //ajout d'une carte interactive : selection du type de carte puis appel a la fonction ajouterCarte
    //entree : rien
    //sortie : rien
    public void ajouterCarteInteractive(){
	int typeSouhaite;
	Scanner sc=new Scanner(System.in);

	System.out.println("Quel type de carte voulez-vous ?");
	System.out.println("Pour une Carte Dresseur, tapez 1");
	System.out.println("Pour une Carte Energie, tapez 2");
	System.out.println("Pour une Carte Pokemon, tapez 3");

	do{
	    System.out.println("Vous devez entrer un 1, un 2 ou un 3");
	    typeSouhaite=sc.nextInt();
	}while(typeSouhaite <1 && typeSouhaite >3);

	if(typeSouhaite==1){
	    CarteDresseur c=new CarteDresseur("Dresseur");
	    ajouterCarte(c);
	    //ecritureFichier(c);
	}else{
	    if(typeSouhaite==2){
		CarteEnergie c=new CarteEnergie("Energie");
		ajouterCarte(c);
		//ecritureFichier(c);	    
	    }else{
		CartePokemon c=new CartePokemon("Pokemon");
		ajouterCarte(c);
		//ecritureFichier(c);
	    }
	}
    }
	

    //melange du deck : une fois le deck rempli, il faut melanger les cartes de maniere a ce que la "pioche" se fasse au hasard
    //entree : rien
    //sortie : rien
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

    //modifcation d'une carte : on remplace la carte d'indice i par une nouvelle carte qu'on cree de maniere interactive 
    //donc, en choisissant de nouvelles valeurs pour les attributs
    //dans cette methode, on peut changer la valeur d'un des attributs mais pas le type de carte
    //entree : un int nc representant le numero de carte dans le deck
    //sortie : deck avec carte modifiee
    public void modifierCarte(int nc){
	int i=0;
	//on cherche l'indice de la carte correspondant au numero de carte dans le deck passe en parametre
	while(nc!=getCarte(i).getNumeroCarteDeck() || i<d.size()){
	    i++;
	}
	if(i==d.size()){
	    System.out.println("La carte de numero "+nc+" n'est pas presente dans le deck");
	}else{	
	    if(getCarte(i).getTypeCarte()=="Dresseur"){
		CarteDresseur c=new CarteDresseur("Dresseur");
		d.set(i,c);
	    }else{
		if(getCarte(i).getTypeCarte()=="Energie"){
		    CarteEnergie c=new CarteEnergie("Energie");
		    d.set(i,c);
		}else{
		    CartePokemon c=new CartePokemon("Pokemon");
		    d.set(i,c);
		}
	    }       
	}
    }

    
    //vidage du deck
    //entree : rien
    //sortie : rien
    public void viderDeck(){
	int nbElem=taille();
	while(nbElem!=0){
	    d.remove(nbElem-1);
	    nbElem--;
	}
	cpt=0;
	System.out.println("deck vide");
    }

  
    //ecriture dans le fichier : sauvegarde du deck dans un fichier dont on saisit le nom au clavier
    //entree : Deck deck
    //sortie : fichier avec le deck rempli
    public void sauvegardeFichier(Deck deck){
	String nf;
	System.out.println("Entrez le nom de fichier de sauvegarde");
	nf=sc.nextLine();
	try {
	    // serialisation : ecriture de l'objet dans le flux de sortie
	    FileOutputStream f=new FileOutputStream(nf);
	    ObjectOutputStream oos= new ObjectOutputStream(f);
	    try{
		for(int i=0;i<deck.taille();i++){
		    oos.writeObject(deck.getCarte(i)); 
		    // on vide le tampon
		    oos.flush();	    
		    //System.out.println(deck.getCarte(i) + " a ete serialise");
		}
	    }finally{
		try{
		    oos.close();
		}finally{
		    f.close();
		}
	    }
	}
	catch(IOException ioe) {
	    ioe.printStackTrace();		  
	} 
    }

    //restauration du fichier : restaure le contenu du fichier dont le nom est saisi au clavier dans un deck vide passe en parametre
    //entree : Deck
    //sortie : Deck avec le contenu du fichier dont 
    public void restaureFichier(Deck deck){	
        String nf;
	Carte c;
	boolean eof = false;
	
	deck.viderDeck();
	System.out.println("Entrez le nom de fichier a restaurer");
	nf=sc.nextLine();
	try{
	    FileInputStream f=new FileInputStream(nf);
	    ObjectInputStream ois= new ObjectInputStream(f);
	    while(!eof){
		try{
		    c=(Carte) ois.readObject();
		    deck.ajouterCarte(c);		    
	        }catch(ClassNotFoundException e){
		    eof=true;

		}catch(IOException e){
		    eof=true;
		}
	    }	    	    
	}catch(FileNotFoundException e){
	    eof=true;
	}catch(EOFException e){
	    eof=true;
	}catch(IOException e){
	    eof=true;
	}
    }

 
    public String toString(){
	String s="";

	for(int i=0;i<d.size()-1;i++){
	    s=s+d.get(i)+"\n\n";
	}
	s=s+d.get(d.size()-1);
	return s;
    }
    
}

