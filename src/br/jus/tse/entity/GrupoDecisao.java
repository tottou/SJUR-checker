package br.jus.tse.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "GRUPO_DECISAO")
public class GrupoDecisao  {
	
	@Id
	@GeneratedValue
	@Column(name="sq_grupo_decisao")
	private long sqGrupoDecisao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SQ_DECISAO", nullable = false, insertable = false, updatable = false)
	private Decisao					decisao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "SQ_DECISAO_PAI", referencedColumnName = "SQ_DECISAO")
	@Fetch(FetchMode.JOIN)
	private Decisao					decisaoPai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SQ_INTEIRO_TEOR", nullable = false)
	private InteiroTeor				inteiroTeor;


	public static GrupoDecisao getInstance() {
		GrupoDecisao obj = new GrupoDecisao();
		return obj;
	}

	public GrupoDecisao() {
	}


	public GrupoDecisao(Decisao decisao, InteiroTeor inteiroTeor) {
		this.decisao = decisao;
		this.inteiroTeor = inteiroTeor;
	}


	public Decisao getDecisao() {
		return this.decisao;
	}

	public void setDecisao(Decisao decisao) {
		this.decisao = decisao;
	}

	public InteiroTeor getInteiroTeor() {
		return this.inteiroTeor;
	}

	public void setInteiroTeor(InteiroTeor inteiroTeor) {
		this.inteiroTeor = inteiroTeor;
	}


	public Decisao getDecisaoPai() {
		return decisaoPai;
	}

	public void setDecisaoPai(Decisao decisaoPai) {
		this.decisaoPai = decisaoPai;
	}

	public long getSqGrupoDecisao() {
		return sqGrupoDecisao;
	}

	public void setSqGrupoDecisao(long sqGrupoDecisao) {
		this.sqGrupoDecisao = sqGrupoDecisao;
	}
	
	


}
