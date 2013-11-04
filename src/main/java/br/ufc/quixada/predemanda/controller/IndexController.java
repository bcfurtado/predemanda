package br.ufc.quixada.predemanda.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {

	private final Result result;

	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")	//Login
	public void index() {
		result.include("var", "Minha Var!");
	}
	
	@Path("/autenticar")
	public void autenticar(String login, String senha){
		
	}
	
	@Path("/logout")
	public void logout(){
		
	}

}
