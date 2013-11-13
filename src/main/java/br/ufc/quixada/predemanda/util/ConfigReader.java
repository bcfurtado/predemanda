package br.ufc.quixada.predemanda.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigReader {

	private static Logger logger = Logger.getLogger(ConfigReader.class);
	private static Properties config;

	static {
		config = new Properties();
		try {
			config.load( (ConfigReader.class).getResourceAsStream("/config.properties") );
		} catch (FileNotFoundException e) {
			logger.error("Arquivo não encontrado",e);
		} catch (IOException e) {
			logger.error("IOException",e);
		}
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}
}
