package com.felipe.sistema.resources.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipe.sistema.services.excecoes.BancoDadosExcecao;
import com.felipe.sistema.services.excecoes.RecursoNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RecursoExcecaoManipulada {

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErrorPadrao> recursoNaoEncontrado (RecursoNaoEncontradoExcecao e, HttpServletRequest request){
		String error = "Recurso nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorPadrao err = new ErrorPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(BancoDadosExcecao.class)
	public ResponseEntity<ErrorPadrao> bancoDados (BancoDadosExcecao e, HttpServletRequest request){
		String error = "Error no banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErrorPadrao err = new ErrorPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
}
