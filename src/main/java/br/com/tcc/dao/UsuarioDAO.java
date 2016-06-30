package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tcc.model.CNH;
import br.com.tcc.model.Contato;
import br.com.tcc.model.Telefone;
import br.com.tcc.model.Usuario;

public class UsuarioDAO {
	
	public void cadastra(Usuario usuario){
		
		String sql = "insert into funcionario(nome, sobrenome, rg, cpf, dataNascimento, email, estadoCivil, sexo, tipoid, "
				+ "login, senha, telefoneid, contatoid) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getRg());
			stmt.setString(4, usuario.getCpf());
			stmt.setTimestamp(5, Data.retornaData(usuario.getDataNascimento()));
			stmt.setString(6, usuario.getEmail());
			stmt.setString(7, usuario.getEstadoCivil());
			stmt.setString(8, usuario.getSexo());
			stmt.setInt(9, usuario.getTipoid());
			stmt.setString(10, usuario.getLogin());
			stmt.setString(11, usuario.getSenha());
			stmt.setInt(12, usuario.getTelefone().getId());
			stmt.setInt(13, usuario.getContato().getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Usuario usuario) {

		String sql = "update funcionario set nome=?, sobrenome=?, rg=?, cpf=?, dataNascimento=?, email=?, estadoCivil=?, "
				+ "sexo=?, tipoid=?, login=?, senha=?, telefoneid=?, contatoid=? where id=?";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getRg());
			stmt.setString(4, usuario.getCpf());
			stmt.setTimestamp(5, Data.retornaData(usuario.getDataNascimento()));
			stmt.setString(6, usuario.getEmail());
			stmt.setString(7, usuario.getEstadoCivil());
			stmt.setString(8, usuario.getSexo());
			stmt.setInt(9, usuario.getTipoid());
			stmt.setString(10, usuario.getLogin());
			stmt.setString(11, usuario.getSenha());
			stmt.setInt(12, usuario.getTelefone().getId());
			stmt.setInt(13, usuario.getContato().getId());
			stmt.setInt(14, usuario.getId());
			
			stmt.execute();
			stmt.close(); 
			connection.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Usuario visualiza(int id) {
		
		String sql = "select f.id, f.nome, f.sobrenome, f.sexo, f.datanascimento, "
				+ "f.rg, f.cpf, f.email, f.estadocivil, f.setor, f.tipoid, f.cnhid, f.contatoid, f.telefoneid, f.login, f.senha "
				+ "from funcionario f "
				+ "where f.id = ?";
		
		try (Connection connection = Conexao.getConexao()) {
			
			Usuario usuario = new Usuario();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setDataNascimento(rs.getTimestamp("datanascimento"));
				usuario.setRg(rs.getString("rg"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEstadoCivil(rs.getString("estadocivil"));
				usuario.setSetor(rs.getString("setor"));
				usuario.setTipoid(rs.getInt("tipoid"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getInt("telefoneid"));
				
				CNH cnh = new CNH();
				cnh.setId(rs.getInt("cnhid"));
				
				Contato contato = new Contato();
				contato.setId(rs.getInt("contatoid"));
				
				usuario.setTelefone(telefone);
				usuario.setContato(contato);
				
			}
			stmt.close(); 
			connection.close();
			
			return usuario;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
