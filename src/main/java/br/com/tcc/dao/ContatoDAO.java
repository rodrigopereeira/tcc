package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.Contato;

public class ContatoDAO {

	public Contato cadastra(Contato contato) {

		String sql = "insert into contato(rua, numero, bairro, cidade, cep, estado) values (?,?,?,?,?,?) returning id;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getRua());
			stmt.setInt(2, contato.getNumero());
			stmt.setString(3, contato.getBairro());
			stmt.setString(4, contato.getCidade());
			stmt.setString(5, contato.getCep());
			stmt.setString(6, contato.getEstado());
			
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				contato.setId(rs.getInt("id"));
			}
			
			stmt.close(); 
			connection.close();
			
			return contato;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contato set rua=?, numero=?, bairro=?, cidade=?, cep=?, estado=? where id=?;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getRua());
			stmt.setInt(2, contato.getNumero());
			stmt.setString(3, contato.getBairro());
			stmt.setString(4, contato.getCidade());
			stmt.setString(5, contato.getCep());
			stmt.setString(6, contato.getEstado());
			stmt.setInt(7, contato.getId());

			stmt.execute();
			stmt.close(); 
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Contato visualiza(Contato contato) {

		String sql = "select rua, numero, bairro, cidade, cep, estado from contato where id = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, contato.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				contato.setRua(rs.getString("rua"));
				contato.setNumero(rs.getInt("numero"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setCep(rs.getString("cep"));
				contato.setEstado(rs.getString("estado"));
			}
			
			stmt.close(); 
			connection.close();
			
			return contato;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void deleta (int id) {
		String sql = "delete from contato where id=?";
		
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
