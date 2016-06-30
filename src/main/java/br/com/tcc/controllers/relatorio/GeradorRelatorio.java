package br.com.tcc.controllers.relatorio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GeradorRelatorio {

	private String nomeArquivo;
	private Map<String, Object> parametros;
	private Object objeto;

	public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros, Object objeto) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.objeto = objeto;
	}

	public void geraPDFParaOutputStream(OutputStream outputStream) {

		List<Object> objetos = new ArrayList<Object>();
		objetos.add(objeto);

		JRDataSource dataSource = new JRBeanCollectionDataSource(objetos);

		try {
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, dataSource);

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();

		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

	public byte[] geraArrayBytes() {

		List<Object> objetos = new ArrayList<Object>();
		objetos.add(objeto);

		JRDataSource dataSource = new JRBeanCollectionDataSource(objetos);

		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, dataSource);
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

			byte[] exportReportToPdf = JasperExportManager.exportReportToPdf(jasperPrint);

			return exportReportToPdf;
			
			
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}

}