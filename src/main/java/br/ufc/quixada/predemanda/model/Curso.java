package br.ufc.quixada.predemanda.model;

public class Curso {

	private Long id;
	
	private String codigoCurso;
	
	private String nomeCurso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
}
