package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Funcionario;

public class FuncionarioDAO {
	
	public List<Funcionario> listaFuncionarios() {
		
		String sql = "select f.id, f.nome, f.email, f.sexo, f.tipoid, tu.descricao tipousuario "
				+ "from funcionario f left join tipousuario tu on f.tipoid = tu.id "
				+ "order by f.id";
		
		try (Connection connection = Conexao.getConexao()) {
			
			List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setTipoid(rs.getInt("tipoid"));
				funcionario.setTipoUsuario(rs.getString("tipousuario"));
				listaFuncionarios.add(funcionario);
			}
			stmt.close(); 
			connection.close();
			
			return listaFuncionarios;
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (int id) {
		String sql = "delete from funcionario where id=?";
		
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
