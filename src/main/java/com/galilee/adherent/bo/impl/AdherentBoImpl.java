package com.galilee.adherent.bo.impl;

import java.util.List;

import com.galilee.adherent.bo.AdherentBo;
import com.galilee.adherent.dao.AdherentDao;
import com.galilee.adherent.model.Adherent;

public class AdherentBoImpl implements AdherentBo{
	
	AdherentDao adherentDao;
	
	public void setAdherentDao(AdherentDao adherentDao){
		this.adherentDao = adherentDao;
	}
	
	public void save(Adherent adherent){
		adherentDao.save(adherent);
	}
	
	public void update(Adherent adherent){
		adherentDao.update(adherent);
	}
	public void delete(Adherent adherent){
		adherentDao.delete(adherent);
	}
	
	public Adherent findByAdherentId(Long adherentId){
		return adherentDao.findByAdherentId(adherentId);
	}
	
	public List<Adherent>  findByAdherentNbrEmprunt(Long adherentNbrEmprunt){
		return adherentDao.findByAdherentNbrEmprunt(adherentNbrEmprunt);
	}
	
	public List<Adherent> findAll(){
		return adherentDao.findAll();
	}
}
