package model;

public class CardTransaction extends TransactionType{
	private Card associatedCard;
	
	public CardTransaction(Card card) {
		this.associatedCard = card;
	}

	@Override
	public String info() {
		return "PAYEMENT PAR CARTE " + associatedCard.getShortNumber();
	}
}
