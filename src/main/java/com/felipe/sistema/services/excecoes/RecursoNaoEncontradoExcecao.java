package com.felipe.sistema.services.excecoes;

public class RecursoNaoEncontradoExcecao extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoExcecao(Object id) {
		super("Id " + id + " Nao Localizado.");
	}

}
