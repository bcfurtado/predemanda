package br.ufc.quixada.predemanda.exception;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DAOException() {}
	
	public DAOException(String msg) {
		super(msg);
	}
}
