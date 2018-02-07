package br.jus.tse.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.jus.tse.data.HibernateConnector;
import br.jus.tse.entity.GrupoDecisao;

public class GrupoDecisaoDAO {

	

	//query especifica solicitada
	@SuppressWarnings("unchecked")
	public List<GrupoDecisao> getCheck() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select gd from Decisao d, GrupoDecisao gd, "
            		+ "InteiroTeor i, TipoProcesso tp where d.sqDecisao = gd.decisao and gd.inteiroTeor = i.sqInteiroTeor "
            		+ "and d.tipoProcesso = tp.sqTipoProcesso");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (List<GrupoDecisao>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
}
