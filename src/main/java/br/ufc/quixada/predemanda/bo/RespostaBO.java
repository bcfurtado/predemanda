package br.ufc.quixada.predemanda.bo;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.dao.RespostaDAO;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Resposta;

@Component
public class RespostaBO {

	private RespostaDAO respostaDAO;
	
	public RespostaBO(RespostaDAO respostaDAO) {
		this.respostaDAO = respostaDAO;
	}

	public void salvarResposta(Resposta resposta) throws DAOException {
		respostaDAO.create(resposta);
	}
	
}
