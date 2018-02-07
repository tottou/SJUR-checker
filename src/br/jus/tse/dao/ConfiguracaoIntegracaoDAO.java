package br.jus.tse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.jus.tse.data.HibernateConnector;
import br.jus.tse.entity.ConfiguracaoIntegracao;

public class ConfiguracaoIntegracaoDAO {

		
	
	public ConfiguracaoIntegracao getConfig() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from ConfiguracaoIntegracao");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (ConfiguracaoIntegracao) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
	
}
