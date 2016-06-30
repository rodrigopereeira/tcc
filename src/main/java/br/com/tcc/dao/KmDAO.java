package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Km;
import br.com.tcc.model.Motorista;
import br.com.tcc.model.Veiculo;

public class KmDAO {
	
	public void cadastra(Km km){
		
		String sql = "insert into km(veiculoid, usuarioid, motoristaid, kmanterior, kmatual, datasaida, datachegada, "
				+ "horasaida, horachegada, destino) values (?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, km.getVeiculo().getId());
			//aqui tem q colocar os dados do usuário logado
			stmt.setInt(2, 1);
			stmt.setInt(3, km.getMotorista().getId());
			stmt.setDouble(4, km.getVeiculo().getKm());
			stmt.setDouble(5, km.getKmAtual());
			stmt.setTimestamp(6, Data.retornaData(km.getDataSaida()));
			stmt.setTimestamp(7, Data.retornaData(km.getDataChegada()));
			stmt.setTimestamp(8, Data.retornaData(km.getHoraSaida()));
			stmt.setTimestamp(9, Data.retornaData(km.getHoraChegada()));
			stmt.setString(10, km.getDestino());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Km km){
		String sql = "update km set motoristaid=?, kmatual=?, datasaida=?, datachegada=?, "
				+ "horasaida=?, horachegada=?, destino=? where id=?";

		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, km.getMotorista().getId());
			stmt.setDouble(2, km.getKmAtual());
			stmt.setTimestamp(3, Data.retornaData(km.getDataSaida()));
			stmt.setTimestamp(4, Data.retornaData(km.getDataChegada()));
			stmt.setTimestamp(5, Data.retornaData(km.getHoraSaida()));
			stmt.setTimestamp(6, Data.retornaData(km.getHoraChegada()));
			stmt.setString(7, km.getDestino());
			stmt.setInt(8, km.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Km> listaKms() {
		
		String sql = "select k.id, v.modelo, m.nome, k.kmanterior, k.kmatual, k.datasaida, "
				+ "k.datachegada, k.destino from km k "
				+ "left join veiculo v on k.veiculoid = v.id "
				+ "left join funcionario m on k.motoristaid = m.id "
				+ "order by k.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Km> listaKms = new ArrayList<Km>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Km km = new Km();
				km.setId(rs.getInt("id"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setKm(rs.getDouble("kmanterior"));
				km.setVeiculo(veiculo);
				
				Motorista motorista = new Motorista();
				motorista.setNome(rs.getString("nome"));
				km.setMotorista(motorista);
				
				km.setKmAtual(rs.getDouble("kmatual"));
				km.setDataSaida(rs.getTimestamp("datasaida"));
				km.setDataChegada(rs.getTimestamp("datachegada"));
				km.setDestino(rs.getString("destino"));
				
				listaKms.add(km);
			}
			stmt.close(); 
			connection.close();
			
			return listaKms;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Km visualiza(int id) {
		
		String sql = "select id, veiculoid, motoristaid, kmanterior, kmatual, "
				+ "datasaida, datachegada, horasaida, horachegada, destino "
				+ "from km k "
				+ "where k.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Km km = new Km();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				km.setId(rs.getInt("id"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setId(rs.getInt("veiculoid"));
				veiculo.setKm(rs.getDouble("kmanterior"));
				km.setVeiculo(veiculo);
				
				Motorista motorista = new Motorista();
				motorista.setId(rs.getInt("motoristaid"));
				km.setMotorista(motorista);
				
				km.setKmAtual(rs.getDouble("kmatual"));
				km.setDataSaida(rs.getTimestamp("datasaida"));
				km.setDataChegada(rs.getTimestamp("datachegada"));
				km.setHoraSaida(rs.getTimestamp("horasaida"));
				km.setHoraChegada(rs.getTimestamp("horachegada"));
				km.setDestino(rs.getString("destino"));
				
			}
			stmt.close(); 
			connection.close();
			
			return km;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta(int id) {
		String sql = "delete from km where id = ?";
		
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
