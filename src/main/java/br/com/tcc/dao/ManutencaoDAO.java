package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Fornecedor;
import br.com.tcc.model.Manutencao;
import br.com.tcc.model.Pagamento;
import br.com.tcc.model.Veiculo;

public class ManutencaoDAO {
	
	public void cadastra(Manutencao manutencao){
		
		String sql = "insert into manutencao(data, veiculoid, fornecedorid, pagamentoid, status, tipoid, problema, parecerfinal) values (?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(manutencao.getData()));
			stmt.setInt(2, manutencao.getVeiculo().getId());
			stmt.setInt(3, manutencao.getFornecedor().getId());
			stmt.setInt(4, manutencao.getPagamento().getId());
			stmt.setString(5, manutencao.getStatus());
			stmt.setInt(6, manutencao.getTipoid());
			stmt.setString(7, manutencao.getProblema());
			stmt.setString(8, manutencao.getParecerFinal());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Manutencao manutencao) {
	
		String sql = "update manutencao set data=?, veiculoid=?, fornecedorid=?, status=?, tipoid=?, problema=?, parecerfinal=? where id=?";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(manutencao.getData()));
			stmt.setInt(2, manutencao.getVeiculo().getId());
			stmt.setInt(3, manutencao.getFornecedor().getId());
			stmt.setString(4, manutencao.getStatus());
			stmt.setInt(5, manutencao.getTipoid());
			stmt.setString(6, manutencao.getProblema());
			stmt.setString(7, manutencao.getParecerFinal());
			stmt.setInt(8, manutencao.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Manutencao> listaManutencoes() {
		
		String sql = "select m.id, m.data, v.modelo, p.valor, t.descricao, m.status, f.nomefantasia, m.problema  "
				+ "from manutencao m "
				+ "left join veiculo v on m.veiculoid = v.id "
				+ "left join pagamento p on m.pagamentoid = p.id "
				+ "left join tipomanutencao t on m.tipoid = t.id "
				+ "left join fornecedor f on m.fornecedorid = f.id "
				+ "order by m.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Manutencao> listaManutencoes = new ArrayList<Manutencao>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Manutencao manutencao = new Manutencao();
				
				manutencao.setId(rs.getInt("id"));
				manutencao.setData(rs.getTimestamp("data"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(rs.getString("modelo"));
				manutencao.setVeiculo(veiculo);
				
				Pagamento pagamento = new Pagamento();
				pagamento.setValor(rs.getDouble("valor"));
				manutencao.setPagamento(pagamento);
				
				manutencao.setStatus(rs.getString("status"));
				manutencao.setTipoManutencao(rs.getString("descricao"));
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNomeFantasia(rs.getString("nomefantasia"));
				manutencao.setFornecedor(fornecedor);
				
				manutencao.setProblema(rs.getString("problema"));
				listaManutencoes.add(manutencao);
			}
			stmt.close(); 
			connection.close();
			
			return listaManutencoes;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Manutencao visualiza(int id) {
		
		String sql = "select id, data, veiculoid, fornecedorid, pagamentoid, status, tipoid, problema, parecerfinal "
				+ "from manutencao f "
				+ "where f.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Manutencao manutencao = new Manutencao();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				manutencao.setId(rs.getInt("id"));
				manutencao.setData(rs.getTimestamp("data"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				manutencao.setVeiculo(veiculo);
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("fornecedorid"));
				manutencao.setFornecedor(fornecedor);
				
				Pagamento pagamento = new Pagamento();
				pagamento.setId(rs.getInt("pagamentoid"));
				manutencao.setPagamento(pagamento);
				
				manutencao.setStatus(rs.getString("status"));
				manutencao.setTipoid(rs.getInt("tipoid"));
				manutencao.setProblema(rs.getString("problema"));
				manutencao.setParecerFinal(rs.getString("parecerfinal"));
			}
			stmt.close(); 
			connection.close();
			
			return manutencao;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void deleta(int id) {
		String sql = "delete from manutencao where id = ?";
		
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
