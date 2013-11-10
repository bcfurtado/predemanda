package br.ufc.quixada.predemanda.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "predemanda")
public class PreDemanda {

	@Id
	@GeneratedValue
	private Long id;

	private Long coordenadorId;
	private String coordenadorNome;

	private Long cursoId;
	private String cursoNome;

	@ElementCollection
	private List<Long> disciplinas;

	private Date dataDaCriacao;

	private Date dataInicio;

	private Date dataFim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCoordenadorId() {
		return coordenadorId;
	}

	public void setCoordenadorId(Long coordenadorId) {
		this.coordenadorId = coordenadorId;
	}

	public String getCoordenadorNome() {
		return coordenadorNome;
	}

	public void setCoordenadorNome(String coordenadorNome) {
		this.coordenadorNome = coordenadorNome;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public String getCursoNome() {
		return cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		this.cursoNome = cursoNome;
	}

	public List<Long> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Long> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Date getDataDaCriacao() {
		return dataDaCriacao;
	}

	public void setDataDaCriacao(Date dataDaCriacao) {
		this.dataDaCriacao = dataDaCriacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.id == ((PreDemanda)obj).getId());
	}

}
