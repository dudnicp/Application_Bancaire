package aux;

public class WithdrawCapacityOverflowException extends CustomException{

	private static final long serialVersionUID = 2395459047113446381L;

	public WithdrawCapacityOverflowException(String str) {
		super(str);
	}
	
	public WithdrawCapacityOverflowException() {
		super("Impossible d'effectuer l'opération: dépassement de la capacité de payement");
	}
	
}
