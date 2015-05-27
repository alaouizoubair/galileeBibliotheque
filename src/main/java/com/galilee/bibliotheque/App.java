package com.galilee.bibliotheque;

import java.sql.Date;
import java.util.ArrayList;
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

public class App {
	private static ApplicationContext appContext = new ClassPathXmlApplicationContext(
			"spring/config/BeanLocations.xml");

	private static AdherentBo adherentBo = (AdherentBo) appContext
			.getBean("adherentBo");
	private static LivreBo livreBo = (LivreBo) appContext.getBean("livreBo");
	private static EmpruntBo empruntBo = (EmpruntBo) appContext
			.getBean("empruntBo");

	public static int affichage() {
		System.out.println("*------------------------------------*");
		System.out.println("* 1  : Ajouter Adhérent              *");
		System.out.println("* 2  : Ajouter Livre                 *");
		System.out.println("*------------------------------------*");
		System.out.println("* 3  : Réaliser un prêt              *");
		System.out.println("* 4  : Réaliser un retour            *");
		System.out.println("*------------------------------------*");
		System.out.println("* 5  : Rechercher Adhérent(id)       *");
		System.out.println("* 6  : Rechercher Livre              *");
		System.out.println("*------------------------------------*");
		System.out.println("* 7  : Afficher Liste Adhérent       *");
		System.out.println("* 8  : Afficher Liste Livre          *");
		System.out.println("* 9  : Afficher Liste Emprunt        *");
		System.out.println("*------------------------------------*");
		System.out.println("* 10  : More...                       *");
		System.out.println("*------------------------------------*");
		System.out.println("* 0  : Quit                          *");
		System.out.println("*------------------------------------*");

		Scanner scn = new Scanner(System.in);
		System.out.print("Choose action: ");
		return scn.nextInt();
	}

	public static void main(String[] args) {

		while (true) {
			switch (affichage()) {
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
				AfficherEmprunt();
				break;
			case 10:
				More();
				break;
			case 0:
				System.out.println("Good Bye");
				return;
			default:
				System.out.println("Can't Find option in menu");
				break;
			}

		}

	}

	public static void AjoutAdherent() {
		String nom, prenom, cp, mail, profession;
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

		Adherent adherent = new Adherent(nom, prenom, cp, mail, profession, 0);
		try {
			adherentBo.save(adherent);
			System.out.println("Adhérent Ajouté avec succée!\n");
		} catch (DataIntegrityViolationException e) {
			System.out.println("Contraint non respecter. Veuillez ressayer");
		} catch (Exception e) {
			System.out.println("Erreur lors de l'insertion. Veuillez ressayer");
		}
	}

	public static void AjoutLivre() {
		String titre, auteur, type, code;
		int nbrExemp, nbrDispo;
		Scanner scn = new Scanner(System.in);
		System.out.println("**Ajout Livre**");
		System.out.print("Titre: ");
		titre = scn.nextLine();
		System.out.print("Auteur: ");
		auteur = scn.nextLine();
		System.out.print("Type: ");
		type = scn.nextLine();
		if (type.equals("ROM"))
			code = "ROM" + CodeNumber(livreBo.findTypeAccurence(type) + 1);
		else if (type.equals("BDE"))
			code = "BDE" + CodeNumber(livreBo.findTypeAccurence(type) + 1);
		else {
			System.out.println("Type non accepté!");
			return;
		}
		System.out.print("Nombre Exemplaire: ");
		nbrExemp = scn.nextInt();
		nbrDispo = nbrExemp;

		Livre livre = new Livre(titre, auteur, type, code, nbrExemp, nbrDispo);

		try {
			livreBo.save(livre);
			System.out.println("Livre Ajouté avec succée!\n");
		} catch (DataIntegrityViolationException e) {
			System.out.println("Contraint non respecter. Veuillez ressayer");
		} catch (Exception e) {
			System.out.println("Erreur lors de l'insertion. Veuillez ressayer");
		}
	}

	public static String CodeNumber(int num) {
		if (num < 10)
			return ("00" + num);
		else if (num < 100)
			return "0" + num;
		else
			return "" + num;
	}

	public static void AfficherAdherent() {
		List<Adherent> adherents = adherentBo.findAll();
		for (int i = 0; i < adherents.size(); i++) {
			System.out.println(adherents.get(i).toString());
		}
	}

	public static void AfficherLivre() {
		List<Livre> livres = livreBo.findAll();
		for (int i = 0; i < livres.size(); i++) {
			System.out.println(livres.get(i).toString());
		}
	}

	public static void AfficherEmprunt() {
		List<Emprunt> emprunts = empruntBo.findAll();
		for (int i = 0; i < emprunts.size(); i++) {
			System.out.println(emprunts.get(i).toString());
		}
	}

	public static void RechercheAdherent() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Numero de l'adhérent: ");
		Long num = new Long(scn.nextInt());
		try {
		Adherent adherent = adherentBo.findByAdherentId(num);	

		List<Livre> livres = adherent.getAdherentLivre();
		System.out.println(adherent.toString());

		for (int i = 0; i < livres.size(); i++) {
			System.out.println(livres.get(i).toString2());
		}
		} catch (Exception e) {
			System.out.println("Aucun adhérent trouvé ou erreur dans la base de données");
		}
	}

	public static void RechercheLivre() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Titre du livre: ");
		String titre = scn.nextLine();
		try {
			Livre livre = livreBo.findByLivreTitre(titre);
			System.out.println(livre.toString());
		} catch (Exception e) {
			System.out
					.println("Aucun livre trouvé ou erreur dans la base de données");
		}
	}

	public static void RealiserEmprunt() {
		Scanner scn = new Scanner(System.in);

		System.out.print("Entrez le Numero de l'adhrent:  ");
		Long num = new Long(scn.nextInt());
		System.out.print("Entrez le Titre du livre:  ");
		String titre = scn.nextLine();
		titre = scn.nextLine();

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		sqlDate = addMonthToDate(sqlDate);
		try {
			Adherent adherent = adherentBo.findByAdherentId(num);
			Livre livre = livreBo.findByLivreTitre(titre);
			Emprunt emprunt = new Emprunt(adherent.getAdherentId(),livre.getLivreId(), sqlDate);
			
		if (adherent.getAdherentNbrEmprunt() < 3) {
			adherent.setAdherentNbrEmprunt(adherent.getAdherentNbrEmprunt() + 1);
			livre.setLivreNbrDispo(livre.getLivreNbrDispo() - 1);
			adherentBo.update(adherent);
			empruntBo.save(emprunt);
			livreBo.update(livre);
			System.out.println("Emprunt Réussi\n");

		} else {
			System.out.println("Vous avez atteint la limite des emprunt!\n");
		}		
		} catch (Exception e) {
			System.out.println("Aucun livre / adhérent ou emprunt trouvé ou erreur dans la base de données");
		}

	}

	public static Date addMonthToDate(Date sqlDate) {
		sqlDate.setYear(2015);
		if (sqlDate.getMonth() < 12) {
			if (sqlDate.getDate() == 31)
				sqlDate.setDate(30);
			sqlDate.setMonth(sqlDate.getMonth() + 1);
		} else {
			sqlDate.setMonth(1);
			sqlDate.setYear(sqlDate.getYear() + 1);
		}

		return sqlDate;
	}

	public static void RealiserRetour() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Entrez le Numero de l'adhrent:  ");
		Long num = new Long(scn.nextInt());
		System.out.print("Entrez l'identification du l'emprunt:  ");
		Long empruntId = new Long(scn.nextInt());
		try {
	
	
		Adherent adherent = adherentBo.findByAdherentId(num);
		Emprunt emprunt = empruntBo.findByEmpruntId(empruntId);
		Livre livre = livreBo.findByLivreId(emprunt.getEmpruntLivreId());
		if (emprunt.getEmpruntAdherentId().equals(adherent.getAdherentId())) {
			adherent.setAdherentNbrEmprunt(adherent.getAdherentNbrEmprunt() - 1);
			livre.setLivreNbrDispo(livre.getLivreNbrDispo() + 1);
			livreBo.update(livre);
			adherentBo.update(adherent);
			emprunt.setEmpruntReturned(1);
			empruntBo.update(emprunt);
			System.out.println("Retour réaliser avec succée.");
			// empruntBo.delete(emprunt);
		} else {
			System.out
					.println("Cette emprunt ne correspond pas à cette Adhérent.");
		}
		} catch (Exception e) {
			System.out.println("Aucun livre / adhérent ou emprunt trouvé ou erreur dans la base de données");
		}

	}

	public static void More() {
		System.out.println("*-------------------------------------------*");
		System.out.println("* 11 : Trouver l'auteur d'un livre          *");
		System.out.println("* 12 : Rechercher Adhérent ayant ce livre   *");
		System.out.println("* 13 : Adhérent ayant dépassé la date limite*");
		System.out.println("* 14 : Livre le plus emprunté               *");
		System.out.println("* 15 : Recherche Adherent par Nom           *");
		System.out.println("* 0  : Retour                               *");
		System.out.println("*-------------------------------------------*");

		Scanner scn = new Scanner(System.in);
		System.out.print("Choose action: ");
		switch (scn.nextInt()) {
		case 11:
			RechercheAuteurLivre();
			break;
		case 12:
			AdherentLivre();
			break;
		case 13:
			HorsDate();
			break;
		case 14:
			LivreActif();
			break;
		case 15:
			RechAdherentNom();
			break;
		}
	}

	public static void RechercheAuteurLivre() {
		String livreTitre;
		Scanner scn = new Scanner(System.in);
		System.out.print("Titre du Livre: ");
		livreTitre = scn.nextLine();
		try{
		Livre livre = livreBo.findByLivreTitre(livreTitre);
		System.out.println("L'auteur de " + livre.getLivreTitre() + " est "
				+ livre.getLivreAuteur());
		} catch (Exception e) {
			System.out.println("Aucun livre correspondant trouvé ou erreur dans la base de données");
		}
	}

	public static void AdherentLivre() {
		String livreTitre;
		Scanner scn = new Scanner(System.in);
		System.out.print("Titre du Livre: ");
		livreTitre = scn.nextLine();
		
		Livre livre = livreBo.findByLivreTitre(livreTitre);

		List<Emprunt> emprunt = empruntBo.findByEmpruntLivreId(livre
				.getLivreId());
		for(int i=0;i<emprunt.size();i++){
			Adherent adherent = adherentBo.findByAdherentId(emprunt.get(i).getEmpruntAdherentId());

			System.out.println("L'adhérent " + adherent.getAdherentNom() + " "
					+ adherent.getAdherentPrenom() + " possède le livre "
					+ livre.getLivreTitre());
		}
		

	}

	public static void HorsDate() {
		List<Emprunt> emprunt = empruntBo.findAll();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		for (int i = 0; i < emprunt.size(); i++) {
			if (emprunt.get(i).getEmpruntRetour().after(utilDate)) {
				Adherent adherent = adherentBo.findByAdherentId(emprunt.get(i)
						.getEmpruntAdherentId());
				System.out.println("L'adhérent " + adherent.getAdherentNom()
						+ " " + adherent.getAdherentPrenom());
			}
		}
	}

	public static void LivreActif() {
		List<Emprunt> emprunt = empruntBo.findAll();
		List<Long> livre = new ArrayList<Long>();
		// List<Integer> livrenbr = new ArrayList<Integer>();
		for (int i = 0; i < emprunt.size(); i++) {
			if (!livre.contains(emprunt.get(i).getEmpruntLivreId())) {
				livre.add(emprunt.get(i).getEmpruntLivreId());
			}

		}
		int[] livrenbr = new int[livre.size()];
		for (int i = 0; i < emprunt.size(); i++) {
			livrenbr[livre.indexOf(emprunt.get(i).getEmpruntLivreId())]++;
		}

		int max = 0, pos = 0;
		for (int i = 0; i < livre.size(); i++) {
			if (livrenbr[i] > max) {
				max = livrenbr[i];
				pos = i;
			}

		}

		Livre livreObj = livreBo.findByLivreId(livre.get(pos));
		System.out.println("Le livre le plus emprenté est "
				+ livreObj.getLivreTitre() + " x " + max);

	}
	public static void RechAdherentNom(){
		Scanner scn = new Scanner(System.in);
		System.out.print("Nom de l'adhérent: ");
		String nom = new String(scn.nextLine());
		System.out.print("Prenom de l'adhérent: ");
		String prenom = new String(scn.nextLine());
		try {
		Adherent adherent = adherentBo.findByAdherentName(nom,prenom);	

		List<Livre> livres = adherent.getAdherentLivre();
		System.out.println(adherent.toString());

		for (int i = 0; i < livres.size(); i++) {
			System.out.println(livres.get(i).toString2());
		}
		} catch (Exception e) {
			System.out.println("Aucun adhérent trouvé ou erreur dans la base de données");
		}
	}
}
