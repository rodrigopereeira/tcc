package br.com.tcc.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.tcc.dao.SegurancaDAO;
import br.com.tcc.model.Funcionario;

@Component
public class AutenticacaoPersonalizada implements AuthenticationProvider {

	
	SegurancaDAO daoSeguranca = new SegurancaDAO();
	List<GrantedAuthority> permissoes = new ArrayList<GrantedAuthority>();
	
	// subscrevendo um metodo padrao do spring para autenticacao
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// captura o usuario e senha digitados pelo usuario
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		
		Funcionario usuario = daoSeguranca.autentica(username, password);
		
		if (usuario.getId() == 0) {
			throw new BadCredentialsException("Wrong password.");
		}
		
		if (usuario.getTipoid() == 1) {
			permissoes.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if (usuario.getTipoid() == 2) {
			permissoes.add(new SimpleGrantedAuthority("ROLE_MOTORISTA"));
		} else if (usuario.getTipoid() == 3) {
			permissoes.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
		}
		
		Authentication auth = null;
		if (username == null) {
			throw new AuthenticationServiceException("Erro de autenticação tente novamente ou entre em contato com o administrador do sistema");
		} else {
			auth = new UsernamePasswordAuthenticationToken(usuario.getNome(), password, permissoes);
		}
		
		//retorna o objeto de autenticacao
		return auth;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
