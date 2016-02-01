package br.com.tcc.model;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Teste {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		Motorista usuario = new Motorista();
		usuario.setNome("Rodrigo");
		usuario.setSobrenome("Pereira");
		usuario.setRg("5.847.580");
		usuario.setCpf("080.206.579-16");
		usuario.setDataNascimento(new Date());
		usuario.setEmail("rodrigopereeira@outlook.com");
		usuario.setEstadoCivil("Solteiro");
		usuario.setSexo("Masc");
		usuario.setSetor("TI");
		
		Endereco endereco = new Endereco();
		endereco.setRua("Fides Deeke");
		endereco.setNumero(250);
		endereco.setTipo("AP");
		endereco.setBairro("Itoupava Seca");
		endereco.setCidade("Blumenau");
		endereco.setCep("89030210");
		endereco.setEstado("SC");
		usuario.setEndereco(endereco);
		
		Telefone telefone = new Telefone();
		telefone.setDdd(49);
		telefone.setNumero(88316949);
		telefone.setTipo("Celular");
		usuario.setTelefone(telefone);
		
		CNH cnh = new CNH();
		cnh.setNumero(1112223);
		cnh.setValidade(new Date());
		cnh.setCategoria("A");
		usuario.setCnh(cnh);
		
		String json = mapper.writeValueAsString(usuario);
		
		System.out.println(json);

	}

}
