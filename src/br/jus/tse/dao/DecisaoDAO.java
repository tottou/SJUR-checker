package br.jus.tse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.jus.tse.data.HibernateConnector;
import br.jus.tse.entity.Decisao;

public class DecisaoDAO {

	

	public Decisao getDecisao(Long id) {
		
	    Session session =  HibernateConnector.getInstance().getSession();
        Decisao decisao= (Decisao) session.get(Decisao.class, id);
        session.close();
        return decisao;
	}
	
	@SuppressWarnings("unchecked")
	public List<Decisao> getAllDecisao() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from decisao");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (List<Decisao>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
	
	public void gerarDecisaoXML(Long sqDecisao, Boolean forcarGeracao) {		
		Session session = null;
		Query query = null;
		 try {
	            session = HibernateConnector.getInstance().getSession();
	            	if ( forcarGeracao ) 
	    			query = session.createSQLQuery("BEGIN ADMSJUR.PC_GERA_XML.DECISAO_XML(?,true); END;");
	    		else
	    			query = session.createSQLQuery("BEGIN ADMSJUR.PC_GERA_XML.DECISAO_XML(?); END;");
	            	
	            	query.setParameter(0, sqDecisao);
	        		query.executeUpdate();	        		
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        } finally {
	            session.close();
	        }
	
	}
	
	//query especifica solicitada		
			public Decisao getDecisaoInteiroTeor(Long sqInteiroTeor) {
		        Session session = null;
		        try {
		            session = HibernateConnector.getInstance().getSession();
		            Query query = session.createQuery("select d"
		            		+ " from Decisao d, GrupoDecisao gd, "
		            		+ "InteiroTeor i, TipoProcesso tp where d.sqDecisao = gd.decisao and gd.inteiroTeor = i.sqInteiroTeor "
		            		+ "and d.tipoProcesso = tp.sqTipoProcesso  AND i.sqInteiroTeor= :sqIt");
		            query.setParameter("sqIt", sqInteiroTeor);
		 
		            @SuppressWarnings("rawtypes")
					List queryList = query.list();
		            if (queryList != null && queryList.isEmpty()) {
		                return null;
		            } else {
		                return  (Decisao) queryList.get(0);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            return null;
		        } finally {
		            session.close();
		        }
		  
			}
		
	
}
