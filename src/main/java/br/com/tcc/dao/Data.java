package br.com.tcc.dao;

import java.util.Date;

public class Data {
	
	public static java.sql.Timestamp retornaData(Date data) {
		return new java.sql.Timestamp(data.getTime()); 
	}

}
