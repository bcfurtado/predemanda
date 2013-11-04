package br.ufc.quixada.predemanda.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.ufc.quixada.predemanda.model.Pessoa;

@Component
@SessionScoped
public class SessaoWeb {

	private Pessoa pessoaLogado;

	public SessaoWeb() {
	}
	
	public void login(Pessoa pessoa) {
		this.pessoaLogado = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoaLogado;
	}

	public String getNome() {
		return pessoaLogado.getNome();
	}

	public boolean isLogado() {
		return pessoaLogado != null;
	}

	public void logout() {
		this.pessoaLogado = null;
	}

}
