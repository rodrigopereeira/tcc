package br.com.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DespesasDAO {

	public double totalAbastecimento() {

		String sql = "select sum(valor) total from abastecimento a " + "left join pagamento p "
				+ "on a.pagamentoid = p.id";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			double total = 0;
			while (rs.next()) {
				total = rs.getDouble("total");
			}
			stmt.close();
			connection.close();

			return total;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public double totalManutencao() {

		String sql = "select sum(valor) total from manutencao a " + "left join pagamento p "
				+ "on a.pagamentoid = p.id";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			double total = 0;
			while (rs.next()) {
				total = rs.getDouble("total");
			}
			stmt.close();
			connection.close();

			return total;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public double totalMulta() {

		String sql = "select sum(valor) total from multa a " + "left join pagamento p "
				+ "on a.pagamentoid = p.id";

		try (Connection connection = Conexao.getConexao()) {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			double total = 0;
			while (rs.next()) {
				total = rs.getDouble("total");
			}
			stmt.close();
			connection.close();

			return total;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
