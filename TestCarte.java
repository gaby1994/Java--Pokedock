import java.io.*;

public class TestCarte implements Serializable{
    public static void main(String[] args){
	Deck d=new Deck();
        CarteEnergie c1=new CarteEnergie("Energie","Electrique");
        d.ajouterCarte(c1);
	CarteDresseur c2=new CarteDresseur("Dresseur","Objet","XY Rupture Turbo","106/122","Potion","Soignez 30 degats a l'un de vos pokemon","Vous pouvez jouer autant de cartes Objet que vous le voulez pendant votre tour (avant votre attaque)");
	d.ajouterCarte(c2);
	Talent t3=new Talent("","");
	CartePokemon c3=new CartePokemon("Pokemon","Psy","XY Rupture Turbo","50/122","Soporifik","Si vous pensez avoir reve mais que vous ne vous souvenez pas, c'est que Soporifick a tout mange",0,"",70,"Psy","Psy x2","","",2,t3);
	Attaque a3_1=new Attaque("Murmure","","Psy",1,0,10);
	c3.ajouterAttaque(a3_1);
	Attaque a3_2=new Attaque("Voeu Fervent","Lancez une piece. Si c'est face, cette attaque inflige 20 degats supplementaires","Psy",0,2,10);
	c3.ajouterAttaque(a3_2);
        d.ajouterCarte(c3);
	System.out.println(d);
	System.out.println("\nApres melange\n");
	d.melange();
	System.out.println(d);
	System.out.println("\nEcriture\n");
	d.ecritureFichier();
	System.out.println("\nLecture\n");
	d.lectureFichier();
	d.rechercherCarte();
    }
}
