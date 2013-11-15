package br.ufc.quixada.predemanda.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.predemanda.auth.Restrito;
import br.ufc.quixada.predemanda.bo.CursoBO;
import br.ufc.quixada.predemanda.bo.DisciplinaBO;
import br.ufc.quixada.predemanda.bo.PreDemandaBO;
import br.ufc.quixada.predemanda.bo.RespostaBO;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.exception.DAOException;
import br.ufc.quixada.predemanda.model.Curso;
import br.ufc.quixada.predemanda.model.Disciplina;
import br.ufc.quixada.predemanda.model.PreDemanda;
import br.ufc.quixada.predemanda.model.Resposta;

@Restrito
@Resource
public class DashboardController {

	private final Result result;
	private SessaoWeb sessaoWeb;
	private CursoBO cursoBO;
	private DisciplinaBO disciplinaBO;
	private PreDemandaBO predemandaBO;
	private RespostaBO respostaBO;
			
	private static Logger logger = Logger.getLogger(DashboardController.class);

	private static final String ERRO = "erro";
	private static final String MENSAGEM = "msg";
	
	public DashboardController(Result result, SessaoWeb sessaoWeb,CursoBO cursoBO, DisciplinaBO disciplinaBO, PreDemandaBO predemandaBO, RespostaBO respostaBO) {
		this.result = result;
		this.sessaoWeb = sessaoWeb;
		this.cursoBO = cursoBO;
		this.disciplinaBO = disciplinaBO;
		this.predemandaBO = predemandaBO;
		this.respostaBO = respostaBO;
	}

	@Path("/dashboard")
	public void index() {
		try {
			Curso curso = null;
			if (sessaoWeb.isAluno()){
				curso = cursoBO.recuperarPeloAluno(sessaoWeb.getPessoa().getId());
			} else {
				curso = cursoBO.recuperarPeloIdCoordenador(sessaoWeb.getPessoa().getId());
			}
			
			List<PreDemanda> predemandasAbertas = predemandaBO.recuperarTodasDoCursoAbertas(curso);
			List<PreDemanda> preDemandasFechadas = predemandaBO.recuperarTodasDoCurso(curso);
			preDemandasFechadas.removeAll(predemandasAbertas);

			predemandasAbertas = predemandaBO.recuperarTodasDoCursoAbertas(curso);
			preDemandasFechadas = predemandaBO.recuperarTodasDoCurso(curso);
			preDemandasFechadas.removeAll(predemandasAbertas);
			
			Iterator<PreDemanda> itPreDemanda = predemandasAbertas.iterator();
			while(itPreDemanda.hasNext()){
				PreDemanda preDemanda = itPreDemanda.next();
				Iterator<Resposta> itResposta = respostaBO.recuperarRespostassDaPreDemanda(preDemanda.getId()).iterator();
				while (itResposta.hasNext()) {
					Resposta resposta = itResposta.next();
					if(resposta.getIdAluno() == sessaoWeb.getPessoa().getId()){
						preDemandasFechadas.add(preDemanda);
						itPreDemanda.remove();
						break;
					}
				}
			}
				
			result.include("predemandasAbertas", predemandasAbertas);
			result.include("predemandasFechadas", preDemandasFechadas);
			
		} catch (ConnectionException | DAOException e) {
			result.include(ERRO, e.getMessage());
			result.redirectTo(this).index();
		}
	}
	
	@Get("/dashboard/criar")
	public void criar(){
		try {
			Curso curso = cursoBO.recuperarPeloIdCoordenador(sessaoWeb.getPessoa().getId());
			List<Disciplina> disciplinas = disciplinaBO.recuperarTodas();
			result.include("curso", curso);
			result.include("disciplinas",disciplinas);
		} catch (ConnectionException e) {
			result.include(ERRO, e.getMessage());
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
			result.include(MENSAGEM,"Pré-Demanda cadastrada com sucesso.");
			result.forwardTo(this).index();
		} catch (BusinessLogicException | ConnectionException | DAOException e) {
			result.include(ERRO,e.getMessage());
			result.forwardTo(this).criar();
		}
	}
	
	@Path("/dashboard/visualizar/{id}")
	public void visualizar(Long id){
		try {
			PreDemanda predemanda = predemandaBO.recuperarPeloId(id);
			List<Disciplina> disciplinas = disciplinaBO.recuperarDisciplinas(predemanda.getDisciplinas());
			for (Disciplina disciplina : disciplinas) {
				disciplina.setQntSolicitacoes(respostaBO.recuperarQntDeSolicitacoes(predemanda.getId(), disciplina.getId()));
			}
			
			if(sessaoWeb.isCoordenador()){
				Long qntRespostas = respostaBO.recuperarQntDeSolicitacoes(predemanda.getId());;
				result.include("qntRespostas", qntRespostas);			
			}
			
			result.include("predemanda", predemanda);
			result.include("disciplinas", disciplinas);
		} catch (DAOException | ConnectionException e) {
			result.include(ERRO,e.getMessage());
			result.forwardTo(this).index();
		}
	}
	
	@Get("/dashboard/responder/{id}")
	public void responder(Long id){
		try {
			PreDemanda predemanda = predemandaBO.recuperarPeloId(id);
			List<Disciplina> disciplinas = disciplinaBO.recuperarDisciplinas(predemanda.getDisciplinas());
			
			result.include("predemanda", predemanda);
			result.include("disciplinas", disciplinas);
		} catch (DAOException | ConnectionException e) {
			result.include(ERRO,e.getMessage());
			result.forwardTo(this).index();
		}
	}
	
	@Post("/dashboard/responder")
	public void salvarResposta(Resposta resposta, List<Long> disciplinas){
		try {
			resposta.setIdAluno(sessaoWeb.getPessoa().getId());
			resposta.setDisciplinas(disciplinas);
			logger.debug("PreDemanda id " + resposta.getPreDemanda().getId());
			
			respostaBO.salvarResposta(resposta);
		
			result.include(MENSAGEM,"Pré-Demanda respondida com sucesso.");
			result.forwardTo(this).index();

		} catch (DAOException e) {
			result.include(ERRO,e.getMessage());
			result.forwardTo(this).index();
		}
	}
}
