package com.galilee.livre.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.galilee.livre.dao.LivreDao;
import com.galilee.livre.model.Livre;

public class LivreDaoImpl extends HibernateDaoSupport implements LivreDao{
	public void save(Livre livre){
		getHibernateTemplate().save(livre);
	}
	
	public void update(Livre livre){
		getHibernateTemplate().update(livre);
	}

	public void delete(Livre livre){
		getHibernateTemplate().delete(livre);
	}
	
	public Livre findByLivreTitre(String livreTitre){
		List list = getHibernateTemplate().find
				("from Livre where livreTitre='" + livreTitre+"'" );
		
		return (Livre)list.get(0);
	}
}
