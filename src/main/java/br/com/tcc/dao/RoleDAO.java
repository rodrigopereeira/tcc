package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAO {

	public void permissaoAdministrador (int id) {
		String sql = "insert into rolesfuncionario (funcionarioid, role) values (?, 'role_administrador')";
		
		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void permissaoMotorista (int id) {
		String sql = "insert into rolesfuncionario (funcionarioid, role) values (?, 'role_motorista')";
		
		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void permissaoUsuario (int id) {
		String sql = "insert into rolesfuncionario (funcionarioid, role) values (?, 'role_usuario')";
		
		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}