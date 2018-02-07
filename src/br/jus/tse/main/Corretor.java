package br.jus.tse.main;

import java.util.List;

import com.itextpdf.text.pdf.PdfReader;

import br.jus.tse.dao.DecisaoDAO;
import br.jus.tse.dao.InteiroTeorDAO;
import br.jus.tse.entity.InteiroTeor;
import br.jus.tse.negocio.SitDocManager;

public class Corretor {
 public static void main(String[] args) throws Exception {

		 
	 InteiroTeorDAO daoi = new InteiroTeorDAO();
	 DecisaoDAO daod = new DecisaoDAO();
	 List<InteiroTeor>list = daoi.getInteiroCheck();	 		
	 byte[] arq;
	 int pags;
	 SitDocManager sit = new SitDocManager();	 
	 int qtd=0;	
	 
	 for (InteiroTeor it: list) {			
		
		   
		    try {				
				
				if (it.getNmArquivoPdf().substring(it.getNmArquivoPdf().length() - 3).toLowerCase().equals("pdf")){
				
			
			    
		    	   arq=sit.downloadInteiroTeorPDF(it);
		    	   pags= new PdfReader(arq).getNumberOfPages();
		    	   if (it.getQtPaginasPdf()!=pags){
		    		   	it.setQtPaginasPdf(pags);
		    		   	daoi.atualizaInteiroTeor(it);
		    		   	daod.gerarDecisaoXML(daod.getDecisaoInteiroTeor(it.getSqInteiroTeor()).getSqDecisao(), true);
		    		   	qtd++; 
		    		   	
		    	   }
				
				   		}
			} catch (Exception e) {
				System.out.println(e);
				   
			}		 
	
		   
	}

	 System.out.println(qtd); 
	 System.out.println("done");
	 

  }
}
