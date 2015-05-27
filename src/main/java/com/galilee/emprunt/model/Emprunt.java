package com.galilee.emprunt.model;

import java.io.Serializable;
import java.sql.Date;

import com.galilee.adherent.model.Adherent;

public class Emprunt implements Serializable{
	private static final long serialVersionId = 1L;
	
	private Long empruntId;
	private Long empruntAdherentId;
	private Long empruntLivreId;
	private Date empruntRetour;
	private int empruntReturned;
	
	public Emprunt(){}

	public Emprunt(Long empruntAdherentId, Long empruntLivreId,
			Date empruntRetour) {
		super();
		this.empruntAdherentId = empruntAdherentId;
		this.empruntLivreId = empruntLivreId;
		this.empruntRetour = empruntRetour;
	}

	public Long getEmpruntId() {
		return empruntId;
	}

	public void setEmpruntId(Long empruntId) {
		this.empruntId = empruntId;
	}

	public Long getEmpruntAdherentId() {
		return empruntAdherentId;
	}

	public void setEmpruntAdherentId(Long empruntAdherentId) {
		this.empruntAdherentId = empruntAdherentId;
	}

	public Long getEmpruntLivreId() {
		return empruntLivreId;
	}

	public void setEmpruntLivreId(Long empruntLivreId) {
		this.empruntLivreId = empruntLivreId;
	}

	public Date getEmpruntRetour() {
		return empruntRetour;
	}

	public void setEmpruntRetour(Date empruntRetour) {
		this.empruntRetour = empruntRetour;
	}
	
	public int getEmpruntReturned() {
		return empruntReturned;
	}

	public void setEmpruntReturned(int empruntReturned) {
		this.empruntReturned = empruntReturned;
	}

	public String toString(){
		String str = "Id: "+empruntId+"\nAdherent: "+empruntAdherentId+"\nLivre: "+
				empruntLivreId+"\nDate Retour: "+empruntRetour+"\n";
		return str;
	}
	
}
