package com.galilee.bibliotheque;




import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.galilee.adherent.bo.AdherentBo;
import com.galilee.adherent.model.Adherent;
import com.galilee.emprunt.bo.EmpruntBo;
import com.galilee.emprunt.model.Emprunt;
import com.galilee.livre.bo.LivreBo;
import com.galilee.livre.model.Livre;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext
        		("spring/config/BeanLocations.xml");
        
        AdherentBo adherentBo = (AdherentBo)appContext.getBean("adherentBo");
        LivreBo livreBo = (LivreBo)appContext.getBean("livreBo");
        EmpruntBo empruntBo = (EmpruntBo)appContext.getBean("empruntBo");
        
        
        /** Insert Livre **/
		Date d = new Date(15,04,21);
        Long emAd= new Long("1");
        Long emLi= new Long("5");
        Emprunt emprunt = new Emprunt(emAd,emLi,d);
        
        try{
        	empruntBo.save(emprunt);
        }catch(DataIntegrityViolationException e){
        	System.out.println("Constraint Not respected");
        }
        
        /** Select Emprunt **/
        Emprunt emprunt2 = empruntBo.findByEmpruntId(new Long("1"));
        System.out.println(emprunt2.getEmpruntAdherentId()+"/"+emprunt2.getEmpruntLivreId());
        
        /** Insert Livre **/
        /*Livre livre = new Livre("Unlimited Power","Tony Robins","001ROM",10,10);
        
        try{
        	livreBo.save(livre);
        }catch(DataIntegrityViolationException e){
        	System.out.println("Constraint Not respected");
        }*/
        
        /** Select Livre **/
        /*Livre livre2 = livreBo.findByLivreTitre("Unlimited Power");
        System.out.println(livre2.getLivreAuteur()+"/"+livre2.getLivreCode());*/
        
        /** Insert Adherent**/
       /* Adherent adherent = new Adherent("Alaoui","Zoubair","93700","zoubair@alaoui.in","étudiant",0);
        try{
        	adherentBo.save(adherent);
		}catch(DataIntegrityViolationException e){
			System.out.println("Constraint not respected. Error ");
		}catch(Exception e){
			System.out.println("Could not Save. Error "+e);
		}
        */
        /** Select Adherent **/
       /* Adherent adherent2 = adherentBo.findByAdherentId((long)1);
        System.out.println(adherent2.getAdherentNom()+"/"+adherent2.getAdherentNbrEmprunt());*/

    }
}
