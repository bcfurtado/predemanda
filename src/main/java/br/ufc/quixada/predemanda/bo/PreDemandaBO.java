package br.ufc.quixada.predemanda.bo;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.dao.PreDemandaDAO;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Curso;
import br.ufc.quixada.predemanda.model.PreDemanda;

@Component
public class PreDemandaBO {
	
	private PreDemandaDAO preDemandaDAO;
	
	private static final Logger logger = Logger.getLogger(PreDemandaBO.class);
	
	public PreDemandaBO(PreDemandaDAO preDemandaDAO) {
		this.preDemandaDAO = preDemandaDAO;
	}

	public void criarPreDemanda(PreDemanda preDemanda, List<Long> disciplinas) throws BusinessLogicException, DAOException, ConnectionException{
		if (preDemanda.getDataInicio() == null){
			throw new BusinessLogicException("A pré-demanda deve possuir uma data inicial.");
		}
		if (preDemanda.getDataFim() == null){
			throw new BusinessLogicException("A pré-demanda deve possuir uma data fim.");
		}
		if (disciplinas == null || disciplinas.isEmpty()){
			throw new BusinessLogicException("A pré-demanda deve possuir disciplinas.");
		}
		
		preDemanda.setDataDaCriacao(new Date());
		preDemanda.setDisciplinas(disciplinas);

		logger.debug("Data Inicio: " + preDemanda.getDataInicio());
		logger.debug("Data Fim: " + preDemanda.getDataFim());
		logger.debug("Qnt de Disciplina: " + preDemanda.getDisciplinas().size());
		
		preDemandaDAO.create(preDemanda);
	}
	
	public PreDemanda recuperarPeloId(Long id) throws DAOException {
		return preDemandaDAO.findById(id);
	}

	public List<PreDemanda> recuperarTodas() throws DAOException {
		return preDemandaDAO.findAll();
	}
	
	public List<PreDemanda> recuperarTodasDoCurso(Curso curso) throws DAOException{
		return preDemandaDAO.findByCurso(curso.getId());
	}

	public List<PreDemanda> recuperarTodasDoCursoAbertas(Curso curso) throws DAOException{
		return preDemandaDAO.findByCursoAndOpen(curso.getId(), new Date());
	}

}
