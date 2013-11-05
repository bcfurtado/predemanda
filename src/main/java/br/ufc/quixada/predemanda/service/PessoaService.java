package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Pessoa;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class PessoaService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/pessoas";

	public Pessoa recuperarPessoa(Long id) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarPessoa/"+ Long.toString(id)).setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		Pessoa pessoa = gson.fromJson(jsonResponse, Pessoa.class);
		return pessoa;
	}
	
	
	public List<Pessoa> listarPessoas() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/listarPessoas").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Pessoa[]>(){}.getType();

		Pessoa[] pessoas = gson.fromJson(jsonResponse, colletionType);
		List<Pessoa> lista = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			lista.add(pessoa);
		}
		return lista;
	}
	
	
	public static void main(String args[]){
		PessoaService service = new PessoaService();
		try {
			List<Pessoa> lista = service.listarPessoas();
//			Pessoa pessoa = service.recuperarPessoa(new Long(1));
			for (Pessoa pessoa: lista) {
				System.out.println("Pessoa:" + pessoa.getLogin() + " - " +  pessoa.getSenha());
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}

	}
	
}
