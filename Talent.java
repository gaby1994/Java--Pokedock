import java.util.*;
import java.io.*;

public class Talent implements Serializable{
    private String nomTalent;
    private String descriptionTalent;

    public Talent(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Entrez le nom du talent");
	this.nomTalent=sc.nextLine();
	System.out.println("Entrez la description du talent");
	this.descriptionTalent=sc.nextLine();
    }
    
    public Talent(String nt,String dt){
	this.nomTalent=nt;
	this.descriptionTalent=dt;
    }
    
    public String getNomTalent(){
	return nomTalent;
    }

    public void setNomTalent(String nt){
	this.nomTalent=nt;
    }

    public String getDescriptionTalent(){
	return descriptionTalent;
    }

    public void setDescriptionTalent(String dt){
	this.descriptionTalent=dt;
    }

    public String toString(){
	return "nom Talent : "+nomTalent+" description : "+descriptionTalent;
    }
}
