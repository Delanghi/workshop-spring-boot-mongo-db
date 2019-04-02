package com.dl.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
	public static String decodeParam(String text) {							// o MÉTODO decodeParam retorna decodificado ou retorna vazio
		try {															
			return URLDecoder.decode(text, "UTF-8");						// qual texto a ser decodificado; qual MÉTODO da decodificação
		} 																	// "UTF-8" é padrão de decodificação da Web
		catch (UnsupportedEncodingException e) {						
			return "";														// caso tenha algum ERRO, o retorno é "vazio"
		}
	}	
	
 // MÉTODOS PARA TRATAR DATAS RECEBIDAS 
	public static Date convertDate(String textDate, Date defaultValue) {	// caso ocorra falha na conversão, será retornado valor padrão
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");			// formato para impressão da data solicitada
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));						// tipo-padrão de data/horário
		try {
			return sdf.parse(textDate);
		} 
		catch (ParseException e) {
			return defaultValue;											// caso ocorra ERRO, retornará um valor padrão
		}
	}
}