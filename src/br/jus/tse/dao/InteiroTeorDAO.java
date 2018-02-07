package br.jus.tse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.jus.tse.data.HibernateConnector;
import br.jus.tse.entity.InteiroTeor;

public class InteiroTeorDAO {

	

	public InteiroTeor getInteiroTeor(Long id) {
		
	    Session session =  HibernateConnector.getInstance().getSession();
        InteiroTeor inteiroTeor= (InteiroTeor) session.get(InteiroTeor.class, id);
        session.close();
        return inteiroTeor;
	}
	
	public void atualizaInteiroTeor(InteiroTeor it) {		
	    Session session =  HibernateConnector.getInstance().getSession();
	    Transaction tx = session.beginTransaction();
	    session.update(it);    
	    tx.commit();
        session.close();
       
	}
	
	@SuppressWarnings("unchecked")
	public List<InteiroTeor> getAllInteiroTeor() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from InteiroTeor");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (List<InteiroTeor>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
	
	//query especifica solicitada
	@SuppressWarnings("unchecked")
	public List<InteiroTeor> getInteiroCheck() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select i from Decisao d, GrupoDecisao gd, "
            		+ "InteiroTeor i, TipoProcesso tp where d.sqDecisao = gd.decisao and gd.inteiroTeor = i.sqInteiroTeor "
            		+ "and d.tipoProcesso = tp.sqTipoProcesso AND ROWNUM <= 100");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (List<InteiroTeor>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
	
	//query especifica solicitada
		@SuppressWarnings("unchecked")
		public List<Object[]> getCheck() {
	        Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            Query query = session.createQuery("select d.sqDecisao, d.nrProcesso, d.dtDecisao, i.qtPaginasPdf, i.nmArquivoPdf, i.idCasPdf"
	            		+ " from Decisao d, GrupoDecisao gd, "
	            		+ "InteiroTeor i, TipoProcesso tp where d.sqDecisao = gd.decisao and gd.inteiroTeor = i.sqInteiroTeor "
	            		+ "and d.tipoProcesso = tp.sqTipoProcesso AND ROWNUM <= 100");
	 
	            @SuppressWarnings("rawtypes")
				List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return  (List<Object[]>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	  
		}
	
	
}
