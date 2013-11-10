package br.ufc.quixada.predemanda.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.dao.PreDemandaDAO;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.PreDemanda;

@SuppressWarnings("unchecked")
@Component
public class PreDemandaDAOImpl implements PreDemandaDAO {

	private EntityManager em;
	
	public PreDemandaDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(PreDemanda preDemanda) throws DAOException {
		em.persist(preDemanda);
	}

	@Override
	public void update(PreDemanda preDemanda) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreDemanda findById(Long id) throws DAOException {
		try {
			Query query = em.createQuery("select p from PreDemanda as p where p.id = :id");
			query.setParameter("id", id);
			return (PreDemanda) query.getSingleResult();
		} catch (NoResultException e) {
			throw new DAOException("Pré-Demanda não encontrada");
		}

	}

	@Override
	public List<PreDemanda> findAll() throws DAOException {
		Query query = em.createQuery("select p from PreDemanda as p order by p.dataDaCriacao desc");
		return query.getResultList();
	}

	@Override
	public void remover(Long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<PreDemanda> findByCurso(Long idCurso) throws DAOException {
		Query query = em.createQuery("select p from PreDemanda as p where p.cursoId = :curso order by p.dataDaCriacao DESC");
		query.setParameter("curso", idCurso);
		return query.getResultList();
	}

	public List<PreDemanda> findByCursoAndOpen(Long idCurso, Date hoje){
		Query query = em.createQuery("select p from PreDemanda as p where :data >= p.dataInicio and :data <= p.dataFim and p.cursoId = :curso order by p.dataDaCriacao DESC");
		query.setParameter("data", hoje);
		query.setParameter("curso", idCurso);
		return query.getResultList();
	}

}
