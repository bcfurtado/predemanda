package br.ufc.quixada.predemanda.bo;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Curso;
import br.ufc.quixada.predemanda.service.CursoService;

@Component
public class CursoBO {

	private CursoService cursoService;
	
	public CursoBO(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public Curso recuperarPeloId(Long id) throws ConnectionException {
		return cursoService.recuperarCurso(id);
	}


	public List<Curso> recuperarTodos() throws ConnectionException {
		return cursoService.listarCursos();
	}
	
	public Curso recuperarPeloIdCoordenador(Long id) throws ConnectionException {
		Curso curso = cursoService.recuperarCursoDoCoordenador(id);
		return curso.getId() != null ? curso : null;
	}

	public Curso recuperarPeloAluno(Long idAluno) throws ConnectionException{
		Curso curso = cursoService.recuperarCursoDoAluno(idAluno);
		return curso.getId() != null ? curso : null;
	}

}
