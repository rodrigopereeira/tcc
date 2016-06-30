package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.Administrador;
import br.com.tcc.model.CNH;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Telefone;

public class AdministradorDAO {
	
	public void cadastra(Administrador administrador){
		
		String sql = "insert into funcionario(nome, sobrenome, rg, cpf, dataNascimento, email, estadoCivil, sexo, tipoid, "
				+ "login, senha, telefoneid, contatoid) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getSobrenome());
			stmt.setString(3, administrador.getRg());
			stmt.setString(4, administrador.getCpf());
			stmt.setTimestamp(5, Data.retornaData(administrador.getDataNascimento()));
			stmt.setString(6, administrador.getEmail());
			stmt.setString(7, administrador.getEstadoCivil());
			stmt.setString(8, administrador.getSexo());
			stmt.setInt(9, administrador.getTipoid());
			stmt.setString(10, administrador.getLogin());
			stmt.setString(11, administrador.getSenha());
			stmt.setInt(12, administrador.getTelefone().getId());
			stmt.setInt(13, administrador.getContato().getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Administrador administrador) {
		String sql = "update funcionario set nome=?, sobrenome=?, rg=?, cpf=?, dataNascimento=?, email=?, estadoCivil=?, "
				+ "sexo=?, tipoid=?, login=?, senha=?, telefoneid=?, contatoid=? where id=?";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, administrador.getNome());
			stmt.setString(2, administrador.getSobrenome());
			stmt.setString(3, administrador.getRg());
			stmt.setString(4, administrador.getCpf());
			stmt.setTimestamp(5, Data.retornaData(administrador.getDataNascimento()));
			stmt.setString(6, administrador.getEmail());
			stmt.setString(7, administrador.getEstadoCivil());
			stmt.setString(8, administrador.getSexo());
			stmt.setInt(9, administrador.getTipoid());
			stmt.setString(10, administrador.getLogin());
			stmt.setString(11, administrador.getSenha());
			stmt.setInt(12, administrador.getTelefone().getId());
			stmt.setInt(13, administrador.getContato().getId());
			stmt.setInt(14, administrador.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Administrador visualiza(int id) {
		
		String sql = "select f.id, f.nome, f.sobrenome, f.sexo, f.datanascimento, "
				+ "f.rg, f.cpf, f.email, f.estadocivil, f.setor, f.tipoid, f.cnhid, f.contatoid, f.telefoneid, f.login, f.senha "
				+ "from funcionario f "
				+ "where f.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Administrador administrador = new Administrador();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				administrador.setId(rs.getInt("id"));
				administrador.setNome(rs.getString("nome"));
				administrador.setSobrenome(rs.getString("sobrenome"));
				administrador.setSexo(rs.getString("sexo"));
				administrador.setDataNascimento(rs.getTimestamp("datanascimento"));
				administrador.setRg(rs.getString("rg"));
				administrador.setCpf(rs.getString("cpf"));
				administrador.setEmail(rs.getString("email"));
				administrador.setEstadoCivil(rs.getString("estadocivil"));
				administrador.setSetor(rs.getString("setor"));
				administrador.setTipoid(rs.getInt("tipoid"));
				administrador.setLogin(rs.getString("login"));
				administrador.setSenha(rs.getString("senha"));
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("telefoneid"));
				
				CNH cnh = new CNH();
				cnh.setId(rs.getInt("cnhid"));
				
				Contato contato = new Contato();
				contato.setId(rs.getInt("contatoid"));
				
				administrador.setTelefone(telefone);
				administrador.setContato(contato);
				
			}
			stmt.close(); 
			connection.close();
			
			return administrador;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
