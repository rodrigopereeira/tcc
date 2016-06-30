package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Motorista;
import br.com.tcc.model.Multa;
import br.com.tcc.model.Pagamento;
import br.com.tcc.model.Veiculo;

public class MultaDAO {
	
	public void cadastra(Multa multa){
		
		String sql = "insert into multa(data, hora, veiculoid, datavencimento, pontuacao, "
				+ "motoristaid, status, descricao, pagamentoid) values (?,?,?,?,?,?,?,?,?)";

		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(multa.getData()));
			stmt.setTimestamp(2, Data.retornaData(multa.getHora()));
			stmt.setInt(3, multa.getVeiculo().getId());
			stmt.setTimestamp(4, Data.retornaData(multa.getDataVencimento()));
			stmt.setInt(5, multa.getPontuacao());
			stmt.setInt(6, multa.getMotorista().getId());
			stmt.setString(7, multa.getStatus());
			stmt.setString(8, multa.getDescricao());
			stmt.setInt(9, multa.getPagamento().getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Multa> listaMultas() {
		
		String sql = "select m.id, m.data, m.hora, v.modelo, mo.nome, p.valor, "
				+ "m.status, m.datavencimento, m.descricao "
				+ "from multa m "
				+ "left join veiculo v on m.veiculoid = v.id "
				+ "left join pagamento p on m.pagamentoid = p.id "
				+ "left join funcionario mo on m.motoristaid = mo.id "
				+ "order by m.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Multa> listaMultas = new ArrayList<Multa>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Multa multa = new Multa();
				multa.setId(rs.getInt("id"));
				multa.setData(rs.getTimestamp("data"));
				multa.setHora(rs.getTimestamp("hora"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(rs.getString("modelo"));
				multa.setVeiculo(veiculo);
				
				Motorista motorista = new Motorista();
				motorista.setNome(rs.getString("nome"));
				multa.setMotorista(motorista);
				
				Pagamento pagamento = new Pagamento();
				pagamento.setValor(rs.getDouble("valor"));
				multa.setPagamento(pagamento);
				
				multa.setStatus(rs.getString("status"));
				multa.setDataVencimento(rs.getTimestamp("datavencimento"));
				multa.setDescricao(rs.getString("descricao"));
				
				listaMultas.add(multa);
			}
			
			stmt.close(); 
			connection.close();
			
			return listaMultas;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Multa visualiza(int id) {
		String sql = "select id, data, hora, veiculoid, datavencimento, pontuacao, "
				+ "motoristaid, status, descricao, pagamentoid from multa where id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Multa multa = new Multa();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				multa.setId(rs.getInt("id"));
				multa.setData(rs.getTimestamp("data"));
				multa.setHora(rs.getTimestamp("hora"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				multa.setVeiculo(veiculo);
				
				multa.setDataVencimento(rs.getTimestamp("datavencimento"));
				multa.setPontuacao(rs.getInt("pontuacao"));
				
				Motorista motorista = new Motorista();
				motorista.setId(rs.getInt("motoristaid"));
				multa.setMotorista(motorista);
				
				multa.setStatus(rs.getString("status"));
				multa.setDescricao(rs.getString("descricao"));
				
				Pagamento pagamento = new Pagamento();
				pagamento.setId(rs.getInt("pagamentoid"));
				multa.setPagamento(pagamento);
			}
			stmt.close(); 
			connection.close();
			
			return multa;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void altera(Multa multa) {
		String sql = "update multa set data=?, hora=?, veiculoid=?, datavencimento=?, pontuacao=?, "
				+ "motoristaid=?, status=?, descricao=? where id=?";

		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(multa.getData()));
			stmt.setTimestamp(2, Data.retornaData(multa.getHora()));
			stmt.setInt(3, multa.getVeiculo().getId());
			stmt.setTimestamp(4, Data.retornaData(multa.getDataVencimento()));
			stmt.setInt(5, multa.getPontuacao());
			stmt.setInt(6, multa.getMotorista().getId());
			stmt.setString(7, multa.getStatus());
			stmt.setString(8, multa.getDescricao());
			stmt.setInt(9, multa.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta(int id) {
		String sql = "delete from multa where id = ?";
		
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
