package com.meusprojetos.livraria.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ErrorResponse> handleValidacao(RecursoNaoEncontradoException ex, HttpServletRequest request) {
		
		ErrorResponse response = new ErrorResponse();
			response.setTimestamp(LocalDateTime.now());
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setError("Recurso não encontrado");
			response.setMessage(ex.getMessage());
			response.setPath(request.getRequestURI());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(LivroIndisponivelException.class)
	public ResponseEntity<ErrorResponse> handleIndisponivel(LivroIndisponivelException ex, HttpServletRequest request) {

		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setError("Livro indisponível");
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(LivroJaDevolvidoException.class)
	public ResponseEntity<ErrorResponse> handleLivroJaDevolvido(LivroJaDevolvidoException ex, HttpServletRequest request) {

		ErrorResponse response = new ErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setError("Livro já devolvido");
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
