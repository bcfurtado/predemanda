package br.ufc.quixada.predemanda.bo;

import java.util.List;

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
	
	public List<Resposta> recuperarRespostassDaPreDemanda(Long id) throws DAOException{
		return respostaDAO.findByPreDemanda(id);
	}
	
	public Long recuperarQntDeSolicitacoes(Long idPreDemanda) throws DAOException {
		return respostaDAO.countQntDeSolicitacoesDaPreDemanda(idPreDemanda);
	}

	public Long recuperarQntDeSolicitacoes(Long idPreDemanda, Long idDisciplina) throws DAOException{
		return respostaDAO.countQntDeSolicitacoesDaDisciplinaDeUmaPreDemanda(idPreDemanda, idDisciplina);
	}
	
}
