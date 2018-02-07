package br.jus.tse.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.jus.tse.dao.InteiroTeorDAO;
import br.jus.tse.dto.DocumentoDTO;

public class DocumentoManager {
	
	public List<DocumentoDTO> buscarDados(){
		List<DocumentoDTO> listaDTO= new ArrayList<DocumentoDTO>();
		InteiroTeorDAO dao = new InteiroTeorDAO();
		List<Object[]> listaObjetos = dao.getCheck();
		System.out.println(listaObjetos.size());
		DocumentoDTO doc;
		int cont=0;
		for (Object[] obj : listaObjetos) {
			 doc = new DocumentoDTO();
			 System.out.println(cont);
			 cont++;
			 doc.setSqDecisao(castLongObject(obj[0]));
			 doc.setNrProcesso((String)obj[1]);
			 doc.setDtDecisao((Date)obj[2]);
			 doc.setQtPaginasPdf(castIntObject(obj[3]));
			 doc.setNmArquivoPdf((String)obj[4]);
			 doc.setIdCasPdf((String)obj[5]);
			 
			 listaDTO.add(doc);
		}
		return listaDTO;
	}
	
	public Long castLongObject(Object object) {
        Long result = 0l;
        try {
            if (object instanceof Long)
                result = ((Long) object).longValue();
            else if (object instanceof Integer) {
                result = ((Integer) object).longValue();
            } else if (object instanceof String) {
                result = Long.valueOf((String) object);
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("============= oh não");
           
        }
        return result;
    }
	
	public int castIntObject(Object object) {
       int result = 0;
        try {
            if (object instanceof Long)
                result = ((Long) object).intValue();
            else if (object instanceof Integer) {
                result = ((Integer) object).intValue();
            } else if (object instanceof String) {
                result = Integer.valueOf((String) object);
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("============= oh não");
           
        }
        return result;
    }

}
