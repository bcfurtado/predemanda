package br.ufc.quixada.predemanda.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Date.class)
public class DataConverter implements Converter<Date>{

	@Override
	public Date convert(String value, Class<? extends Date> type, ResourceBundle bundle) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date data = simpleDateFormat.parse(value);
			return data;
		} catch (ParseException e) {
			return null;
		}
	}

}
