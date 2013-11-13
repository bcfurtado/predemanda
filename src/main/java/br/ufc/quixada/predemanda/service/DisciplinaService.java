package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Disciplina;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DisciplinaService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/disciplinas";
	
	public Disciplina recuperarDisciplina(Long id) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarDisciplina/"+ Long.toString(id)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		return gson.fromJson(jsonResponse, Disciplina.class);
	}
	
	public List<Disciplina> listarDisciplinas() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/listarDisciplinas").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Disciplina[]>(){}.getType();

		Disciplina[] disciplinas = gson.fromJson(jsonResponse, colletionType);
		List<Disciplina> lista = new ArrayList<Disciplina>();
		for (Disciplina disciplina : disciplinas) {
			lista.add(disciplina);
		}
		return lista;
	}
	
}
