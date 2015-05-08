package com.galilee.adherent.bo;

import java.util.List;

import com.galilee.adherent.model.Adherent;

public interface AdherentBo {
	void save(Adherent adherent);
	void update(Adherent adherent);
	void delete(Adherent adherent);
	
	Adherent findByAdherentId(Long adherentId);
	List<Adherent>  findByAdherentNbrEmprunt(Long adherentNbrEmprunt);
	List<Adherent> findAll();
}
