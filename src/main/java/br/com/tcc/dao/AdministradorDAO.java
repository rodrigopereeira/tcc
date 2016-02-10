package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.tcc.model.Administrador;

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

}
