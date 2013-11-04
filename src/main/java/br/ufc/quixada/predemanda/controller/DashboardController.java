package br.ufc.quixada.predemanda.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;


@Resource
public class DashboardController {

	private final Result result;

	public DashboardController(Result result) {
		this.result = result;
	}

	@Path("/dashboard")
	public void index() {
		result.include("var", "Minha Var!");
	}
	
	@Path("/dashboard/criar")
	public void criar(){
		result.include("var", "Minha Var!");
	}
	
	
	
}
