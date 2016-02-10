package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public class Conexao {
	
	private static DataSource dataSource;

	@SuppressWarnings("static-access")
	public Conexao() {
	
		PGPoolingDataSource pool = new PGPoolingDataSource();
		
		pool.setDataSourceName("pool");
		pool.setServerName("localhost");
		pool.setDatabaseName("tcc");
		pool.setUser("postgres");
		pool.setPassword("xi95gfg8");
		pool.setMaxConnections(10);
		
		this.dataSource = pool;
	}
	
	public static Connection getConexao() throws SQLException {
		Connection connection = dataSource.getConnection();
		return connection;
		
	}
}
