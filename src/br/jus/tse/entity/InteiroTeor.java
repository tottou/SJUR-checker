package br.jus.tse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INTEIRO_TEOR")
public class InteiroTeor {

	

	@Id
	@SequenceGenerator(name = "SQ_INTEIRO_TEOR", sequenceName = "ADMSJUR.SQ_INTEIRO_TEOR", allocationSize = 1, schema = "ADMSJUR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INTEIRO_TEOR")
	@Column(name = "SQ_INTEIRO_TEOR")
	private Long				sqInteiroTeor;	

	@Column(name = "TX_INTEIRO_TEOR_PDF")
	private String				txInteiroTeorPdf;

	@Column(name = "QT_PAGINAS_PDF")
	private Integer				qtPaginasPdf;

	@Column(name = "ID_CAS_PDF")
	private String				idCasPdf;

	@Column(name = "NM_ARQUIVO_PDF")
	private String				nmArquivoPdf;

	
	public InteiroTeor() {
		
	}
	
    public InteiroTeor(String idCas) {
		this.idCasPdf=idCas;
	}
	



	public InteiroTeor(Long sqInteiroTeor) {
		this.sqInteiroTeor = sqInteiroTeor;
	}

	public static InteiroTeor getInstance() {
		InteiroTeor obj = new InteiroTeor();
		return obj;
	}

	public Long getSqInteiroTeor() {
		return this.sqInteiroTeor;
	}

	public void setSqInteiroTeor(Long sqInteiroTeor) {
		this.sqInteiroTeor = sqInteiroTeor;
	}


	public String getTxInteiroTeorPdf() {
		return this.txInteiroTeorPdf;
	}

	public void setTxInteiroTeorPdf(String txInteiroTeorPdf) {
		this.txInteiroTeorPdf = txInteiroTeorPdf;
	}

	public Integer getQtPaginasPdf() {
		return this.qtPaginasPdf;
	}

	public void setQtPaginasPdf(Integer qtPaginasPdf) {
		this.qtPaginasPdf = qtPaginasPdf;
	}

	public String getIdCasPdf() {
		return this.idCasPdf;
	}

	public void setIdCasPdf(String idCasPdf) {
		this.idCasPdf = idCasPdf;
	}


	public String getNmArquivoPdf() {
		return this.nmArquivoPdf;
	}

	public void setNmArquivoPdf(String nmArquivoPdf) {
		this.nmArquivoPdf = nmArquivoPdf;
	}



	public String getDsInteiroTeorHtml() {
		String txInteiroTeorPdfHtml = "";
		if (txInteiroTeorPdf != null) {
			txInteiroTeorPdfHtml = txInteiroTeorPdf.replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>")
					.replaceAll(" ", "&nbsp;");
		}
		return txInteiroTeorPdfHtml;
	}


}

