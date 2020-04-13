package aux;

public class InvalidFormatException extends CustomException {
	
	public InvalidFormatException(String str) {
		super(str);
	}
	
	public InvalidFormatException() {
		super("Format invalide.");
	}

	private static final long serialVersionUID = 4626708028224656122L;
	
}
