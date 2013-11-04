package br.ufc.quixada.predemanda.exception;

public class BusinessLogicException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessLogicException() {}
	
	public BusinessLogicException(String msg) {
		super(msg);
	}
	
}