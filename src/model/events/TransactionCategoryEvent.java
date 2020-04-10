package model.events;

public class TransactionCategoryEvent extends Event {
	
	public static final int KNOWN_CATEGORY = 0;
	public static final int UNKNOWN_CATEGORY = 1;
	
	private String category;
	private int status;
	
	public TransactionCategoryEvent(String category, int status) {
		this.category = category;
		this.status = status;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getStatus() {
		return status;
	}
}
