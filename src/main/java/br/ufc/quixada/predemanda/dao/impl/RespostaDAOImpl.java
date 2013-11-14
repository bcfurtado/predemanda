package br.ufc.quixada.predemanda.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.dao.RespostaDAO;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.PreDemanda;
import br.ufc.quixada.predemanda.model.Resposta;

@Component
public class RespostaDAOImpl implements RespostaDAO {

	private EntityManager em;
	
	public RespostaDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(Resposta resposta) throws DAOException {
		em.persist(resposta);
	}

	@Override
	public void update(Resposta resposta) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Resposta findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resposta> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long id) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resposta> findByPreDemanda(Long idPreDemanda) throws DAOException {
		Query query = em.createQuery("select r from Resposta as r where r.preDemanda = :predemanda");
		PreDemanda preDemanda = new PreDemanda();
		preDemanda.setId(idPreDemanda);
		query.setParameter("predemanda", preDemanda);
		return query.getResultList();
	}

	public Long countQntDeSolicitacoesDaPreDemanda(Long idPreDemanda){
		Query query = em.createQuery("select count(r) from Resposta as r where r.preDemanda = :preDemanda");
		PreDemanda preDemanda = new PreDemanda();
		preDemanda.setId(idPreDemanda);
		query.setParameter("preDemanda", preDemanda);
		return (Long) query.getSingleResult();
	}

	
	public Long countQntDeSolicitacoesDaDisciplinaDeUmaPreDemanda(Long idPreDemanda, Long idDisciplina){
		Query query = em.createQuery("select count(r) from Resposta as r where r.preDemanda = :preDemanda and :idDisciplina member of r.disciplinas");
		PreDemanda preDemanda = new PreDemanda();
		preDemanda.setId(idPreDemanda);
		query.setParameter("preDemanda", preDemanda);
		query.setParameter("idDisciplina",idDisciplina);
		return (Long) query.getSingleResult();
	}

}
