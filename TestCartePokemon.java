public class TestCartePokemon{
    public static void main(String[]args){
	CartePokemon cp;
	String tp="Eau";
	String ec="XY Offensive Vapeur JCC";
	String nc="27/114";
	String noP="Demanta";
	String d="Il ignore royalement les Rémoraid qui s'accrochent à ces nageoires pour manger les restes qu'il sème.";
	int niP=0;
	String ne=" ";
	int pv=100;
	String tf="Electrique";
	String vf="Electrique x2";
	String tr="Combat";
	String vr="Combat - 20";
	int pr=1;
	Talent t=new Talent(" "," ");
	cp=new CartePokemon("Pokemon",tp,ec,nc,noP,d,niP,ne,pv,tf,vf,tr,vr,pr,t);
	Attaque a1=new Attaque("Vague de soin","Eau",1,0,0,"Défaussez autant de cartes que vous voulez de votre main. Soignez 10 dégats à ce Pokémon pour chaque carte défaussée de cette façon.");
	Attaque a2=new Attaque("Vague faiblissante","Eau",3,90,0,"Cette attaque inflige 90 dégats moins pour chaque marqueur de dégats placé sur ce Pokémon.");     
	cp.ajouterAttaque(a1);
	cp.ajouterAttaque(a2);

	System.out.println(cp);



	//Test de modificateurs


	/*cp.setTypePokemon("Electrique");
	cp.setExtensionCarte("XY Rupture Turbo JCC");
	cp.setNumeroCarte("49/122");
	cp.setNomPokemon("Zeblitz");
	cp.setDescription("Il réagit à la vitesse de l’éclair. Lorsqu’il est en plein galop, on peut entendre le grondement de tonnerre.");
	cp.setNiveauPokemon(1);
	cp.setNomEvolution("Zebibron");
	cp.setPvPokemon(100);
	cp.setTypeFaiblessePokemon("Combat");
	cp.setValeurFaiblessePokemon("Combat x2");
	cp.setTypeResistancePokemon("Metal");
	cp.setValeurResistancePokemon("Metal - 20");
	cp.setPointRetraite(1);
	t.setNomTalent("Zone Electrique");
	t.setDescriptionTalent("Les dégats des attaques de vos Pokémon Electrique ne sont affectés par aucun effet en action sur le Pokemon Actif de votre adversaire.");
	a1.setNomAttaque("Eclair Fracassant");
	a1.setTypeAttaque(" ");
	a1.setNbEnergies(0);
	a1.setNbDegatsAttaque(50);
	a1.setNbIncolore(2);
	a1.setDescriptionAttaque("Si le Pokémon actif de votre adversaire a une Résistance à Combat, cette attaque infilge 60 dégats supplémentaires");
	a2.setNomAttaque("");
	a2.setTypeAttaque("");
	a2.setNbEnergies(0);
	a2.setNbDegatsAttaque(0);
	a2.setNbIncolore(0);
	a2.setDescriptionAttaque("");
	System.out.println(a2.getNbIncolore());*/
	
    }
}
