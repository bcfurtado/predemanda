package br.ufc.quixada.predemanda.dao.impl;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.dao.PreDemandaDAO;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.PreDemanda;

@Component
public class PreDemandaDAOImpl implements PreDemandaDAO {

	@Override
	public void create(PreDemanda preDemanda) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PreDemanda preDemanda) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreDemanda findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PreDemanda> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}


}
