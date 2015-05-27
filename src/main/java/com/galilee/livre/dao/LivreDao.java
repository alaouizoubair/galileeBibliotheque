package com.galilee.livre.dao;

import java.util.List;

import com.galilee.livre.model.Livre;

public interface LivreDao {
	void save(Livre livre);
	void update(Livre livre);
	void delete(Livre livre);
	
	Livre findByLivreId(Long livreId);
	Livre findByLivreTitre(String livreTitre);
	List<Livre> findAll();
	int findTypeAccurence(String Type);
}
