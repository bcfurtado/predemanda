package br.ufc.quixada.predemanda.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="resposta")
public class Resposta {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private PreDemanda preDemanda;

	private Long idAluno;
	
	@ElementCollection
	private List<Long> disciplinas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PreDemanda getPreDemanda() {
		return preDemanda;
	}

	public void setPreDemanda(PreDemanda preDemanda) {
		this.preDemanda = preDemanda;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public List<Long> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Long> disciplinas) {
		this.disciplinas = disciplinas;
	}

}