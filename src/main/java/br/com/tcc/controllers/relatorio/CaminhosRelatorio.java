package br.com.tcc.controllers.relatorio;

public class CaminhosRelatorio {
	
	public static String retornaCaminho(String nomeRelatorio) {
		
		switch(nomeRelatorio) {
		    case "consumoMedio":
		        return "WEB-INF/relatorios/consumoMedio.jasper";
		    case "distanciaPercorrida":
	            return "WEB-INF/relatorios/distanciaPercorrida.jasper";
		    case "despesa":
	            return "WEB-INF/relatorios/despesas.jasper";
		    default:
		}
		return "";
	}

}