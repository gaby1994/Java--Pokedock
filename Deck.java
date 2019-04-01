import java.util.*;
import java.io.*;
import java.math.*;

public class Deck implements Serializable{
    private ArrayList<Carte> d;
    private int cpt;
    private final int TAILLE=60;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private String nomFichier;

    public Deck(){
	d=new ArrayList<Carte>();
	Scanner sc=new Scanner(System.in);
	System.out.println("Entrez le nom du fichier");
	nomFichier=sc.nextLine();
	cpt=0;
	// ouverture d'un flux de sortie vers le fichier "nomFichier"
	try{
	    fos = new FileOutputStream(nomFichier);
	    oos= new ObjectOutputStream(fos);
	} catch(IOException ioe) {
	    ioe.printStackTrace();
	}
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
	String te,nd,np,nc,td,tp;
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
	    System.out.println("Voici les numeros des cartes dans le deck correspondant aux critères recherchés : ");
	    for(int i=0;i<res.size();i++){
		System.out.println(res.get(i));
	    }
	}else{
	    System.out.println("Aucune carte ne correspond aux critères recherchés");
	}
    }

    //taille de la liste
    public int taille(){
	return d.size();
    }

    //ajout d'une carte interactive
    public void ajouterCarteInteractive(){
	System.out.println("Quel type de carte voulez-vous ?");
	System.out.println("Pour une Carte Dresseur, tapez 1");
	System.out.println("Pour une Carte Energie, tapez 2");
	System.out.println("Pour une Carte Pokemon, tapez 3");
	int typeSouhaite;
	Scanner sc=new Scanner(System.in);
	do{
	    System.out.println("Vous devez entrer un 1, un 2 ou un 3");
	    typeSouhaite=sc.nextInt();
	}while(typeSouhaite <1 && typeSouhaite >3);

	if(typeSouhaite==1){
	    CarteDresseur c=new CarteDresseur();
	    ajouterCarte(c);
	    ecritureFichier(c);
	}else{
	    if(typeSouhaite==2){
		CarteEnergie c=new CarteEnergie();
		ajouterCarte(c);
		ecritureFichier(c);	    
	    }else{
		CartePokemon c=new CartePokemon();
		ajouterCarte(c);
		ecritureFichier(c);
	    }
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

    //modifcation d'une carte
    public void modifierCarte(int i){
	if(getCarte(i).getTypeCarte()=="Dresseur"){
	    CarteDresseur c=new CarteDresseur();
	    d.set(i,c);
	}else{
	    if(getCarte(i).getTypeCarte()=="Energie"){
		CarteEnergie c=new CarteEnergie();
		d.set(i,c);
	    }else{
		CartePokemon c=new CartePokemon();
		d.set(i,c);
	    }
	}
        
    }

    //vidage du deck
    public void viderDeck(){
	int nbElem=taille();
	while(nbElem!=0){
	    retirerCarte(nbElem-1);
	    nbElem--;
	}
    }

    //ecriture dans le fichier
    public void ecritureFichier(Carte c){	    	   
	try {
	    // sérialisation : écriture de l'objet dans le flux de sortie
	    oos.writeObject(c); 
	    // on vide le tampon
	    oos.flush();
	    System.out.println(c + " a ete serialise");
	} catch(IOException ioe) {
	    ioe.printStackTrace();		  
	} 
    }

    //fermeture du fichier
    public void fermetureFichier(){
	try {
	    oos.close();	    
	}catch(IOException e){
	    e.printStackTrace();
	}
	finally {
	    try{
		fos.close();
	    }catch(IOException e){
		e.printStackTrace();
	    }
	}
    }

    //lecture du fichier
    public void lectureFichier(){
	Carte c;
	boolean eof = false;

	try{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier));
	    while(!eof){
		try{
		    c=(Carte) ois.readObject();      
		    System.out.println(c);				  
		}catch(EOFException e){
		    eof=true;
		}catch(ClassNotFoundException e){
		    eof=true;
		}		   
	    }
	}catch(FileNotFoundException e){
	    eof=true;
	}catch(IOException e){
	    eof=true;
	}
    }


    public void sauvegarderRestaurer(){
	Talent t1=new Talent(" "," ");
	Attaque a1_1=new Attaque("Coud Phalange","Psy",0,30,2," ");
	Attaque a1_2=new Attaque("Electro Frappe","Psy",2,90,1," ");
	CartePokemon c1=new CartePokemon("Pokemon","Electrique","XY Rupture Turbo JCC","43/122","Elekable","Il place le bout de ses deux queues sur son ennemi et libère une décharge de 20 000 V",1,"Elektek",110,"Combat","Combat x 2"," "," ",3,t1);
	c1.ajouterAttaque(a1_1);
	c1.ajouterAttaque(a1_2);
	ajouterCarte(c1);
	Talent t2=new Talent("Barricade Bide","Tant que ce Pokemon est votre Pokemon Actif, chaque Pokemon en jeu dans la defausse de chaque joueur ne possede pas de Capacites.");
	Attaque a2_1=new Attaque("Choc Mental","Psy",1,20,2,"Lancez une piece. Si c’est face, le Pokemon actif de votre adversaire est maintenant Paralyse.");
	Attaque a2_2=new Attaque("Lame Zen","Psy",2,100,2,"Ce Pokémon ne peut pas utiliser Lame Zen pendant votre prochain tour.");
	CartePokemon c2=new CartePokemon("Pokemon","Psy","Promo JCC","XY101","Mewtwo","Un Pokemon concu en reorganisant les genes de Mew. On raconte qu’il s’agit du Pokemon le plus feroce.",0," ",120,"Psy","Psy x 2"," "," ",2,t2);
	c2.ajouterAttaque(a2_1);
	c2.ajouterAttaque(a2_2);
	ajouterCarte(c2);
       	Talent t3=new Talent(" "," ");
	Attaque a3=new Attaque("Assaut psychique","Psy",1,10,1,"Cette attaque inflige 10 degats supplementaires pour chaque marqueur des Pokemon actifs de votre adversaire.");
	CartePokemon c3=new CartePokemon("Pokemon","Psy","XY Vigueur Spectrale","36/119","Wobbuffet","Il déteste la lumière et le choc. Si attaque, il gonfle son corps pour construire sa contre-attaque",0," ",110,"Psy","Psy x 2"," "," ",2,t3);
	c3.ajouterAttaque(a3);
	ajouterCarte(c3);
	Talent t4=new Talent(" "," ");
	Attaque a4_1=new Attaque("Morsure","Psy",0,20,1,"Crocs Eclair");
	Attaque a4_2=new Attaque("Crocs Eclair","Psy",1,30,1,"Lancez une pièce. Si c’est face, le Pokémon actif de votre adversaire est maintenant Paralysé");
	CartePokemon c4=new CartePokemon("Pokemon","Electrique","XY Rupture Turbo JCC","45/122","Luxio","Le courant qui circule a la pointe de ses griffes est capable de faire perdre connaissance a ses proies.",1,"Lixy",80,"Combat","Combat x 2","Metal","Metal – 20",1,t4);
	c4.ajouterAttaque(a4_1);
	c4.ajouterAttaque(a4_2);
	ajouterCarte(c4);
	Talent t5=new Talent("Rune protectrice","Prevenez tous les effets d'attaques, dégats inclus, infligés à Qulbutoke par les Pokémon-ex de votre adversaire");
	Attaque a5=new Attaque("Faire ressort","Psy",1,50,2,"Qulbutoké s’inflige 10 dégats. Vous ne pouvez pas appliquer la Faiblesse et la Resistance à ces degats");
	CartePokemon c5=new CartePokemon("Pokemon","Psy","EX Gardiens du Pouvoir JCC","24/108","Qulbutoke"," ",0," ",80,"Psy","Psy x1"," "," ",2,t5);
	c5.ajouterAttaque(a5);
	ajouterCarte(c5);

	System.out.println("Deck rempli : ");
	System.out.println(d);
	
	//sauvegarde du deck dans un fichier
	for(int i=0;i<taille();i++){
	    ecritureFichier(getCarte(i));
	}

	//vidage du deck
	viderDeck();
      
	//affichage du deck vide
	System.out.println();
	System.out.println("Deck vide : ");
	System.out.println(d);

	//restauration du deck
	System.out.println();
	System.out.println("Lecture fichier : ");
	lectureFichier();

	
    }

    public String getNomFichier(){
	return nomFichier;
    }

    public String toString(){
	String s="";

	for(int i=0;i<d.size();i++){
	    s=s+d.get(i)+"\n";
	}
	return s;
    }
    
}

