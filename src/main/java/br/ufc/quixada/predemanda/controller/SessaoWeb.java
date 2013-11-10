package br.ufc.quixada.predemanda.controller;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.quixada.predemanda.model.Pessoa;

@Component
@SessionScoped
public class SessaoWeb {

	private Pessoa pessoa;

	public void login(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public boolean isLogado() {
		return pessoa != null;
	}

	public void logout() {
		this.pessoa = null;
	}
	
	public boolean isAluno() {
		return pessoa.getAluno().getId() != null;
	}

	public boolean isCoordenador() {
		return pessoa.getCoordenador().getId() != null;
	}

}
