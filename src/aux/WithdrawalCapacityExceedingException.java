package aux;

public class WithdrawalCapacityExceedingException extends CustomException{

	private static final long serialVersionUID = 2395459047113446381L;

	public WithdrawalCapacityExceedingException(String str) {
		super(str);
	}
	
	public WithdrawalCapacityExceedingException() {
		super("Dépassement de la capacité de payement");
	}
	
}
