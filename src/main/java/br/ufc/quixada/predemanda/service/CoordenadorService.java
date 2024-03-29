package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Coordenador;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class CoordenadorService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/coordenadores";
	
	public Coordenador recuperarCoordenador(Long id) throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarCoordenador/"+ Long.toString(id)).setTypeRequest(TypeRequest.POST);

		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		return gson.fromJson(jsonResponse, Coordenador.class);
	}
	
	public List<Coordenador> listarCoordenadores() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/listarCoordenadores").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();
		Type colletionType = new TypeToken<Coordenador[]>(){}.getType();

		Coordenador[] coordenadores = gson.fromJson(jsonResponse, colletionType);
		List<Coordenador> lista = new ArrayList<Coordenador>();
		for (Coordenador coordenador : coordenadores) {
			lista.add(coordenador);
		}
		return lista;
	}
	
}
