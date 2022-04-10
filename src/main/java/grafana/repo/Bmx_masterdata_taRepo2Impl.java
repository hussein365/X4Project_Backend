package grafana.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import grafana.entity.Bmx_masterdata_ta;
@Repository
public class Bmx_masterdata_taRepo2Impl implements Bmx_masterdata_taRepo2 {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Bmx_masterdata_ta> filterbyTa_typundta(String ta_typ, String ta) {
	
       Session currentSession = entityManager.unwrap(Session.class);
       List<Bmx_masterdata_ta>result=new ArrayList<Bmx_masterdata_ta>();
       if(ta_typ.isEmpty()) {
    	   String[] tas=ta.split(",");
    	   for(String s:tas) {
    	   Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta data where data.ta=:ta",Bmx_masterdata_ta.class);
    	   theQuery.setParameter("ta", Integer.parseInt(s));
    	   for(Bmx_masterdata_ta data:theQuery.getResultList()) {
    		   result.add(data);
    	   }
    	   theQuery=null;
       }
       } 
    	   if(ta.isEmpty()) {
    	   String[]ta_typs=ta_typ.split(",");
    	   for(String s:ta_typs) {
    	   Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta data where data.ta_typ.id=:ta_typ",Bmx_masterdata_ta.class);
    	   theQuery.setParameter("ta_typ", Integer.parseInt(s));
    	   for(Bmx_masterdata_ta data:theQuery.getResultList()) {
    		   result.add(data);
    	   }
    	   }
    	   }
		
      
		if(!ta_typ.isEmpty()&&!ta.isEmpty()) {
			String[]ta_typs=ta_typ.split(",");
	    	   for(String s:ta_typs) {
	    		   for(String y:ta.split(",")) {
	    		   Query<Bmx_masterdata_ta> theQuery =
	    					currentSession.createQuery("from Bmx_masterdata_ta data where data.ta_typ.id=:ta_typ and data.ta=:ta", Bmx_masterdata_ta.class);
	    		   theQuery.setParameter("ta_typ", Integer.parseInt(s));
	    		   theQuery.setParameter("ta", Integer.parseInt(y));
	    		   
	    	   for(Bmx_masterdata_ta data:theQuery.getResultList()) {
	    		   result.add(data);
	    	   }
	    	   }
	    	   }
		}
      if(ta_typ.isEmpty() && ta.isEmpty()) {
    	  
    	  result=null;
      }
	
	return result;
	}


	@Override
	public List<Bmx_masterdata_ta> filterByTa(String ta) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta where ta=:ta",Bmx_masterdata_ta.class);
		
		theQuery.setParameter("ta", Integer.parseInt(ta));
		return theQuery.getResultList();
	}


	@Override
	public List<Bmx_masterdata_ta> filterbyTa_typundta2(String ta_typ, String ta_from, String ta_until) {
		
		Session currentSession = entityManager.unwrap(Session.class);
	       List<Bmx_masterdata_ta>result=new ArrayList<Bmx_masterdata_ta>();
	       
	       if(ta_from.isEmpty()&&ta_until.isEmpty()) {
	    	   String[]ta_typs=ta_typ.split(",");
	    	   for(String s:ta_typs) {
	    	   Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta data where data.ta_typ.id=:ta_typ",Bmx_masterdata_ta.class);
	    	   theQuery.setParameter("ta_typ", Integer.parseInt(s));
	    	   for(Bmx_masterdata_ta data:theQuery.getResultList()) {
	    		   result.add(data);
	    	   }
	    	   }
	    	   }
	       else {
	    	   String[]ta_typs=ta_typ.split(",");
	    	   for(String s:ta_typs) {
	    	   Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta data where data.ta_typ.id=:ta_typ and (data.ta between :ta_from and :ta_until)",Bmx_masterdata_ta.class);
	    	   theQuery.setParameter("ta_typ", Integer.parseInt(s));
	    	   theQuery.setParameter("ta_from", Integer.parseInt(ta_from));
	    	   theQuery.setParameter("ta_until", Integer.parseInt(ta_until));
	    	   for(Bmx_masterdata_ta data:theQuery.getResultList()) {
	    		   result.add(data);
	    	   }
	    	   }
	    	   
	       }
	       
		
		
		return result;
	}

	@Override
	public Page<Bmx_masterdata_ta> filterbyTa_typ(int[] ta_typs, Pageable pageable) {
	       Session currentSession = entityManager.unwrap(Session.class);
	       

		List<Bmx_masterdata_ta>result=new ArrayList<Bmx_masterdata_ta>();
		Query<Bmx_masterdata_ta> theQuery=currentSession.createQuery("from Bmx_masterdata_ta",Bmx_masterdata_ta.class);
		List<Bmx_masterdata_ta> list=theQuery.getResultList();
		 
		for(int ta_typ:ta_typs) {
			for(Bmx_masterdata_ta bmx_masterdata_ta: list) {
				if(bmx_masterdata_ta.getTatyp().getId()==ta_typ) {
					result.add(bmx_masterdata_ta);
				}
			}
		}
	    Page<Bmx_masterdata_ta> pages = new PageImpl<Bmx_masterdata_ta>(result, pageable, result.size());
		return pages;
	}

	
	
}
