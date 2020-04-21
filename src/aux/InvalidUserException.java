package aux;

public class InvalidUserException extends CustomException {
	private static final long serialVersionUID = 890130273637777461L;

	public InvalidUserException(String str) {
		super(str);
		// TODO Auto-generated constructor stub
	}
	public InvalidUserException() {
		super("Utilisateur inconnu.");
	}

}
