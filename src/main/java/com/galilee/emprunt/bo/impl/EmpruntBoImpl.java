package com.galilee.emprunt.bo.impl;

import com.galilee.emprunt.bo.EmpruntBo;
import com.galilee.emprunt.dao.EmpruntDao;
import com.galilee.emprunt.model.Emprunt;

public class EmpruntBoImpl implements EmpruntBo{
	
	EmpruntDao empruntDao;
	
	public void setEmpruntDao(EmpruntDao empruntDao){
		this.empruntDao = empruntDao;
	}
	
	public void save(Emprunt emprunt) {
		empruntDao.save(emprunt);
	}

	public void update(Emprunt emprunt) {
		empruntDao.update(emprunt);
	}

	public void delete(Emprunt emprunt) {
		empruntDao.delete(emprunt);
	}

	public Emprunt findByEmpruntId(Long empruntId) {
		return empruntDao.findByEmpruntId(empruntId);
	}
	
}
