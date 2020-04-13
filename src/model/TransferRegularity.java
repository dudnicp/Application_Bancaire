package model;

public enum TransferRegularity {
	MONTHLY("Mensuel"),
	THREE_MONTHLY("Trimestriel"),
	BI_ANNUAL("Semestriel"),
	ANNUAL("Annuel");
	
	private String str;
	
	TransferRegularity(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
