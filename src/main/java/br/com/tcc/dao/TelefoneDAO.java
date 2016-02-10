package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.Telefone;

public class TelefoneDAO {

	public Telefone cadastra(Telefone telefone) {

		String sql = "insert into telefone(numero, ramal, observacoes) values (?,?,?) returning id;";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, telefone.getNumero());
			stmt.setInt(2, telefone.getRamal());
			stmt.setString(3, telefone.getObservacoes());
			
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				telefone.setId(rs.getInt("id"));
			}
			
			stmt.close(); 
			connection.close();
			
			return telefone;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Telefone visualiza(Telefone telefone) {

		String sql = "select numero, ramal, observacoes from telefone where id = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, telefone.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				telefone.setNumero(rs.getInt("numero"));
				telefone.setRamal(rs.getInt("ramal"));
				telefone.setObservacoes(rs.getString("observacoes"));
			}
			
			stmt.close(); 
			connection.close();
			
			return telefone;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	

}
