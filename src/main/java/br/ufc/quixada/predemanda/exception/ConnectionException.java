package br.ufc.quixada.predemanda.exception;

public class ConnectionException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ConnectionException() {}
	
	public ConnectionException(String msg) {
		super(msg);
	}
	
	public ConnectionException(String msg, Throwable e){
		super(msg, e);
	}
}
