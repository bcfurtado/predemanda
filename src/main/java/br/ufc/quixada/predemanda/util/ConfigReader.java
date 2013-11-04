package br.ufc.quixada.predemanda.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties config;

	static {
		config = new Properties();
		try {
			config.load( (ConfigReader.class).getResourceAsStream("/config.properties") );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return config.getProperty(key);
	}
}
