package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Curso;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class CursoService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/cursos";
	
	public Curso recuperarCurso(Long id) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarCurso/"+ Long.toString(id)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		return gson.fromJson(jsonResponse, Curso.class);
	}
	
	public Curso recuperarCursoDoCoordenador(Long idCoordenador) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarCursoDoCoordenador/"+ Long.toString(idCoordenador)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		return gson.fromJson(jsonResponse, Curso.class);
	}
	
	public Curso recuperarCursoDoAluno(Long idAluno) throws ConnectionException {
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarCursoDoAluno/"+ Long.toString(idAluno)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		return gson.fromJson(jsonResponse, Curso.class);
	}

	public List<Curso> listarCursos() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/listarCursos").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Curso[]>(){}.getType();

		Curso[] cursos = gson.fromJson(jsonResponse, colletionType);
		List<Curso> lista = new ArrayList<Curso>();
		for (Curso curso : cursos) {
			lista.add(curso);
		}
		return lista;
	}
	
}
