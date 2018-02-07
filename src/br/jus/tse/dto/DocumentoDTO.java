package br.jus.tse.dto;

import java.util.Date;

public class DocumentoDTO {
	
	  private long sqDecisao;
	
	   private String nrProcesso;
	 
	   private Date dtDecisao;
	   
	   private Integer qtPaginasPdf;
	   
	   private String nmArquivoPdf;
	   
	   private String				idCasPdf;

	public long getSqDecisao() {
		return sqDecisao;
	}

	public void setSqDecisao(long sqDecisao) {
		this.sqDecisao = sqDecisao;
	}

	public String getNrProcesso() {
		return nrProcesso;
	}

	public void setNrProcesso(String nrProcesso) {
		this.nrProcesso = nrProcesso;
	}

	public Date getDtDecisao() {
		return dtDecisao;
	}

	public void setDtDecisao(Date dtDecisao) {
		this.dtDecisao = dtDecisao;
	}

	public Integer getQtPaginasPdf() {
		return qtPaginasPdf;
	}

	public void setQtPaginasPdf(Integer qtPaginasPdf) {
		this.qtPaginasPdf = qtPaginasPdf;
	}

	public String getNmArquivoPdf() {
		return nmArquivoPdf;
	}

	public void setNmArquivoPdf(String nmArquivoPdf) {
		this.nmArquivoPdf = nmArquivoPdf;
	}

	public String getIdCasPdf() {
		return idCasPdf;
	}

	public void setIdCasPdf(String idCasPdf) {
		this.idCasPdf = idCasPdf;
	}

	   
	   
}
