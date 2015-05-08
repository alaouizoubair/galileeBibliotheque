package com.galilee.adherent.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.galilee.adherent.dao.AdherentDao;
import com.galilee.adherent.model.Adherent;
import com.galilee.emprunt.bo.EmpruntBo;
import com.galilee.emprunt.dao.EmpruntDao;
import com.galilee.emprunt.model.Emprunt;
import com.galilee.livre.bo.LivreBo;
import com.galilee.livre.model.Livre;

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
		ApplicationContext appContext = new ClassPathXmlApplicationContext
				("spring/config/BeanLocations.xml");
		
		List listAdherent = getHibernateTemplate().find
				("from Adherent where adherentId = "+adherentId);
		
		EmpruntBo empruntBo = (EmpruntBo)appContext.getBean("empruntBo");
		List listEmprunt = empruntBo.findByEmpruntAdherentId(adherentId);
		
		
		LivreBo livreBo = (LivreBo)appContext.getBean("livreBo");
		List<Livre> listLivre = new ArrayList<Livre>();;
		for(int i=0;i<listEmprunt.size();i++){
			Emprunt emprunt = (Emprunt)listEmprunt.get(i);
			listLivre.add(livreBo.findByLivreId((Long)emprunt.getEmpruntLivreId()));
		}
		
		
		Adherent adherent = (Adherent)listAdherent.get(0);
		adherent.setAdherentEmprunt(listEmprunt);
		adherent.setAdherentLivre(listLivre);
		return adherent;
	}
	
	public List<Adherent> findByAdherentNbrEmprunt(Long adherentNbrEmprunt){
		List listAdherent = getHibernateTemplate().find
				("from Adherent where adherentNbrEmprunt = "+adherentNbrEmprunt);
		return (List<Adherent>)listAdherent;
	}
	
	public List<Adherent> findAll(){
		List listAdherent = getHibernateTemplate().find
				("from Adherent ");
		return (List<Adherent>)listAdherent;
	}
	
	
}







