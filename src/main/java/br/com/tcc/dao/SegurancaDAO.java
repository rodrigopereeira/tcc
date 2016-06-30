package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.Funcionario;

public class SegurancaDAO {
	
	public Funcionario autentica(String username, String password){
		
		String sql = "select * from funcionario where login = ? and senha = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			Funcionario funcionario = new Funcionario();
			
			while(rs.next()) {
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setTipoid(rs.getInt("tipoid"));
			}
			
			stmt.close(); 
			connection.close();
			
			return funcionario;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
