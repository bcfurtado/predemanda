package br.ufc.quixada.predemanda.model;


public class Disciplina {

	private Long id;

	private String codigo;

	private String nome;
	
	private Long qntSolicitacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQntSolicitacoes() {
		return qntSolicitacoes;
	}

	public void setQntSolicitacoes(Long qntSolicitacoes) {
		this.qntSolicitacoes = qntSolicitacoes;
	}
	
}
