package aux;

public class MinimalBalanceUnderflowException extends CustomException {

	private static final long serialVersionUID = 6315304148008568374L;
	
	public MinimalBalanceUnderflowException(String str) {
		super(str);
	}
	
	public MinimalBalanceUnderflowException() {
		super("Impossible d'effectuer l'opération: sous-passemment du seuil minimal du compte éméteur");
	}
	

}
