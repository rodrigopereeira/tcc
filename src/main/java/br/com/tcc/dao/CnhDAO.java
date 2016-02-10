package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.CNH;

public class CnhDAO {
	
	public CNH cadastra(CNH cnh){
		
		String sql = "insert into cnh(numero, validade, categoria) values (?,?,?) returning id;";
		

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, cnh.getNumero());
			stmt.setTimestamp(2, Data.retornaData(cnh.getValidade()));
			stmt.setString(3, cnh.getCategoria());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				cnh.setId(rs.getInt("id"));
			}
			
			stmt.close(); 
			connection.close();
			
			return cnh;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public CNH visualiza(CNH cnh) {
		
		String sql = "select numero, validade, categoria from cnh where id = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, cnh.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				cnh.setNumero(rs.getInt("numero"));
				cnh.setValidade(rs.getTimestamp("validade"));
				cnh.setCategoria(rs.getString("categoria"));
			}
			
			stmt.close(); 
			connection.close();
			
			return cnh;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
