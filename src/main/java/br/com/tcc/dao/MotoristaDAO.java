package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.CNH;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Motorista;
import br.com.tcc.model.Telefone;

public class MotoristaDAO {
	
	public void cadastra(Motorista motorista){
		
		String sql = "insert into funcionario(nome, sobrenome, rg, cpf, dataNascimento, email, estadoCivil, sexo, tipoid, "
				+ "cnhid, telefoneid, contatoid) values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getSobrenome());
			stmt.setString(3, motorista.getRg());
			stmt.setString(4, motorista.getCpf());
			stmt.setTimestamp(5, Data.retornaData(motorista.getDataNascimento()));
			stmt.setString(6, motorista.getEmail());
			stmt.setString(7, motorista.getEstadoCivil());
			stmt.setString(8, motorista.getSexo());
			stmt.setInt(9, motorista.getTipoid());
			stmt.setInt(10, motorista.getCnh().getId());
			stmt.setInt(11, motorista.getTelefone().getId());
			stmt.setInt(12, motorista.getContato().getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Motorista> listaMotoristas() {
		
		String sql = "select f.id, f.nome, f.email, f.sexo, f.tipoid, tu.descricao tipousuario "
				+ "from funcionario f left join tipousuario tu on f.tipoid = tu.id "
				+ "where tipoid = 2";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Motorista> listaMotoristas = new ArrayList<Motorista>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Motorista motorista = new Motorista();
				motorista.setId(rs.getInt("id"));
				motorista.setNome(rs.getString("nome"));
				motorista.setEmail(rs.getString("email"));
				motorista.setSexo(rs.getString("sexo"));
				motorista.setTipoid(rs.getInt("tipoid"));
				motorista.setTipoUsuario(rs.getString("tipousuario"));
				listaMotoristas.add(motorista);
			}
			stmt.close(); 
			connection.close();
			
			return listaMotoristas;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Motorista visualiza(int id) {
		
		String sql = "select f.id, f.nome, f.sobrenome, f.sexo, f.datanascimento, "
				+ "f.rg, f.cpf, f.email, f.estadocivil, f.setor, f.tipoid, f.cnhid, f.contatoid, f.telefoneid "
				+ "from funcionario f "
				+ "where f.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Motorista motorista = new Motorista();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				motorista.setId(rs.getInt("id"));
				motorista.setNome(rs.getString("nome"));
				motorista.setSobrenome(rs.getString("sobrenome"));
				motorista.setSexo(rs.getString("sexo"));
				motorista.setDataNascimento(rs.getTimestamp("datanascimento"));
				motorista.setRg(rs.getString("rg"));
				motorista.setCpf(rs.getString("cpf"));
				motorista.setEmail(rs.getString("email"));
				motorista.setEstadoCivil(rs.getString("estadocivil"));
				motorista.setSetor(rs.getString("setor"));
				motorista.setTipoid(rs.getInt("tipoid"));
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("telefoneid"));
				
				CNH cnh = new CNH();
				cnh.setId(rs.getInt("cnhid"));
				
				Contato contato = new Contato();
				contato.setId(rs.getInt("contatoid"));
				
				motorista.setTelefone(telefone);
				motorista.setCnh(cnh);
				motorista.setContato(contato);
				
			}
			stmt.close(); 
			connection.close();
			
			return motorista;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
