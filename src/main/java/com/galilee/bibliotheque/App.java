package com.galilee.bibliotheque;




import java.sql.Date;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.galilee.adherent.bo.AdherentBo;
import com.galilee.adherent.model.Adherent;
import com.galilee.emprunt.bo.EmpruntBo;
import com.galilee.emprunt.model.Emprunt;
import com.galilee.livre.bo.LivreBo;
import com.galilee.livre.model.Livre;


public class App 
{
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext
    		("spring/config/BeanLocations.xml");
    
	private static  AdherentBo adherentBo = (AdherentBo)appContext.getBean("adherentBo");
	private static LivreBo livreBo = (LivreBo)appContext.getBean("livreBo");
	private static EmpruntBo empruntBo = (EmpruntBo)appContext.getBean("empruntBo");
    
    
	public static int affichage(){
		System.out.println("*------------------------------------*");
		System.out.println("* 1  : Ajouter Adhérent              *");
		System.out.println("* 2  : Ajouter Livre                 *");
		System.out.println("*------------------------------------*");
		System.out.println("* 3  : Réaliser un prêt              *");
		System.out.println("* 4  : Réaliser un retour            *");
		System.out.println("*------------------------------------*");
		System.out.println("* 5  : Rechercher Adhérent           *");
		System.out.println("* 6  : Rechercher Livre              *");
		System.out.println("*------------------------------------*");
		System.out.println("* 7  : Afficher Liste Adhérent       *");
		System.out.println("* 8  : Afficher Liste Livre          *");
		System.out.println("*------------------------------------*");
		System.out.println("* 9  : More...                       *");
		System.out.println("*------------------------------------*");
		System.out.println("* 0  : Quit                          *");
		System.out.println("*------------------------------------*");
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Choose action: ");
		return scn.nextInt();
	}
	
    public static void main( String[] args )
    {
    	
    	while(true){
    		switch (affichage()){
    			case 1:
    				AjoutAdherent();
    			break;
    			case 2:
    				AjoutLivre();
    			break;
    			case 3:
    				RealiserEmprunt();
    			break;
    			case 4:
    				RealiserRetour();
    			break;
    			case 5:
    				RechercheAdherent();
    			break;
    			case 6:
    				RechercheLivre();
    			break;
    			case 7:
    				AfficherAdherent();
    			break;
    			case 8:
    				AfficherLivre();
    			break;
    			
    			case 9:
    				AfficherLivre();
    			break;
    			case 0:
    				System.out.println("Good Bye");
    			return;
			default:
    				System.out.println("Can't Find option in menu");
    			break;
    		}
    		
    	}
        
        
        /** Insert Emprunt**/
		/*Date d = new Date(115,04,21);
        Long emAd= new Long("1");
        Long emLi= new Long("5");
        Emprunt emprunt = new Emprunt(emAd,emLi,d);
        
        try{
        	empruntBo.save(emprunt);
        }catch(DataIntegrityViolationException e){
        	System.out.println("Constraint Not respected");
        }catch(Exception e){
        	System.out.println("EmpruntNot Saved");
        }*/
        
        /** Select Emprunt **/
        /*
        Emprunt emprunt2 = empruntBo.findByEmpruntId(new Long("1"));
        System.out.println(emprunt2.getEmpruntAdherentId()+"/"+emprunt2.getEmpruntLivreId()+"/"+emprunt2.getEmpruntRetour().toString());
        */
        
        /** Insert Livre **/
        /*Livre livre = new Livre("Unlimited Power","Tony Robins","001ROM",10,10);
        
        try{
        	livreBo.save(livre);
        }catch(DataIntegrityViolationException e){
        	System.out.println("Constraint Not respected");
        }*/
        
        /** Select Livre **/
        /*Livre livre2 = livreBo.findByLivreTitre("Unlimited Power");
        System.out.println(livre2.getLivreAuteur()+"/"+livre2.getLivreCode());*/
        
        /** Insert Adherent**/
        /*Adherent adherent = new Adherent("Alaoui","Zoubair","93700","zoubair@alaoui.in","étudiant",0);
        try{
        	adherentBo.save(adherent);
		}catch(DataIntegrityViolationException e){
			System.out.println("Constraint not respected. Error ");
		}catch(Exception e){
			System.out.println("Could not Save. Error "+e);
		}*/
        
        /** Select Adherent **/
        /*Adherent adherent2 = adherentBo.findByAdherentId((long)1);
        System.out.println(adherent2.getAdherentNom()+"/"+adherent2.getAdherentNbrEmprunt());
        System.out.println("Nombre Emprunt: "+adherent2.getAdherentLivre().size());*/
        
    }
    
    public static void AjoutAdherent(){
    	String nom,prenom,cp,mail,profession;
    	Scanner scn = new Scanner(System.in);
    	System.out.println("**Ajout Adhérent**");
    	System.out.print("Nom:");
    	nom = scn.nextLine();
    	System.out.print("Prenom:");
    	prenom = scn.nextLine();
    	System.out.print("Code postal:");
    	cp = scn.nextLine();
    	System.out.print("Mail:");
    	mail = scn.nextLine();
    	System.out.print("Profession:");
    	profession = scn.nextLine();
    	
    	Adherent adherent = new Adherent(nom,prenom,cp,mail,profession,0);
    	try{
        	adherentBo.save(adherent);
        	System.out.println("Adhérent Ajouté avec succée!\n");
		}catch(DataIntegrityViolationException e){
			System.out.println("Contraint non respecter. Veuillez ressayer");
		}catch(Exception e){
			System.out.println("Erreur lors de l'insertion. Veuillez ressayer");
		}
    }
    
    public static void AjoutLivre(){
    	String titre,auteur,code;
    	int nbrExemp,nbrDispo;
    	Scanner scn = new Scanner(System.in);
    	System.out.println("**Ajout Livre**");
    	System.out.print("Titre: ");
    	titre = scn.nextLine();
    	System.out.print("Auteur: ");
    	auteur = scn.nextLine();
    	System.out.print("Code: ");
    	code = scn.nextLine();
    	System.out.print("Nombre Exemplaire: ");
    	nbrExemp = scn.nextInt();
    	System.out.print("Nombre Disponible: ");
    	nbrDispo = scn.nextInt();
    	
    	Livre livre = new Livre(titre,auteur,code,nbrExemp,nbrDispo);
        
        try{
        	livreBo.save(livre);
        	System.out.println("Livre Ajouté avec succée!\n");
        }catch(DataIntegrityViolationException e){
			System.out.println("Contraint non respecter. Veuillez ressayer");
		}catch(Exception e){
			System.out.println("Erreur lors de l'insertion. Veuillez ressayer");
		}
    }
    
    public static void AfficherAdherent(){
    	List<Adherent> adherents = adherentBo.findAll();
        for(int i=0;i<adherents.size();i++){
        	System.out.println(adherents.get(i).toString());
        }
    }
    
    public static void AfficherLivre(){
    	List<Livre> livres = livreBo.findAll();
    	for(int i=0;i<livres.size();i++){
        	System.out.println(livres.get(i).toString());
        }
    }
    
    public static void RechercheAdherent(){
    	Scanner scn = new Scanner(System.in);
    	System.out.print("Numero de l'adhérent: ");
    	Long num = new Long(scn.nextInt());
    	
    	Adherent adherent = adherentBo.findByAdherentId(num);
    	List<Livre> livres = adherent.getAdherentLivre();
        System.out.println(adherent.toString());
        
        for(int i=0;i<livres.size();i++){
        	System.out.println(livres.get(i).toString2());
        }
        
    }
    
    public static void RechercheLivre(){
    	Scanner scn = new Scanner(System.in);
    	System.out.print("Titre du livre: ");
    	String titre = scn.nextLine();
    	
    	Livre livre = livreBo.findByLivreTitre(titre);
    	System.out.println(livre.toString());
    }
    
    public static void RealiserEmprunt(){
    	Scanner scn = new Scanner(System.in);
    	
    	System.out.print("Entrez le Numero de l'adhrent:  ");
    	Long num = new Long(scn.nextInt());
    	System.out.print("Entrez le Titre du livre:  ");
    	String titre = scn.nextLine();
    	
    	java.util.Date utilDate = new java.util.Date(); 
    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    	
    	Adherent adherent = adherentBo.findByAdherentId(num);
    	Livre livre = livreBo.findByLivreTitre(titre);
    	Emprunt emprunt = new Emprunt(adherent.getAdherentId(),livre.getLivreId(),sqlDate);
    	
    	if(adherent.getAdherentNbrEmprunt()==3){
    		adherent.setAdherentNbrEmprunt(adherent.getAdherentNbrEmprunt()+1);
    		adherentBo.update(adherent);
    		empruntBo.save(emprunt);
    	}else{
    		System.out.println("Vous avez atteint la limite des emprunt!\n");
    	}
    }
    
    public static void RealiserRetour(){
    	Scanner scn = new Scanner(System.in);
    	System.out.print("Entrez le Numero de l'adhrent:  ");
    	Long num = new Long(scn.nextInt());
    	System.out.print("Entrez l'identification du l'emprunt:  ");
    	Long empruntId = new Long(scn.nextInt());
    	
    	Adherent adherent = adherentBo.findByAdherentId(num);
    	Emprunt emprunt = empruntBo.findByEmpruntId(empruntId);
    	
    	adherent.setAdherentNbrEmprunt(adherent.getAdherentNbrEmprunt()-1);
    	adherentBo.update(adherent);
    	empruntBo.delete(emprunt);
    }
    
    public static int More(){
    	System.out.println("*------------------------------------*");
		System.out.println("* 11 : Trouver l'auteur d'un livre   *");
		System.out.println("* 12 : Adhérent ayant un livre       *");
		System.out.println("* 13 : Adhérent hors date            *");
		System.out.println("* 14 : Afficher livre par thème      *");
		System.out.println("* 15 : Livre le plus emprunté        *");
		System.out.println("* 16 : Adhérent le plus actif        *");
		/*System.out.println("*------------------------------------*");
		System.out.println("* 7  : Afficher Liste Adhérent       *");
		System.out.println("* 8  : Afficher Liste Livre          *");
		System.out.println("*------------------------------------*");
		System.out.println("* 9  : More...                       *");
		System.out.println("*------------------------------------*");*/
		System.out.println("* 0  : Retour                        *");
		System.out.println("*------------------------------------*");
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Choose action: ");
		return scn.nextInt();
    }
}
















