package com.galilee.livre.bo;

import java.util.List;

import com.galilee.livre.model.Livre;

public interface LivreBo {
	void save(Livre livre);
	void update(Livre livre);
	void delete(Livre livre);
	
	Livre findByLivreId(Long livreId);
	Livre findByLivreTitre(String livreTitre);
	List<Livre> findAll();
}
