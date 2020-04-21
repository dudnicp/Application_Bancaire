package aux;

public class InvalidPasswordException extends CustomException {
	
	private static final long serialVersionUID = 2100924914047407232L;
	
	public InvalidPasswordException(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}

	public InvalidPasswordException() {
		super("Code secret invalide");
	}
	
}
