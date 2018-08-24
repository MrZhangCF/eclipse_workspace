package exception;

public class CustomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String expMessage;

	public CustomerException() {

	}

	public CustomerException(String msg) {
		this.expMessage = msg;
	}

	public String getExpMessage() {
		return expMessage;
	}

	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}

}
