package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
