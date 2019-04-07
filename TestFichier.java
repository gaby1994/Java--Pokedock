public class TestFichier{
    public static void main(String[]args){
	Deck d=new Deck();
		Talent t1=new Talent(" "," ");
	Attaque a1_1=new Attaque("Coud Phalange","Psy",0,30,2," ");
	Attaque a1_2=new Attaque("Electro Frappe","Psy",2,90,1," ");
	CartePokemon c1=new CartePokemon("Electrique","XY Rupture Turbo JCC","43/122","Elekable","Il place le bout de ses deux queues sur son ennemi et libère une décharge de 20 000 V",1,"Elektek",110,"Combat","Combat x 2"," "," ",3,t1);
	c1.ajouterAttaque(a1_1);
	c1.ajouterAttaque(a1_2);
	d.ajouterCarte(c1);
	Talent t2=new Talent("Barricade Bide","Tant que ce Pokemon est votre Pokemon Actif, chaque Pokemon en jeu dans la defausse de chaque joueur ne possede pas de Capacites.");
	Attaque a2_1=new Attaque("Choc Mental","Psy",1,20,2,"Lancez une piece. Si c’est face, le Pokemon actif de votre adversaire est maintenant Paralyse.");
	Attaque a2_2=new Attaque("Lame Zen","Psy",2,100,2,"Ce Pokémon ne peut pas utiliser Lame Zen pendant votre prochain tour.");
	CartePokemon c2=new CartePokemon("Psy","Promo JCC","XY101","Mewtwo","Un Pokemon concu en reorganisant les genes de Mew. On raconte qu’il s’agit du Pokemon le plus feroce.",0," ",120,"Psy","Psy x 2"," "," ",2,t2);
	c2.ajouterAttaque(a2_1);
	c2.ajouterAttaque(a2_2);
	d.ajouterCarte(c2);
       	Talent t3=new Talent(" "," ");
	Attaque a3=new Attaque("Assaut psychique","Psy",1,10,1,"Cette attaque inflige 10 degats supplementaires pour chaque marqueur des Pokemon actifs de votre adversaire.");
	CartePokemon c3=new CartePokemon("Psy","XY Vigueur Spectrale","36/119","Wobbuffet","Il déteste la lumière et le choc. Si attaque, il gonfle son corps pour construire sa contre-attaque",0," ",110,"Psy","Psy x 2"," "," ",2,t3);
	c3.ajouterAttaque(a3);
	d.ajouterCarte(c3);
	Talent t4=new Talent(" "," ");
	Attaque a4_1=new Attaque("Morsure","Psy",0,20,1,"Crocs Eclair");
	Attaque a4_2=new Attaque("Crocs Eclair","Psy",1,30,1,"Lancez une pièce. Si c’est face, le Pokémon actif de votre adversaire est maintenant Paralysé");
	CartePokemon c4=new CartePokemon("Electrique","XY Rupture Turbo JCC","45/122","Luxio","Le courant qui circule a la pointe de ses griffes est capable de faire perdre connaissance a ses proies.",1,"Lixy",80,"Combat","Combat x 2","Metal","Metal – 20",1,t4);
	c4.ajouterAttaque(a4_1);
	c4.ajouterAttaque(a4_2);
	d.ajouterCarte(c4);
	Talent t5=new Talent("Rune protectrice","Prevenez tous les effets d'attaques, dégats inclus, infligés à Qulbutoke par les Pokémon-ex de votre adversaire");
	Attaque a5=new Attaque("Faire ressort","Psy",1,50,2,"Qulbutoké s’inflige 10 dégats. Vous ne pouvez pas appliquer la Faiblesse et la Resistance à ces degats");
	CartePokemon c5=new CartePokemon("Psy","EX Gardiens du Pouvoir JCC","24/108","Qulbutoke"," ",0," ",80,"Psy","Psy x1"," "," ",2,t5);
	c5.ajouterAttaque(a5);
	d.ajouterCarte(c5);

	System.out.println("Deck rempli : ");
	System.out.println(d);
	//System.out.println("cpt quand deck rempli : "+d.getCpt());
	d.sauvegardeFichier(d);
	//d.viderDeck();
	//System.out.println("cpt quand deck vide : "+d.getCpt());

	//Deck d=new Deck();
	//System.out.println("cpt avant restauration : "+d.getCpt());
	  d.restaureFichier(d);
	  //System.out.println("cpt apres restauration : "+d.getCpt());
	  

        
    }
}
