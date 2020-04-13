package aux;

public class NonMatchingEntriesException extends CustomException {

	private static final long serialVersionUID = 7673892101296548755L;

	public NonMatchingEntriesException(String str) {
		super(str);
	}
	
	public NonMatchingEntriesException() {
		super("Les deux entrées ne correspondent pas.");
	}

}
