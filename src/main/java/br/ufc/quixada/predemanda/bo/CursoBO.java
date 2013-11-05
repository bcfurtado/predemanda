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
		Curso curso = cursoService.recuperarCurso(id);
		return curso;
	}

	public Curso recuperarPeloIdCoordenador(Long id) throws ConnectionException {
		Curso curso = cursoService.recuperarCursoDoCoordenador(id);
		return curso;
	}

	public List<Curso> recuperarTodos() throws ConnectionException {
		List<Curso> cursos = cursoService.listarCursos();
		return cursos;
	}

}
