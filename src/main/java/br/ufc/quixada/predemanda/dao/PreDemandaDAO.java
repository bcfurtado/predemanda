package br.ufc.quixada.predemanda.dao;

import java.util.Date;
import java.util.List;

import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.PreDemanda;

public interface PreDemandaDAO {

	public void create(PreDemanda preDemanda) throws DAOException;

	public void update(PreDemanda preDemanda) throws DAOException;
	
	public PreDemanda findById(Long id) throws DAOException;
	
	public List<PreDemanda> findAll() throws DAOException;
	
	public void remover(Long id) throws DAOException;
	
	public List<PreDemanda> findByCurso(Long id) throws DAOException;

	public List<PreDemanda> findByCursoAndOpen(Long idCurso, Date hoje) throws DAOException;
}
