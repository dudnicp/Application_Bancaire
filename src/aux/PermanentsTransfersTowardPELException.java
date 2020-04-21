package aux;

public class PermanentsTransfersTowardPELException extends CustomException {


	private static final long serialVersionUID = 1678916280280085608L;

	public PermanentsTransfersTowardPELException(String str) {
		super(str);
	}
	
	public PermanentsTransfersTowardPELException() {
		this("Impossible de cloturer le PEL : il y a des virements programmés en destination de ce compte. "
				+ "\nAnnulez les avant de clôturer le compte.");
	}
	
}
