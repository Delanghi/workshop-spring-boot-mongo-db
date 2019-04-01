package com.dl.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeParam(String text) {						// o MÉTODO decodeParam retorna decodificado ou retorna vazio
		try {															
			return URLDecoder.decode(text, "UTF-8");					// qual texto a ser decodificado; qual MÉTODO da decodificação
		} 																// "UTF-8" é padrão de decodificação da Web
		catch (UnsupportedEncodingException e) {						
			return "";													// caso tenha algum ERRO, o retorno é "vazio"
		}
	}	
}