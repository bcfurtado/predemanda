package br.ufc.quixada.predemanda.dao;

import java.util.List;

import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Resposta;

public interface RespostaDAO {

	public void create(Resposta resposta) throws DAOException;

	public void update(Resposta resposta) throws DAOException;
	
	public Resposta findById(Long id) throws DAOException;
	
	public List<Resposta> findAll() throws DAOException;
	
	public void remover(Long id) throws DAOException;
	
	public List<Resposta> findByPreDemanda(Long idPreDemanda) throws DAOException;

	public Long countQntDeSolicitacoesDaDisciplinaDeUmaPreDemanda(Long idPreDemanda, Long idDisciplina) throws DAOException;
}
