package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Agenda;
import br.com.tcc.model.Fornecedor;
import br.com.tcc.model.Veiculo;

public class AgendaDAO {
	
	public void cadastra(Agenda agenda){
		
		String sql = "insert into agenda(data, hora, veiculoid, tipoid, local, fornecedorid, descricao) "
				+ "values (?,?,?,?,?,?,?)";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setTimestamp(1, Data.retornaData(agenda.getData()));
			stmt.setTimestamp(2, Data.retornaData(agenda.getHora()));
			stmt.setInt(3, agenda.getVeiculo().getId());
			stmt.setInt(4, agenda.getTipoid());
			stmt.setString(5, agenda.getLocal());
			stmt.setInt(6, agenda.getFornecedor().getId());
			stmt.setString(7, agenda.getDescricao());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Agenda> listaAgenda() {
		
		String sql = "select a.id, data, hora, veiculoid, v.modelo, a.tipoid, t.descricao tipo, local, "
				+ "fornecedorid, f.nomefantasia, a.descricao  from agenda a "
				+ "left join veiculo v on a.veiculoid = v.id "
				+ "left join tipoagenda t on a.tipoid = t.id "
				+ "left join fornecedor f on a.fornecedorid = f.id "
				+ "order by a.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Agenda> listaAgenda = new ArrayList<Agenda>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Agenda agenda = new Agenda();
				agenda.setId(rs.getInt("id"));
				agenda.setData(rs.getTimestamp("data"));
				agenda.setHora(rs.getTimestamp("hora"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				veiculo.setModelo(rs.getString("modelo"));
				agenda.setVeiculo(veiculo);
				
				agenda.setTipoid(rs.getInt("tipoid"));
				agenda.setTipo(rs.getString("tipo"));
				agenda.setLocal(rs.getString("local"));
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("fornecedorid"));
				fornecedor.setNomeFantasia(rs.getString("nomefantasia"));
				agenda.setFornecedor(fornecedor);
				
				agenda.setDescricao(rs.getString("descricao"));

				listaAgenda.add(agenda);
			}
			stmt.close(); 
			connection.close();
			
			return listaAgenda;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Agenda visualiza(int id) {
		
		
		String sql = "select id, data, hora, veiculoid, tipoid, local, fornecedorid, descricao "
				+ "from agenda a "
				+ "where a.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Agenda agenda = new Agenda();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				agenda.setId(rs.getInt("id"));
				agenda.setData(rs.getTimestamp("data"));
				agenda.setHora(rs.getTimestamp("hora"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				agenda.setVeiculo(veiculo);
				
				agenda.setTipoid(rs.getInt("tipoid"));
				agenda.setLocal(rs.getString("local"));
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("fornecedorid"));
				agenda.setFornecedor(fornecedor);
				
				agenda.setDescricao(rs.getString("descricao"));
				
			}
			stmt.close(); 
			connection.close();
			
			return agenda;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from agenda where id=?";
		
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
	
	public void altera(Agenda agenda){
		
		String sql = "update agenda set data=?, hora=?, veiculoid=?, tipoid=?, local=?, fornecedorid=?, descricao=? "
				+ "where id=?";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setTimestamp(1, Data.retornaData(agenda.getData()));
			stmt.setTimestamp(2, Data.retornaData(agenda.getHora()));
			stmt.setInt(3, agenda.getVeiculo().getId());
			stmt.setInt(4, agenda.getTipoid());
			stmt.setString(5, agenda.getLocal());
			stmt.setInt(6, agenda.getFornecedor().getId());
			stmt.setString(7, agenda.getDescricao());
			stmt.setInt(8, agenda.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
