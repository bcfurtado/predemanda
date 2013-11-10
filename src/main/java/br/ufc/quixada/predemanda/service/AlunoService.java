package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Aluno;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class AlunoService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/alunos";
	
	public Aluno recuperarAluno(Long id) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarAluno/"+ Long.toString(id)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		Aluno aluno = gson.fromJson(jsonResponse, Aluno.class);
		return aluno;
	}
	
	public List<Aluno> listarAlunos() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/listarAlunos").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Aluno[]>(){}.getType();

		Aluno[] alunos = gson.fromJson(jsonResponse, colletionType);
		List<Aluno> lista = new ArrayList<Aluno>();
		for (Aluno aluno : alunos) {
			lista.add(aluno);
		}
		return lista;
	}
	
	public List<Aluno> recuperarAlunosDoCurso(Long idCurso) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarAlunosDoCurso/" + idCurso).setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Aluno[]>(){}.getType();

		Aluno[] alunos = gson.fromJson(jsonResponse, colletionType);
		List<Aluno> lista = new ArrayList<Aluno>();
		for (Aluno aluno : alunos) {
			lista.add(aluno);
		}
		return lista;
	}
	
	
	public static void main(String args[]){
		AlunoService service = new AlunoService();
		try {
			List<Aluno> alunos = service.listarAlunos();
			for (Aluno aluno : alunos) {
				System.out.println("Aluno:" + aluno.getMatricula());
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}

	}
}
