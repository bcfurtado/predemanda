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
	private PessoaBO pessoaBO;
	private final Result result;

	public IndexController(SessaoWeb sessaoWeb, PessoaBO pessoaBO, Result result) {
		this.sessaoWeb = sessaoWeb;
		this.pessoaBO = pessoaBO;
		this.result = result;
	}

	@Path("/")	//Login
	public void index() {
		if (sessaoWeb.isLogado()){
			result.redirectTo(DashboardController.class).index();			
		}
	}
	
	@Post("/autenticar")
	public void autenticar(String email, String senha){
		try {
			Pessoa pessoa = pessoaBO.autenticar(email, senha);
			sessaoWeb.login(pessoa);
			if ( !sessaoWeb.isAluno() && !sessaoWeb.isCoordenador() ){
				throw new BusinessLogicException("Esse nivel de usuário não tem acesso ao sistema.");
			}
			result.redirectTo(DashboardController.class).index();
		} catch (BusinessLogicException | ConnectionException e) {
			result.include("erro", e.getMessage());
			result.redirectTo(this).index();
		}
	}
	
	@Path("/logout")
	public void logout(){
		sessaoWeb.logout();
		result.redirectTo(this).index();
	}

}
