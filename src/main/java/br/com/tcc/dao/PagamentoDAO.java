package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.Pagamento;

public class PagamentoDAO {
	
	public Pagamento cadastra(Pagamento pagamento){
		
		String sql = "insert into pagamento(valor, tipo, data) values (?,?,?) returning id;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDouble(1, pagamento.getValor());
			stmt.setString(2, pagamento.getTipo());
			stmt.setTimestamp(3, Data.retornaData(pagamento.getData()));
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				pagamento.setId(rs.getInt("id"));
			}
			
			stmt.close(); 
			connection.close();
			
			return pagamento;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Pagamento pagamento) {
		String sql = "update pagamento set valor=?, tipo=?, data=? where id=?;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDouble(1, pagamento.getValor());
			stmt.setString(2, pagamento.getTipo());
			stmt.setTimestamp(3, Data.retornaData(pagamento.getData()));
			stmt.setInt(4, pagamento.getId());
			
			
			stmt.execute();
			stmt.close(); 
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}


	public Pagamento visualiza(int id) {
		
		String sql = "select id, valor, tipo, data from pagamento where id = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Pagamento pagamento = new Pagamento();
			
			while(rs.next()) {
				pagamento.setId(rs.getInt("id"));
				pagamento.setValor(rs.getDouble("valor"));
				pagamento.setTipo(rs.getString("tipo"));
				pagamento.setData(rs.getTimestamp("data"));
			}
			
			stmt.close(); 
			connection.close();
			
			return pagamento;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from pagamento where id=?";
		
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
