package br.jus.tse.negocio;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;

public class PDFManager {
	
	public int getNumeroPaginas(byte[] arquivo){
		try {
			return new PdfReader(arquivo).getNumberOfPages();
		} catch (IOException e) {			
			e.printStackTrace();
			return 0;
		}
	}

}
