package br.jus.tse.main;

import java.util.List;

import br.jus.tse.dao.DecisaoDAO;
import br.jus.tse.dao.GrupoDecisaoDAO;
import br.jus.tse.dto.DocumentoDTO;
import br.jus.tse.entity.Decisao;
import br.jus.tse.entity.GrupoDecisao;
import br.jus.tse.negocio.DocumentoManager;

public class Teste {
	
	public static void main(String[] args) {
		/*GrupoDecisaoDAO dao = new GrupoDecisaoDAO();
		GrupoDecisao gd = new GrupoDecisao();
		List<GrupoDecisao> lista = dao.getCheck();
		System.out.println(lista.size());
		for (int i = 0; i < 10; i++) {
			gd = lista.get(i);
			System.out.println(gd.getDecisao().getSqDecisao());
			System.out.println(gd.getDecisao().getNrProcesso());
			System.out.println(gd.getDecisao().getDtDecisao());
			System.out.println(gd.getInteiroTeor().getNmArquivoPdf());
			System.out.println(gd.getInteiroTeor().getSqInteiroTeor());
			System.out.println("----");
		}*/
		
/*		
		DocumentoManager dm = new DocumentoManager();
		

		List<DocumentoDTO> lista = dm.buscarDados();
		

		
		for (int i = 0; i < 10; i++) {
			System.out.println(lista.get(i).getSqDecisao());
			System.out.println(lista.get(i).getNrProcesso());
			System.out.println(lista.get(i).getDtDecisao());
			System.out.println(lista.get(i).getQtPaginasPdf());
			System.out.println(lista.get(i).getNmArquivoPdf());
			
		}
		*/
		
		DecisaoDAO dao = new DecisaoDAO();
		Decisao dec= dao.getDecisaoInteiroTeor(162716L);
		System.out.println(dec.getNrProcesso());
		
		
		
	}

}
