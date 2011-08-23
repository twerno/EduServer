package net.twerno.eduserver.user.exceptions;

public class UserExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserExistsException(String msg) {
		super(msg);
	}

}
