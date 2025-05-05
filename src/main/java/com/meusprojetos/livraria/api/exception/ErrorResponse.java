package com.meusprojetos.livraria.api.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
	
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
