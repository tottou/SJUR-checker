package br.jus.tse.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="decisao")
public class Decisao {
	
	@Id
	@GeneratedValue
	@Column(name="sq_decisao")
	private long sqDecisao;
	
    @Column(name = "NR_PROCESSO")
    private String nrProcesso;

	@ManyToOne
    @JoinColumn(name = "SQ_TIPO_PROCESSO", referencedColumnName = "SQ_TIPO_PROCESSO")
    private TipoProcesso tipoProcesso;
	
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DT_DECISAO")
    private Date dtDecisao;

	public long getSqDecisao() {
		return sqDecisao;
	}

	public void setSqDecisao(long sqDecisao) {
		this.sqDecisao = sqDecisao;
	}


	public TipoProcesso getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(TipoProcesso tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
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
	

}
