package br.jus.tse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_PROCESSO")
public class TipoProcesso  {

	

	@Id
	@SequenceGenerator(name = "SQ_TIPO_PROCESSO", sequenceName = "ADMSJUR.SQ_TIPO_PROCESSO", allocationSize = 1, schema = "ADMSJUR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_PROCESSO")
	@Column(name = "SQ_TIPO_PROCESSO")
	private Long						sqTipoProcesso;

	@Column(name = "SG_TIPO_PROCESSO")
	private String						sgTipoProcesso;

	@Column(name = "NM_TIPO_PROCESSO")
	private String						nmTipoProcesso;

	
	@Column(name = "DS_OBSERVACAO")
	private String						dsObservacao;

	@Column(name = "TP_ORIGEM_PROCESSO")
	private String						tipoOrigemProcesso;

	
	public TipoProcesso() {
	}

	public TipoProcesso(Long sqTipoProcesso) {
		this.sqTipoProcesso = sqTipoProcesso;
	}

	public TipoProcesso(String sgTipoProcesso, String nmTipoProcesso) {
		this.sgTipoProcesso = sgTipoProcesso;
		this.nmTipoProcesso = nmTipoProcesso;
	}

	public TipoProcesso(String sgTipoProcesso, String nmTipoProcesso, String tipoOrigemProcesso) {
		this.sgTipoProcesso = sgTipoProcesso;
		this.nmTipoProcesso = nmTipoProcesso;
		this.tipoOrigemProcesso = tipoOrigemProcesso;
	}


	public Long getSqTipoProcesso() {
		return sqTipoProcesso;
	}

	public void setSqTipoProcesso(Long sqTipoProcesso) {
		this.sqTipoProcesso = sqTipoProcesso;
	}

	public String getSgTipoProcesso() {
		return sgTipoProcesso;
	}

	public void setSgTipoProcesso(String sgTipoProcesso) {
		this.sgTipoProcesso = sgTipoProcesso;
	}

	public String getNmTipoProcesso() {
		return nmTipoProcesso;
	}

	public void setNmTipoProcesso(String nmTipoProcesso) {
		this.nmTipoProcesso = nmTipoProcesso;
	}

	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public String getNomeSigla() {
		return  nmTipoProcesso + " - " + sgTipoProcesso;
	}


	public String getTipoOrigemProcesso() {
		return tipoOrigemProcesso;
	}

	public void setTipoOrigemProcesso(String tipoOrigemProcesso) {
		this.tipoOrigemProcesso = tipoOrigemProcesso;
	}

}
