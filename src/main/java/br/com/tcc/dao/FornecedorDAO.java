package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Contato;
import br.com.tcc.model.Fornecedor;
import br.com.tcc.model.Telefone;

public class FornecedorDAO {
	
	public void cadastra(Fornecedor fornecedor){
		
		String sql = "insert into fornecedor(razaosocial, nomefantasia, cnpj, inscricaoestadual, email, tipoid, telefoneid, contatoid) "
				+ "values (?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, fornecedor.getRazaoSocial());
			stmt.setString(2, fornecedor.getNomeFantasia());
			stmt.setString(3, fornecedor.getCnpj());
			stmt.setString(4, fornecedor.getInscricaoEstadual());
			stmt.setString(5, fornecedor.getEmail());
			stmt.setInt(6, fornecedor.getTipoid());
			stmt.setInt(7, fornecedor.getTelefone().getId());
			stmt.setInt(8, fornecedor.getContato().getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Fornecedor> listaFornecedores() {
		
		String sql = "select f.id, f.razaosocial, f.nomefantasia, f.cnpj, f.inscricaoestadual, f.email, tf.descricao tipofornecedor "
				+ "from fornecedor f "
				+ "left join tipofornecedor tf on f.tipoid = tf.id "
				+ "order by f.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setRazaoSocial(rs.getString("razaosocial"));
				fornecedor.setNomeFantasia(rs.getString("nomefantasia"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setInscricaoEstadual(rs.getString("inscricaoestadual"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setTipoFornecedor(rs.getString("tipofornecedor"));

				listaFornecedores.add(fornecedor);
			}
			stmt.close(); 
			connection.close();
			
			return listaFornecedores;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Fornecedor visualiza(int id) {
		
		
		String sql = "select f.id, f.razaosocial, f.nomefantasia, f.cnpj, f.inscricaoestadual, f.email, f.tipoid, "
				+ "f.contatoid, f.telefoneid "
				+ "from fornecedor f "
				+ "where f.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Fornecedor fornecedor = new Fornecedor();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setRazaoSocial(rs.getString("razaosocial"));
				fornecedor.setNomeFantasia(rs.getString("nomefantasia"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setInscricaoEstadual(rs.getString("inscricaoestadual"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setTipoid(rs.getInt("tipoid"));
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("telefoneid"));
				
				Contato contato = new Contato();
				contato.setId(rs.getInt("contatoid"));
				
				fornecedor.setTelefone(telefone);
				fornecedor.setContato(contato);
				
			}
			stmt.close(); 
			connection.close();
			
			return fornecedor;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from fornecedor where id=?";
		
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

	public void altera(Fornecedor fornecedor) {
		String sql = "update fornecedor set razaosocial=?, nomefantasia=?, cnpj=?, inscricaoestadual=?, "
				+ "email=?, tipoid=?, telefoneid=?, contatoid=? where id=? ";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, fornecedor.getRazaoSocial());
			stmt.setString(2, fornecedor.getNomeFantasia());
			stmt.setString(3, fornecedor.getCnpj());
			stmt.setString(4, fornecedor.getInscricaoEstadual());
			stmt.setString(5, fornecedor.getEmail());
			stmt.setInt(6, fornecedor.getTipoid());
			stmt.setInt(7, fornecedor.getTelefone().getId());
			stmt.setInt(8, fornecedor.getContato().getId());
			stmt.setInt(9, fornecedor.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
