package br.ufc.quixada.predemanda.bo;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Disciplina;
import br.ufc.quixada.predemanda.service.DisciplinaService;

@Component
public class DisciplinaBO {

	private DisciplinaService disciplinaService;
	
	public DisciplinaBO(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	public Disciplina recuperarDisciplina(Long id) throws ConnectionException{
		Disciplina disciplina = disciplinaService.recuperarDisciplina(id);
		return disciplina;
	}
	
	public List<Disciplina> recuperarTodas() throws ConnectionException{
		List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
		return disciplinas;
	}
	
}
