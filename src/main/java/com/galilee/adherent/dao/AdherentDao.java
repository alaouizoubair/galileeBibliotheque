package com.galilee.adherent.dao;

import com.galilee.adherent.model.Adherent;

public interface AdherentDao  {
	void save(Adherent adherent);
	void update(Adherent adherent);
	void delete(Adherent adherent);
	
	Adherent findByAdherentId(Long adherentId);
}
