import java.util.*;
import java.io.*;
import java.math.*;

public class CartePokemon extends Carte implements Serializable{
    private String typePokemon;
    private String extensionCarte;
    private String numeroCarte;
    private String nomPokemon;
    private String description;
    private int niveauPokemon; // Niveau de base -> niveauPokemon = 0
    private String nomEvolution;
    private int pvPokemon;
    private String typeFaiblessePokemon;
    private String valeurFaiblessePokemon;
    private String typeResistancePokemon;
    private String valeurResistancePokemon;
    private int pointRetraite;
    private Attaque attaque[];
    private Talent talent;
    private int nbAttaques;
 

    public CartePokemon(String tc){
	super(tc);
	Scanner sc = new Scanner(System.in);
	int saisie;
	this.typePokemon="indefini";
	do{
	    System.out.println("Tapez le type de Pokemon souhaite : ");
	    System.out.println("Pour un pokemon de type Plante, tapez 1");
	    System.out.println("Pour un pokemon de type Feu, tapez 2");
	    System.out.println("Pour un pokemon de type Eau, tapez 3");
	    System.out.println("Pour un pokemon de type Electrique, tapez 4");
	    System.out.println("Pour un pokemon de type Psy, tapez 5");
	    System.out.println("Pour un pokemon de type Combat, tapez 6");
	    System.out.println("Pour un pokemon de type Obscurite, tapez 7");
	    System.out.println("Pour un pokemon de type Metal, tapez 8");
	    System.out.println("Pour un pokemon de type Fee, tapez 9");
	    System.out.println("Pour un pokemon de type Dragon, tapez 10");
	    System.out.println("Pour un pokemon de type Incolore, tapez 11");
	    saisie = sc.nextInt();
	    switch(saisie){
	    case 1:
		this.typePokemon="Plante";
		break;
	    case 2:
	        this.typePokemon="Feu";
		break;
	    case 3:
		this.typePokemon="Eau";
		break;
	    case 4:
		this.typePokemon="Electrique";
		break;
	    case 5:
		this.typePokemon="Psy";
		break;
	    case 6:
		this.typePokemon="Combat";
		break;
	    case 7:
		this.typePokemon="Obscurite";
		break;
	    case 8:
		this.typePokemon="Metal";
		break;
	    case 9:
		this.typePokemon="Fee";
		break;
	    case 10:
		this.typePokemon="Dragon";
		break;
	    case 11:
		this.typePokemon="Incolore";
		break;	
	    default :
		System.out.println("Vous devez tapez un nombre compris entre 1 et 11");
	    }
	}while(typePokemon=="indefini");
	sc.nextLine();
	System.out.println("Entrez le nom de l'extension de la carte");
        this.extensionCarte=sc.nextLine();
        System.out.println("Entrez le numero de la carte");
	this.numeroCarte=sc.nextLine();
	System.out.println("Entrez le nom du pokemon");
        this.nomPokemon=sc.nextLine();
	System.out.println("Entrez la description du pokemon");
        this.description=sc.nextLine();
	System.out.println("Entrez le niveau du pokemon");
        this.niveauPokemon=sc.nextInt();
	sc.nextLine();
	System.out.println("Entrez le nom de l'evolution de la Carte");
	this.nomEvolution=sc.nextLine();
	System.out.println("Entrez le pv du Pokemon");
	this.pvPokemon=sc.nextInt();
	sc.nextLine();
	System.out.println("Entrez le type de la Faiblesse du Pokemon");
	this.typeFaiblessePokemon=sc.nextLine();
	System.out.println("Entrez la valeur de la Faiblesse du Pokemon");
	this.valeurFaiblessePokemon=sc.nextLine();
	System.out.println("Entrez le type de la Resistance du Pokemon");
	this.typeResistancePokemon=sc.nextLine();
	System.out.println("Entrez la valeur de la Resistance du Pokemon");
	this.valeurResistancePokemon=sc.nextLine();
	System.out.println("Entrez la valeur du point de retraite du Pokemon");
	this.pointRetraite=sc.nextInt();    
	System.out.println("Entrez les attaques");
	this.attaque=new Attaque[3];
	Attaque a1=new Attaque();	
	nbAttaques=0;
	attaque[nbAttaques]=a1;
	nbAttaques++;
	int saisieAttaque;
	System.out.println("Voulez-vous une deuxième attaque, si oui tapez 1");
	saisieAttaque=sc.nextInt();
	if(saisieAttaque==1){
	    Attaque a2=new Attaque();
	    attaque[nbAttaques]=a2;
	    nbAttaques++;
	}
	System.out.println("Voulez-vous une troisieme attaque, si oui tapez 1");
	saisieAttaque=sc.nextInt();
	if(saisieAttaque==1){
	    Attaque a3=new Attaque();
	    attaque[nbAttaques]=a3;
	    nbAttaques++;
	}
	talent=new Talent();
    }

    //classe testee dans une classe de test
    public CartePokemon(String tc,String tp,String ec,String nc,String noP,String d,int niP,String ne,int pvP,String tfp,String vfp,String trp,String vrp,int pr,Talent t){
	super(tc);
	this.typePokemon=tp;
	this.extensionCarte=ec;
	this.numeroCarte=nc;
        this.nomPokemon=noP;
	this.description=d;
	this.niveauPokemon=niP;
	this.nomEvolution=ne;
        this.pvPokemon=pvP;
	this.typeFaiblessePokemon=tfp;
	this.valeurFaiblessePokemon=vfp;
	this.typeResistancePokemon=trp;
	this.valeurResistancePokemon=vrp;
	this.pointRetraite=pr;
	this.talent=t;
	this.attaque=new Attaque[3];
	this.nbAttaques=0;
	}

    public String getTypePokemon(){
	return typePokemon;
    }

    public void setTypePokemon(String tp){
	this.typePokemon=tp;
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
    
    public String getNomPokemon(){
	return nomPokemon;
    }

    public void setNomPokemon(String noP){
	this.nomPokemon=noP;
    }

    public String getDescription(){
	return description;
    }

    public void setDescription(String d){
	this.description=d;
    }

    public int getNiveauPokemon(){
	return niveauPokemon;
    }

    public void setNiveauPokemon(int niP){
	this.niveauPokemon=niP;
    }

    public String getNomEvoultuon(){
	return this.nomEvolution;	
    }

    public void setNomEvolution(String ne){
	this.nomEvolution=ne;
    }

    public int getPvPokemon(){
	return pvPokemon;
    }

    public void setPvPokemon(int pvP){
	this.pvPokemon=pvP;
    }

    public String getTypeFaiblessePokemon(){
	return this.typeFaiblessePokemon;
    }

    public void setTypeFaiblessePokemon(String tfp){
	this.typeFaiblessePokemon=tfp;
    }

    public String getValeurFaiblessePokemon(){
	return this.valeurFaiblessePokemon;
    }

    public void setValeurFaiblessePokemon(String vfp){
	this.valeurFaiblessePokemon=vfp;
    }

    public String getTypeResistancePokemon(){
	return this.typeResistancePokemon;
    }

    public void setTypeResistancePokemon(String trp){
	this.typeResistancePokemon=trp;
    }

    public String getValeurResistancePokemon(){
	return this.valeurResistancePokemon;
    }

    public void setValeurResistancePokemon(String vrp){
	this.valeurResistancePokemon=vrp;
    }

    public int getPointRetraite(){
	return this.pointRetraite;
    }

    public void setPointRetraite(int pr){
	this.pointRetraite=pr;
    }
    
    public Talent getTalent(){
    return talent;
    }
    
    public void setTalent(Talent t){
    this.talent=t;
    }

    //ajout d'une attaque dans le tableau attaque
    public void ajouterAttaque(Attaque a){
	if(nbAttaques<3){
	    attaque[nbAttaques]=a;
	    nbAttaques++;
	}
    }

    public String toString(){
        String s=super.toString()+"      type de Pokemon : "+this.typePokemon+"\n"+
	    "      extension de la Carte : "+this.extensionCarte+"\n"+
	    "      numero de la Carte : "+this.numeroCarte+"\n"+
	    "      nom du Pokemon : "+this.nomPokemon+"\n"+
	    "      description : "+this.description+"\n"+
	    "      niveau du Pokemon : "+this.niveauPokemon+"\n"+
	    "      nom de l'evolution : "+this.nomEvolution+"\n"+
	    "      pv du Pokemon : "+this.pvPokemon+"\n"+
	    "      type de faiblesse : "+this.typeFaiblessePokemon+"\n"+
	    "      valeur de la faiblesse : "+this.valeurFaiblessePokemon+"\n"+
	    "      type de resistance : "+this.typeResistancePokemon+"\n"+
	    "      valeur de la resistance : "+this.valeurResistancePokemon+"\n"+
	    "      point de retraite : "+this.pointRetraite+"\n"+
	    "      talent : "+talent.toString()+"\n";
	String attaques="      ";
	
	attaques="      (";/*+attaque[0];*/
	for(int i=0;i<nbAttaques;i++){
	    if(attaque[i]!=null){
		attaques=attaques+",\n       "+attaque[i];
	    }
	}
	//attaques=attaques+"      "+attaque[attaque.length-1]+")";
	s=s+attaques+")";
	return s;
    }
    
}
    

					
