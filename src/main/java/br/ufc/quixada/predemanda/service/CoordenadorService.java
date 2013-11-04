package br.ufc.quixada.predemanda.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.predemanda.exception.ConnectionException;
import br.ufc.quixada.predemanda.model.Coordenador;
import br.ufc.quixada.predemanda.util.ConfigReader;
import br.ufc.quixada.predemanda.util.URLRequestUtil;
import br.ufc.quixada.predemanda.util.URLRequestUtil.TypeRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CoordenadorService {

	private static final String URL_SERVICE = ConfigReader.getProperty("url_service") + "/coordenadores";
	
	public Coordenador recuperarCoordenador() throws ConnectionException{
		URLRequestUtil requestUtil = new URLRequestUtil();
		requestUtil.setURL(URL_SERVICE + "/recuperarCoordenador").setTypeRequest(TypeRequest.POST);
		
		String jsonResponse = requestUtil.execute();
		
		Gson gson = new Gson();

		Coordenador coordenador = gson.fromJson(jsonResponse, Coordenador.class);
		return coordenador;
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
	
	
	public static void main(String args[]){
		CoordenadorService service = new CoordenadorService();
		try {
			List<Coordenador> coordenadores = service.listarCoordenadores();
			for (Coordenador coordenador : coordenadores) {
				System.out.println("Coordenador:" +  coordenador.getSiape());
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}

	}
}
