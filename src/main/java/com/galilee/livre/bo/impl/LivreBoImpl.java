package com.galilee.livre.bo.impl;

import com.galilee.livre.bo.LivreBo;
import com.galilee.livre.dao.LivreDao;
import com.galilee.livre.model.Livre;

public class LivreBoImpl implements LivreBo{
	LivreDao livreDao;
	
	public void setLivreDao(LivreDao livreDao){
		this.livreDao=livreDao;
	}
	
	public void save(Livre livre){
		livreDao.save(livre);
	}
	
	public void update(Livre livre){
		livreDao.update(livre);
	}
	
	public void delete(Livre livre){
		livreDao.delete(livre);
	}
	
	public Livre findByLivreTitre(String livreTitre){
		return livreDao.findByLivreTitre(livreTitre);
	}
}
