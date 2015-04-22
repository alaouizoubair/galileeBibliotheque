package com.galilee.adherent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.galilee.adherent.dao.AdherentDao;
import com.galilee.adherent.model.Adherent;

public class AdherentDaoImpl extends HibernateDaoSupport implements AdherentDao{
	public void save(Adherent adherent){
		getHibernateTemplate().save(adherent);
	}
	
	public void update(Adherent adherent){
		getHibernateTemplate().update(adherent);
	}
	
	public void delete(Adherent adherent){
		getHibernateTemplate().delete(adherent);
	}
	
	public Adherent findByAdherentId(Long adherentId){
		List list = getHibernateTemplate().find
				("from Adherent where adherentId = "+adherentId);
		
		return (Adherent)list.get(0);
	}
}
