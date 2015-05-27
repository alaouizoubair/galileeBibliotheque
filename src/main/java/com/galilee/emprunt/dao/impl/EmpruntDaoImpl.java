package com.galilee.emprunt.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.galilee.emprunt.dao.EmpruntDao;
import com.galilee.emprunt.model.Emprunt;

public class EmpruntDaoImpl extends HibernateDaoSupport implements EmpruntDao{
	public void save(Emprunt emprunt){
		getHibernateTemplate().save(emprunt);
	}
	
	public void update(Emprunt emprunt){
		getHibernateTemplate().update(emprunt);
	}
	
	public void delete(Emprunt emprunt){
		getHibernateTemplate().delete(emprunt);
	}
	
	public List<Emprunt> findAll(){
		List list = getHibernateTemplate().find
				("from Emprunt ");
		
		return (List<Emprunt>)list;
	}
	
	public Emprunt findByEmpruntId(Long empruntId){
		List list = getHibernateTemplate().find
				("from Emprunt where empruntId="+empruntId);
		
		return (Emprunt)list.get(0);
	}
	
	public List<Emprunt> findByEmpruntAdherentId(Long adherentId){
		List list = getHibernateTemplate().find
				("from Emprunt where empruntAdherentId="+adherentId);
		
		return (List<Emprunt>)list;
	}
	
	public List<Emprunt> findByEmpruntLivreId(Long livreId){
		List list = getHibernateTemplate().find
				("from Emprunt where empruntLivreId="+livreId);
		
		return (List<Emprunt>)list;
	}

}
