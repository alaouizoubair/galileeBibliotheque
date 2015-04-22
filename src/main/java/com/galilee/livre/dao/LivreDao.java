package com.galilee.livre.dao;

import com.galilee.livre.model.Livre;

public interface LivreDao {
	void save(Livre livre);
	void update(Livre livre);
	void delete(Livre livre);
	
	Livre findByLivreTitre(String livreTitre);
}
