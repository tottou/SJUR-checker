package br.jus.tse.main;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;

import br.jus.tse.dto.DocumentoDTO;
import br.jus.tse.entity.InteiroTeor;
import br.jus.tse.negocio.DocumentoManager;
import br.jus.tse.negocio.SitDocManager;


public class Verificador {
	
	 public static void main(String[] args) throws Exception {

		 
		DocumentoManager dm = new DocumentoManager();
		 List<DocumentoDTO>list = dm.buscarDados();
		 FileWriter writer = new FileWriter("d:\\listaHom2.txt"); 		
		 byte[] arq;
		 int pags;
		 SitDocManager sit = new SitDocManager();
		 
		 int qtdPDFs=0;
		 int qtdFalhas=0;
		 int qtdSemId=0;
		 int qtdpags=0;
		 
		 
		  writer.write("Início do processo: "+new java.util.Date());
		  writer.write("\n");
		  writer.write("===================================================================================");
		  writer.write("\n");
		 
		 for (DocumentoDTO it: list) {			 
				
			
			   
			    try {
			    	
					System.out.println(it.getNmArquivoPdf().substring(it.getNmArquivoPdf().length() - 3));
					
					
					if (it.getNmArquivoPdf().substring(it.getNmArquivoPdf().length() - 3).toLowerCase().equals("pdf")){
						qtdPDFs++;
					if (it.getIdCasPdf()==null){
						qtdSemId++;
						  /* writer.write("SQ  da decisão - "+it.getSqDecisao());
						   writer.write("\n");
						   writer.write("Número do processo - "+it.getNrProcesso());
						   writer.write("\n");
						   writer.write("Nome do arquivo - "+it.getNmArquivoPdf());
						   writer.write("\n");
						   writer.write("Sem Id do sitdoc");
						   writer.write("\n");
						   writer.write("\n");
						   writer.write("===================================================================================");
						   writer.write("\n");*/
					
					}else{
							
				    
			    	   arq=sit.downloadInteiroTeorPDF(new InteiroTeor(it.getIdCasPdf()));
			    	   pags= new PdfReader(arq).getNumberOfPages();
			    	   if (it.getQtPaginasPdf()!=pags){
			    		   writer.write("SQ  da decisão - "+it.getSqDecisao());
						   writer.write("\n");
						   writer.write("Número do processo - "+it.getNrProcesso());
						   writer.write("\n");
						   writer.write("Data da decisão- "+new SimpleDateFormat("dd-MM-yyyy").format(it.getDtDecisao()));
						   writer.write("\n");
						   writer.write("Nome do arquivo - "+it.getNmArquivoPdf());
						   writer.write("\n");
						   writer.write("Qtd de páginas atual - "+it.getQtPaginasPdf());
						   writer.write("\n");
						   writer.write("Qtd de páginas correta - "+pags);
						   writer.write("\n");
						   writer.write("\n");
						   writer.write("===================================================================================");
						   writer.write("\n");
						   qtdpags++;
			    	   }
					}
					   		}
				} catch (Exception e) {
			/*		  writer.write("SQ  da decisão - "+it.getSqDecisao());
					   writer.write("\n");
					   writer.write("Número do processo - "+it.getNrProcesso());
					   writer.write("\n");
					   writer.write("Falha no arquivo"+e);
					   writer.write("\n");
					   writer.write("\n");
					   writer.write("===================================================================================");
					   writer.write("\n");*/
					   qtdFalhas++;
					   
				}
			 
			   
				
			   
		}
		 writer.write("Final do processo: "+new java.util.Date());
		  writer.write("\n");
		 writer.write("Total de itens: "+list.size());
		   writer.write("\n");
		   writer.write("Total de PDFs: "+qtdPDFs);
		   writer.write("\n");
		   writer.write("Total de PDFs com contagem de páginas erradas: "+qtdpags);
		   writer.write("\n");
		   writer.write("Total de itens sem o Id do sitdoc: "+qtdSemId);
		   writer.write("\n");
		   writer.write("Total de itens com erros/falhas: "+qtdFalhas);
		   writer.write("\n");
		 
		 writer.close();
		 System.out.println("finalizado");
		 
		  
	 }

}
