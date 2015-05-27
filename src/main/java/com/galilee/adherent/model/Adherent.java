package com.galilee.adherent.model;

import java.io.Serializable;
import java.util.List;

import com.galilee.emprunt.model.Emprunt;
import com.galilee.livre.model.Livre;

public class Adherent implements Serializable{
	private static final long serialVersionId = 1L;
	
	private Long adherentId;
	private String adherentNom;
	private String adherentPrenom;
	private String adherentAdressePostal;
	private String adherentAdresseMail;
	private String adherentProfession;
	private int adherentNbrEmprunt;
	private List<Livre> adherentLivre;
	private List<Emprunt> adherentEmprunt;
	
	
	public Adherent(){}
	
	public Adherent(String adherentNom, String adherentPrenom,String adherentAdressePostal,
			String adherentAdresseMail,String adherentProfession,int adherentNbrEmprunt){
		this.adherentNom=adherentNom;
		this.adherentPrenom=adherentPrenom;
		this.adherentAdressePostal=adherentAdressePostal;
		this.adherentAdresseMail=adherentAdresseMail;
		this.adherentProfession=adherentProfession;
		this.adherentNbrEmprunt=adherentNbrEmprunt;
	}
	
	public Long getAdherentId() {
		return adherentId;
	}
	public void setAdherentId(Long adherentId) {
		this.adherentId = adherentId;
	}
	public String getAdherentNom() {
		return adherentNom;
	}
	public void setAdherentNom(String adherentNom) {
		this.adherentNom = adherentNom;
	}
	public String getAdherentPrenom() {
		return adherentPrenom;
	}
	public void setAdherentPrenom(String adherentPrenom) {
		this.adherentPrenom = adherentPrenom;
	}
	public String getAdherentAdressePostal() {
		return adherentAdressePostal;
	}
	public void setAdherentAdressePostal(String adherentAdressePostal) {
		this.adherentAdressePostal = adherentAdressePostal;
	}
	public String getAdherentAdresseMail() {
		return adherentAdresseMail;
	}
	public void setAdherentAdresseMail(String adherentAdresseMail) {
		this.adherentAdresseMail = adherentAdresseMail;
	}
	public String getAdherentProfession() {
		return adherentProfession;
	}
	public void setAdherentProfession(String adherentProfession) {
		this.adherentProfession = adherentProfession;
	}
	public int getAdherentNbrEmprunt() {
		return adherentNbrEmprunt;
	}
	public void setAdherentNbrEmprunt(int adherentNbrEmprunt) {
		this.adherentNbrEmprunt = adherentNbrEmprunt;
	}

	public List<Emprunt> getAdherentEmprunt() {
		return adherentEmprunt;
	}

	public void setAdherentEmprunt(List<Emprunt> adherentEmprunt) {
		this.adherentEmprunt = adherentEmprunt;
	}

	public List<Livre> getAdherentLivre() {
		return adherentLivre;
	}

	public void setAdherentLivre(List<Livre> adherentLivre) {
		this.adherentLivre = adherentLivre;
	}
	
	public String toString(){
		String str = "Id: "+adherentId+"\nNom: "+adherentNom+"\nPrenom: "+
				adherentPrenom+"\nCode Postal: "+adherentAdressePostal+
				"\nMail: "+adherentAdresseMail+"\nProfession: "+
				adherentProfession+"\nNombre d'emprunt: "+adherentNbrEmprunt+"\n";
		return str;
	}
	
}
