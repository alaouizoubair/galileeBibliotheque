package com.galilee.adherent.dao;

import java.util.List;

import com.galilee.adherent.model.Adherent;

public interface AdherentDao  {
	void save(Adherent adherent);
	void update(Adherent adherent);
	void delete(Adherent adherent);
	
	Adherent findByAdherentId(Long adherentId);
	Adherent findByAdherentName(String adherentNom,String adherentPrenom);
	List<Adherent>  findByAdherentNbrEmprunt(Long adherentNbrEmprunt);
	List<Adherent> findAll();
}
