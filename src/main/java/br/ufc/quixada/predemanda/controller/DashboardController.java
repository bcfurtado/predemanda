package br.ufc.quixada.predemanda.controller;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.predemanda.bo.CursoBO;
import br.ufc.quixada.predemanda.bo.DisciplinaBO;
import br.ufc.quixada.predemanda.bo.PreDemandaBO;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Curso;
import br.ufc.quixada.predemanda.model.Disciplina;
import br.ufc.quixada.predemanda.model.PreDemanda;

@Resource
public class DashboardController {

	private final Result result;
	private SessaoWeb sessaoWeb;
	private CursoBO cursoBO;
	private DisciplinaBO disciplinaBO;
	private PreDemandaBO predemandaBO;
			
	private static final Logger logger = Logger.getLogger(DashboardController.class);

	public DashboardController(Result result, SessaoWeb sessaoWeb,CursoBO cursoBO, DisciplinaBO disciplinaBO, PreDemandaBO predemandaBO) {
		this.result = result;
		this.sessaoWeb = sessaoWeb;
		this.cursoBO = cursoBO;
		this.disciplinaBO = disciplinaBO;
		this.predemandaBO = predemandaBO;
	}

	@Path("/dashboard")
	public void index() {
		result.include("var", "Minha Var!");
	}
	
	@Get("/dashboard/criar")
	public void criar(){
		try {
			Curso curso = cursoBO.recuperarPeloIdCoordenador(sessaoWeb.getPessoa().getId());
			List<Disciplina> disciplinas = disciplinaBO.recuperarTodas();
			result.include("curso", curso);
			result.include("disciplinas",disciplinas);
		} catch (ConnectionException e) {
			result.include("erro", e.getMessage());
			result.redirectTo(this).index();
		}
	}
	
	@Post("/dashboard/criar")
	public void criar(PreDemanda preDemanda, List<Long> disciplinas){
		try {
			Curso curso = cursoBO.recuperarPeloIdCoordenador(sessaoWeb.getPessoa().getId());
			
			preDemanda.setCursoId(curso.getId());
			preDemanda.setCursoNome(curso.getNomeCurso());
			preDemanda.setCoordenadorId(sessaoWeb.getPessoa().getCoordenador().getId());
			preDemanda.setCoordenadorNome(sessaoWeb.getPessoa().getNome());
			
			predemandaBO.criarPreDemanda(preDemanda, disciplinas);
			result.include("msg","Pré-Demanda cadastrada com sucesso.");
			result.forwardTo(this).index();
		} catch (BusinessLogicException | ConnectionException | DAOException e) {
			result.include("erro",e.getMessage());
			result.forwardTo(this).criar();
		}
	}
	
	@Path("/dashboard/listar")
	public void listar(){
		try {
			result.include("predemandas", predemandaBO.recuperarTodas());
		} catch (DAOException e) {
			result.include("erro",e.getMessage());
			result.forwardTo(this).index();
		}
	}
	
	@Path("/dashboard/visualizar/{id}")
	public void visualizar(Long id){
		try {
			PreDemanda predemanda = predemandaBO.recuperarPeloId(id);
			List<Disciplina> disciplinas = disciplinaBO.recuperarDisciplinas(predemanda.getDisciplinas());
			
			result.include("predemanda", predemanda);
			result.include("disciplinas", disciplinas);
		} catch (DAOException | ConnectionException e) {
			result.include("erro",e.getMessage());
			e.printStackTrace();
			result.forwardTo(this).index();
		}
	}
	
}
