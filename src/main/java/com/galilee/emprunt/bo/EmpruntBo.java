package com.galilee.emprunt.bo;

import java.util.List;

import com.galilee.emprunt.model.Emprunt;

public interface EmpruntBo {
	void save(Emprunt emprunt);
	void update(Emprunt emprunt);
	void delete(Emprunt emprunt);
	
	Emprunt findByEmpruntId(Long empruntId);
	List<Emprunt> findByEmpruntAdherentId(Long adherentId);
}
