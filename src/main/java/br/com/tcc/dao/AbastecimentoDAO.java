package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Abastecimento;
import br.com.tcc.model.Fornecedor;
import br.com.tcc.model.Motorista;
import br.com.tcc.model.Pagamento;
import br.com.tcc.model.Veiculo;

public class AbastecimentoDAO {
	
	public Abastecimento cadastra(Abastecimento abastecimento){
		
		String sql = "insert into abastecimento(data, veiculoid, motoristaid, fornecedorid, tipoid, km, kmanterior, kmpercorrido, valorlitro, litros, pagamentoid) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?) returning id;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(abastecimento.getData()));
			stmt.setInt(2, abastecimento.getVeiculo().getId());
			stmt.setInt(3, abastecimento.getMotorista().getId());
			stmt.setInt(4, abastecimento.getFornecedor().getId());
			stmt.setInt(5, abastecimento.getTipoid());
			stmt.setDouble(6, abastecimento.getKm());
			stmt.setDouble(7, abastecimento.getKmAnterior());
			stmt.setDouble(8, abastecimento.getKmPercorrido());
			stmt.setDouble(9, abastecimento.getValorLitro());
			stmt.setDouble(10, abastecimento.getLitros());
			stmt.setInt(11, abastecimento.getPagamento().getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				abastecimento.setId(rs.getInt("id"));
			}
			
			stmt.close(); 
			connection.close();
			
			return abastecimento;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Abastecimento> listaAbastecimentos() {
		
		String sql = "select a.id, a.data, v.modelo, f.nome, t.descricao tipoCombustivel, p.valor, "
				+ "a.valorlitro, a.km, a.kmpercorrido, f2.nomefantasia "
				+ "from abastecimento a "
				+ "left join veiculo v on a.veiculoid = v.id "
				+ "left join funcionario f on a.motoristaid = f.id "
				+ "left join pagamento p on a.pagamentoid = p.id "
				+ "left join tipocombustivel t on a.tipoid = t.id "
				+ "left join fornecedor f2 on a.fornecedorid = f2.id "
				+ "order by a.id";

		try (Connection connection = Conexao.getConexao()) {
			
			List<Abastecimento> listaAbastecimentos = new ArrayList<Abastecimento>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Abastecimento abastecimento = new Abastecimento();
				abastecimento.setId(rs.getInt("id"));
				abastecimento.setData(rs.getTimestamp("data"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(rs.getString("modelo"));
				abastecimento.setVeiculo(veiculo);
				
				Motorista motorista = new Motorista();
				motorista.setNome(rs.getString("nome"));
				abastecimento.setMotorista(motorista);
				
				abastecimento.setTipoCombustivel(rs.getString("tipoCombustivel"));
				
				Pagamento pagamento = new Pagamento();
				pagamento.setValor(rs.getDouble("valor"));
				abastecimento.setPagamento(pagamento);
				
				abastecimento.setValorLitro(rs.getDouble("valorlitro"));
				abastecimento.setKm(rs.getDouble("km"));
				abastecimento.setKmPercorrido(rs.getDouble("kmpercorrido"));
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
				abastecimento.setFornecedor(fornecedor);
				
				listaAbastecimentos.add(abastecimento);
			}
			
			stmt.close(); 
			connection.close();
			
			return listaAbastecimentos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Abastecimento abastecimento) {
		String sql = "update abastecimento set data=?, veiculoid=?, motoristaid=?, fornecedorid=?, tipoid=?, "
				+ "km=?, kmanterior=?, kmpercorrido=?, valorlitro=?, litros=?, pagamentoid=? where id=?;";
		
		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setTimestamp(1, Data.retornaData(abastecimento.getData()));
			stmt.setInt(2, abastecimento.getVeiculo().getId());
			stmt.setInt(3, abastecimento.getMotorista().getId());
			stmt.setInt(4, abastecimento.getFornecedor().getId());
			stmt.setInt(5, abastecimento.getTipoid());
			stmt.setDouble(6, abastecimento.getKm());
			stmt.setDouble(7, abastecimento.getKmAnterior());
			stmt.setDouble(8, abastecimento.getKmPercorrido());
			stmt.setDouble(9, abastecimento.getValorLitro());
			stmt.setDouble(10, abastecimento.getLitros());
			stmt.setInt(11, abastecimento.getPagamento().getId());
			stmt.setInt(12, abastecimento.getId());
			
			stmt.execute();
			
			stmt.close(); 
			connection.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}


	public Abastecimento visualiza(int id) {
		
		String sql = "select id, data, veiculoid, motoristaid, fornecedorid, tipoid, "
				+ "km, kmanterior, kmpercorrido, valorlitro, litros, pagamentoid "
				+ "from abastecimento where id = ?";

		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Abastecimento abastecimento = new Abastecimento();
			
			while(rs.next()) {
				abastecimento.setId(rs.getInt("id"));
				abastecimento.setData(rs.getTimestamp("data"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				abastecimento.setVeiculo(veiculo);

				Motorista motorista = new Motorista();
				motorista.setId(rs.getInt("motoristaid"));
				abastecimento.setMotorista(motorista);
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("fornecedorid"));
				abastecimento.setFornecedor(fornecedor);
				
				abastecimento.setTipoid(rs.getInt("tipoid"));
				
				abastecimento.setKm(rs.getDouble("km"));
				abastecimento.setKmAnterior(rs.getDouble("kmanterior"));
				abastecimento.setKmPercorrido(rs.getDouble("kmpercorrido"));
				abastecimento.setValorLitro(rs.getDouble("valorlitro"));
				abastecimento.setLitros(rs.getDouble("litros"));
				
				Pagamento pagamento = new Pagamento();
				pagamento.setId(rs.getInt("pagamentoid"));
				abastecimento.setPagamento(pagamento);
			}
			
			stmt.close(); 
			connection.close();
			
			return abastecimento;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from abastecimento where id=?";
		
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
