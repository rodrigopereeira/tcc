package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.tcc.model.Agenda;
import br.com.tcc.model.Despesa;
import br.com.tcc.model.HistoricoVeiculo;
import br.com.tcc.model.Km;
import br.com.tcc.model.Motorista;
import br.com.tcc.model.Veiculo;

public class VeiculoDAO {
	
	public void cadastra(Veiculo veiculo){
		
		String sql = "insert into veiculo(placa, modelo, ano, chassi, renavam, marca, cor, combustivel, km, "
				+ "valor, ultimatrocapneu, mesipva) values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getChassi());
			stmt.setString(5, veiculo.getRenavam());
			stmt.setString(6, veiculo.getMarca());
			stmt.setString(7, veiculo.getCor());
			stmt.setString(8, veiculo.getCombustivel());
			stmt.setDouble(9, veiculo.getKm());
			stmt.setDouble(10, veiculo.getValor());
			stmt.setTimestamp(11, Data.retornaData(veiculo.getUltimaTrocaPneu()));
			stmt.setInt(12, veiculo.getMesIpva());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Veiculo> listaVeiculos() {
		
		String sql = "select * from veiculo "
				+ "order by id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				
				veiculo.setId(rs.getInt("id"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setChassi(rs.getString("chassi"));
				veiculo.setRenavam(rs.getString("renavam"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setCombustivel(rs.getString("combustivel"));
				veiculo.setKm(rs.getInt("km"));
				veiculo.setValor(rs.getDouble("valor"));
				veiculo.setUltimaTrocaPneu(rs.getTimestamp("ultimatrocapneu"));
				veiculo.setMesIpva(rs.getInt("mesipva"));
				
				listaVeiculos.add(veiculo);
			}
			stmt.close(); 
			connection.close();
			
			return listaVeiculos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Veiculo visualiza(int id) {
		String sql = "select * from veiculo where id=?";
		
		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Veiculo veiculo = new Veiculo();
			
			while (rs.next()) {
				veiculo.setId(rs.getInt("id"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setChassi(rs.getString("chassi"));
				veiculo.setRenavam(rs.getString("renavam"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setCombustivel(rs.getString("combustivel"));
				veiculo.setKm(rs.getInt("km"));
				veiculo.setValor(rs.getDouble("valor"));
				veiculo.setUltimaTrocaPneu(rs.getTimestamp("ultimatrocapneu"));
				veiculo.setMesIpva(rs.getInt("mesipva"));
				
				veiculo.setHistorico(listaHistorico(rs.getInt("id")));
				veiculo.setAgenda(listaAgenda(rs.getInt("id")));
			}
			stmt.close(); 
			connection.close();
			
			return veiculo;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from veiculo where id=?";
		
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

	public void altera(Veiculo veiculo) {
		String sql = "update veiculo set placa=?, modelo=?, ano=?, chassi=?, renavam=?, marca=?, cor=?, "
				+ "combustivel=?, km=?, valor=?, ultimatrocapneu=?, mesipva=? where id=?";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAno());
			stmt.setString(4, veiculo.getChassi());
			stmt.setString(5, veiculo.getRenavam());
			stmt.setString(6, veiculo.getMarca());
			stmt.setString(7, veiculo.getCor());
			stmt.setString(8, veiculo.getCombustivel());
			stmt.setDouble(9, veiculo.getKm());
			stmt.setDouble(10, veiculo.getValor());
			stmt.setTimestamp(11, Data.retornaData(veiculo.getUltimaTrocaPneu()));
			stmt.setInt(12, veiculo.getMesIpva());
			stmt.setInt(13, veiculo.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void atualizaKm(int veiculoid, double km) {
		String sql = "update veiculo set km=? where id=?";

		try (Connection connection = Conexao.getConexao()) {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDouble(1, km);
			stmt.setInt(2, veiculoid);
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void cadastraAcao(Veiculo veiculo, int acaoid){
				
		String sql = "insert into historico_veiculo(veiculoid, acaoid, data) values (?,?,now())";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, veiculo.getId());
			stmt.setInt(2, acaoid);
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<HistoricoVeiculo> listaHistorico(int veiculoid) {
		
		String sql = "select a.descricao acao, hv.data "
				+ "from historico_veiculo hv "
				+ "left join acoes a on hv.acaoid = a.id "
				+ "where hv.veiculoid = ? "
				+ "limit 15";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<HistoricoVeiculo> listaHistorico = new ArrayList<HistoricoVeiculo>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, veiculoid);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				HistoricoVeiculo historico = new HistoricoVeiculo();
				
				historico.setAcao(rs.getString("acao"));
				historico.setData(rs.getTimestamp("data"));
				listaHistorico.add(historico);
			}
			
			stmt.close(); 
			connection.close();
			
			return listaHistorico;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Agenda> listaAgenda(int veiculoid) {
		
		String sql = "select data, hora,  v.modelo, t.descricao tipo, a.descricao "
				+ "from agenda a "
				+ "left join veiculo v on a.veiculoid = v.id "
				+ "left join tipoagenda t on a.tipoid = t.id "
				+ "left join fornecedor f on a.fornecedorid = f.id "
				+ "where a.veiculoid = ? "
				+ "limit 15";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Agenda> listaAgenda = new ArrayList<Agenda>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, veiculoid);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Agenda agenda = new Agenda();
				agenda.setData(rs.getTimestamp("data"));
				agenda.setHora(rs.getTimestamp("hora"));
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(rs.getString("modelo"));
				agenda.setVeiculo(veiculo);
				
				agenda.setTipo(rs.getString("tipo"));
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

	public boolean chegaKmMaior(int id, double kmAtual) {
		String sql = "select km from veiculo where id=?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			boolean result = false;
			
			while (rs.next()) {
				double km = rs.getDouble("km");
				
				if (kmAtual > km ) {
					result = true;
				} else {
					System.out.println("É menor");
				}
			}
			stmt.close(); 
			connection.close();
			return result;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public double kmPercorrido(int veiculoid, Date dataInicial, Date dataFinal) {

		String sql = "select max(kmAtual) - min(kmAnterior) as totalpercorrido from km "
				+ "where veiculoid = ? "
				+ "and datasaida BETWEEN ? AND ? ";
		
		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, veiculoid);
			stmt.setTimestamp(2, Data.retornaData(dataInicial));
			stmt.setTimestamp(3, Data.retornaData(dataFinal));

			ResultSet rs = stmt.executeQuery();
			
			double total = 0;
			while (rs.next()) {
				total = rs.getDouble("totalpercorrido");
			}
			
			stmt.close(); 
			connection.close();
			
			return total;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public double combustivelUtilizado(int veiculoid, Date dataInicial, Date dataFinal) {

		String sql = "select sum(litros) totallitros from abastecimento "
				+ "where veiculoid = ? "
				+ "and data BETWEEN ? AND ? ";
		
		try (Connection connection = Conexao.getConexao()) {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, veiculoid);
			stmt.setTimestamp(2, Data.retornaData(dataInicial));
			stmt.setTimestamp(3, Data.retornaData(dataFinal));

			ResultSet rs = stmt.executeQuery();
			
			double total = 0;
			while (rs.next()) {
				total = rs.getDouble("totallitros");
			}
			stmt.close(); 
			connection.close();
			
			return total;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Km> listaKms(int veiculoid, Date dataInicial, Date dataFinal) {
		
		String sql = "select k.id, m.nome, k.kmanterior, k.kmatual, k.datasaida, k.horasaida, "
				+ "k.datachegada, k.horachegada, k.destino "
				+ "from km k "
				+ "left join funcionario m on k.motoristaid = m.id "
				+ "where veiculoid = ? and datasaida BETWEEN ? AND ?"
				+ "order by k.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Km> listaKms = new ArrayList<Km>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, veiculoid);
			stmt.setTimestamp(2, Data.retornaData(dataInicial));
			stmt.setTimestamp(3, Data.retornaData(dataFinal));
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Km km = new Km();
				km.setId(rs.getInt("id"));
				
				Motorista motorista = new Motorista();
				motorista.setNome(rs.getString("nome"));
				km.setMotorista(motorista);
				
				km.setKmAtual(rs.getDouble("kmatual"));
				km.setDataSaida(rs.getTimestamp("datasaida"));
				km.setHoraSaida(rs.getTimestamp("horaSaida"));
				km.setDataChegada(rs.getTimestamp("datachegada"));
				km.setHoraChegada(rs.getTimestamp("horaChegada"));
				km.setDestino(rs.getString("destino"));
				
				km.setKmPercorrida(rs.getDouble("kmatual") - rs.getDouble("kmanterior"));
				
				listaKms.add(km);
			}
			stmt.close(); 
			connection.close();
			
			return listaKms;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Despesa> listaDespesas(int veiculoid, Date dataInicial, Date dataFinal) {
		
		String sql = "select t.tipo, f.nome, p.valor, t.data "
				+ "from ("
				+ "select id, motoristaid, veiculoid, "
				+ "pagamentoid, data, 'Abastecimento' as Tipo from abastecimento where veiculoid = ? "
				+ "UNION "
				+ "select id, 0, veiculoid, pagamentoid, data, 'Manutenção' from manutencao where veiculoid = ? "
				+ "UNION "
				+ "select id, motoristaid, veiculoid, pagamentoid, data, 'Multa' from multa  where veiculoid = ? ) as t  "
				+ "left join funcionario f on t.motoristaid = f.id "
				+ "left join veiculo v on t.veiculoid = v.id "
				+ "left join pagamento p on t.pagamentoid = p.id "
				+ "where t.data BETWEEN ? AND ?"
				+ "order by tipo desc ";
				
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Despesa> listaDespesas = new ArrayList<Despesa>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, veiculoid);
			stmt.setInt(2, veiculoid);
			stmt.setInt(3, veiculoid);
			stmt.setTimestamp(4, Data.retornaData(dataInicial));
			stmt.setTimestamp(5, Data.retornaData(dataFinal));
			
			ResultSet rs = stmt.executeQuery();
			System.out.println(stmt);
			while (rs.next()) {
				Despesa despesa = new Despesa();
				
				despesa.setNome(rs.getString("nome"));
				despesa.setTipo(rs.getString("tipo"));
				despesa.setValor(rs.getDouble("valor"));
				despesa.setData(rs.getTimestamp("data"));
				
				listaDespesas.add(despesa);
			}
			stmt.close(); 
			connection.close();
			
			return listaDespesas;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
