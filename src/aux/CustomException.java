package aux;


public class CustomException extends Exception {

	private static final long serialVersionUID = 7202402107472847966L;
	
	private String str;
	
	public CustomException(String str) {
		this.str = str;
	}
	
	public String getString() {
		return str;
	}
}
