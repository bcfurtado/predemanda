package br.ufc.quixada.predemanda.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ufc.quixada.predemanda.bo.PessoaBO;
import br.ufc.quixada.predemanda.exception.BusinessLogicException;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Pessoa;

@Resource
public class IndexController {

	private SessaoWeb sessaoWeb;
//	private PessoaBO pessoaBO;
	private final Result result;
	
	public IndexController(SessaoWeb sessaoWeb, Result result) {
		this.sessaoWeb = sessaoWeb;
//		this.pessoaBO = pessoaBO;
		this.result = result;
	}

	@Path("/")	//Login
	public void index() {
		result.include("var", "Minha Var!");
	}
	
	@Post("/autenticar")
	public void autenticar(String login, String senha){
		try {
			PessoaBO pessoaBO = new PessoaBO();
			Pessoa pessoa = pessoaBO.autenticar(login, senha);
			sessaoWeb.login(pessoa);
		} catch (BusinessLogicException | ConnectionException e) {
			e.printStackTrace();
		}
	}
	
	@Path("/logout")
	public void logout(){
		
	}

}
