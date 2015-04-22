package com.galilee.emprunt.dao;

import com.galilee.emprunt.model.Emprunt;

public interface EmpruntDao {
	void save(Emprunt emprunt);
	void update(Emprunt emprunt);
	void delete(Emprunt emprunt);
	
	Emprunt findByEmpruntId(Long empruntId);
}
