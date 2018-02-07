package br.jus.tse.negocio;

import br.jus.tse.dao.ConfiguracaoIntegracaoDAO;
import br.jus.tse.entity.ConfiguracaoIntegracao;
import br.jus.tse.entity.InteiroTeor;

public class SitDocManager {
	
	public SitDocManager (){
		ConfiguracaoIntegracaoDAO dao = new ConfiguracaoIntegracaoDAO();
		 this.configuracaoIntegracao = dao.getConfig();
	}
	
	private ConfiguracaoIntegracao configuracaoIntegracao;
	
	public byte[] downloadInteiroTeorPDF(InteiroTeor inteiroTeor) throws Exception  {
		byte[] retorno = null;
		
		
		if(configuracaoIntegracao == null) {
			throw new Exception("Falha na configuração da integração com o SitDoc");
		}
		
		if(configuracaoIntegracao.getUsuario().isEmpty()) {
			throw new Exception("Falha na configuração da integração com o SitDoc");
		}
		
		if(inteiroTeor.getIdCasPdf()==null) {
			throw new Exception("DownloadPDF : O idPDF está inválido.");
		}
		
		try {
			String token = new Autenticacao().autenticar(configuracaoIntegracao.getUrlAutenticacao(),configuracaoIntegracao.getUsuario(),configuracaoIntegracao.getSenha());
			if ( token == null || token.contains("ERROR 500") )
				throw new Exception("Erro ao autenticar no SitDoc. Não foi possível recuperar o arquivo.");
			retorno = DownloadArquivo.efetuaDownload(configuracaoIntegracao.getUrlDownload(),inteiroTeor.getIdCasPdf(),token);
		} catch (IllegalArgumentException e) {
			throw new Exception("Falha ao recuperar arquivo do SitDoc. Token/idPDF inválido ou arquivo não existe.");
		}
		
		return retorno;
	}

	public ConfiguracaoIntegracao getConfiguracaoIntegracao() {
		return configuracaoIntegracao;
	}

	public void setConfiguracaoIntegracao(ConfiguracaoIntegracao configuracaoIntegracao) {
		this.configuracaoIntegracao = configuracaoIntegracao;
	}


}
