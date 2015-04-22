package com.galilee.livre.bo;

import com.galilee.livre.model.Livre;

public interface LivreBo {
	void save(Livre livre);
	void update(Livre livre);
	void delete(Livre livre);
	
	Livre findByLivreTitre(String livreTitre);
}
