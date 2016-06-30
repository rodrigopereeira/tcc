package br.com.tcc.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class ErroAutenticacao implements AuthenticationFailureHandler{ 

	//metodo padrao do spring security, estou subscrevendo e retornando a url de erro
	@Override
    public void onAuthenticationFailure(HttpServletRequest request,
             HttpServletResponse response, AuthenticationException ae)
             throws IOException, ServletException {
         	// user contains required data
	
          //response.setStatus(401);
		response.sendRedirect("loginError");
          //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
          //response.setHeader("Location", "http://somewhere/");


	}

	
}
