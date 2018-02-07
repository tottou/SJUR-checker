package br.jus.tse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURACAO_INTEGRACAO")
public class ConfiguracaoIntegracao {


	@Id
	@Column(name="NM_USUARIO_SJUR")
	private String usuario;
	
	@Column(name="DS_URL_AUTENTICACAO")
	private String urlAutenticacao;
	
	@Column(name="DS_URL_UPLOAD")
	private String urlUpload;
	
	@Column(name="DS_URL_DOWNLOAD")
	private String urlDownload;
	
	@Column(name="DS_SENHA_SJUR")
	private String senha;
	
	@Column(name="SQ_TP_DOC")
	private String sqTpDoc;
	
	@Column(name="CD_SJUR")
	private String cdSjur;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUrlAutenticacao() {
		return urlAutenticacao;
	}

	public void setUrlAutenticacao(String urlAutenticacao) {
		this.urlAutenticacao = urlAutenticacao;
	}

	public String getUrlUpload() {
		return urlUpload;
	}

	public void setUrlUpload(String urlUpload) {
		this.urlUpload = urlUpload;
	}

	public String getUrlDownload() {
		return urlDownload;
	}

	public void setUrlDownload(String urlDownload) {
		this.urlDownload = urlDownload;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSqTpDoc() {
		return sqTpDoc;
	}

	public void setSqTpDoc(String sqTpDoc) {
		this.sqTpDoc = sqTpDoc;
	}

	public String getCdSjur() {
		return cdSjur;
	}

	public void setCdSjur(String cdSjur) {
		this.cdSjur = cdSjur;
	}

}
