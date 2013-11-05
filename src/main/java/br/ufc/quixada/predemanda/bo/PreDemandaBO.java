package br.ufc.quixada.predemanda.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.controller.DashboardController;
import br.ufc.quixada.predemanda.dao.PreDemandaDAO;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Disciplina;
import br.ufc.quixada.predemanda.model.PreDemanda;
import br.ufc.quixada.predemanda.service.DisciplinaService;

@Component
public class PreDemandaBO {
	
	private DisciplinaService disciplinaService;
	private PreDemandaDAO preDemandaDAO;
	
	private static final Logger logger = Logger.getLogger(PreDemandaBO.class);
	
	public PreDemandaBO(DisciplinaService disciplinaService, PreDemandaDAO preDemandaDAO) {
		this.disciplinaService = disciplinaService;
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
//		preDemanda.setDisciplinas(carregarDisciplinas(disciplinas));

		logger.debug("Data Inicio: " + preDemanda.getDataInicio());
		logger.debug("Data Fim: " + preDemanda.getDataFim());
		logger.debug("Qnt de Disciplina: " + preDemanda.getDisciplinas().size());
		
		preDemandaDAO.create(preDemanda);
	}
	
	private List<Disciplina> carregarDisciplinas(List<Long> disciplinasIds) throws ConnectionException{
		List<Disciplina> disciplinasBanco = new ArrayList<Disciplina>();
		
		List<Disciplina> disciplinasRemote = disciplinaService.listarDisciplinas();
		for (Disciplina disciplina : disciplinasRemote) {
			for (Long disciplinaId : disciplinasIds) {
				if (disciplina.getId() == disciplinaId){
					disciplinasBanco.add(disciplina);
				}
			}
		}
		
		return disciplinasBanco;
	}
	
}
