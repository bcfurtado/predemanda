package br.ufc.quixada.predemanda.bo;

import java.util.ArrayList;
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
		return disciplinaService.recuperarDisciplina(id);
	}
	
	public List<Disciplina> recuperarTodas() throws ConnectionException{
		return disciplinaService.listarDisciplinas();
	}

	public List<Disciplina> recuperarDisciplinas(List<Long> idDisciplinas) throws ConnectionException {
		List<Disciplina> disciplinasServico = recuperarTodas();
		List<Disciplina> disciplinasLocal = new ArrayList<Disciplina>();

		for (Disciplina disciplina : disciplinasServico) {
			for (Long id : idDisciplinas) {
				if (disciplina.getId() == id){
					disciplinasLocal.add(disciplina);
				}
			}
		}
		
		return disciplinasLocal;
	}
	
}
