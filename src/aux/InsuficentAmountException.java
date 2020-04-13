package aux;

public class InsuficentAmountException extends CustomException {
	
	private static final long serialVersionUID = -1575517691158511L;

	public InsuficentAmountException(String str) {
		super(str);
	}
	
	public InsuficentAmountException() {
		super("Opération impossible: solde insuffisant.");
	}
	

}
