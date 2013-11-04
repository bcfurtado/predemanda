package br.ufc.quixada.predemanda.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;

import br.ufc.quixada.predemanda.exception.ConnectionException;

/**
 * Um builder simples para requisições http.
 * @author Bruno Furtado
 */
public class URLRequestUtil {

	private String urlConnection;
	private TypeRequest typeRequest;

	private List<NameValuePair> parameters;

	public enum TypeRequest {
		POST, GET
	}

	public URLRequestUtil() {
		this.parameters = new ArrayList<NameValuePair>();
	}

	/**
	 * @param url para o acesso ao recurso
	 * @return URLRequestUtil
	 */
	public URLRequestUtil setURL(String url) {
		this.urlConnection = url;
		return this;
	}

	/**
	 * Tipo de requisição a ser realizado: GET ou POST
	 * @param typeRequest indica o tipo de requsição
	 * @return URLRequestUtil
	 */
	public URLRequestUtil setTypeRequest(TypeRequest typeRequest) {
		this.typeRequest = typeRequest;
		return this;
	}

	/**
	 * Parametros das requisições
	 * @param parameter indica os parametros das requisições
	 * @return URLRequestUtil
	 */
	public URLRequestUtil setParameters(NameValuePair parameter) {
		parameters.add(parameter);
		return this;
	}

	/**
	 * Executa a requisição
	 * 
	 * @return uma String com resultado da requisção
	 * @throws ConnectionException com a descrição do erro
	 */
	public String execute() throws ConnectionException {

		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlConnection);

			connection = (HttpURLConnection) url.openConnection();

			if (typeRequest == TypeRequest.POST) {
				connection.setRequestMethod("POST");
			} else {
				connection.setRequestMethod("GET");
			}
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			connection.setRequestProperty("Accept-Charset", "UTF-8");

			connection.setUseCaches(false);
			connection.setDoInput(true);

			if (!parameters.isEmpty()) {
				connection.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(connection.getOutputStream());
				out.writeBytes(getQuery(parameters));
				out.flush();
				out.close();

			}

			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

			String jsonResponse = "";
			if (jsonResponse != null) {
				jsonResponse = br.readLine();
			}
			br.close();
			connection.disconnect();

			return jsonResponse;
		} catch (MalformedURLException e) {
			throw new ConnectionException(e.getMessage());
		} catch (IOException e) {
			throw new ConnectionException(e.getMessage());
		}
	}

	/**
	 * http://stackoverflow.com/questions/9767952/how-to-add-parameters-to-httpurlconnection-using-post
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private String getQuery(List<NameValuePair> params)
			throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;

		for (NameValuePair pair : params) {
			if (first) {
				first = false;
			} else {
				result.append("&");
			}

			result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
		}

		return result.toString();
	}

}
