package exampleData;
import java.util.Date;
import java.util.LinkedList;

import model.*;

public class ExampleUsers extends LinkedList<User>{

	private static final long serialVersionUID = -3057261316659943475L;

	public ExampleUsers() {
		User val = new User("", "", "Valérian", "Thomas", "Mr", 
				"valerian.thomas@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		User adrien = new User("", "", "Adrien", "Déplacé", "Mr", 
				"adrien.deplace@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		User alix = new User("", "", "Alix", "Brocoli", "Mr", 
				"alix.brocoli@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		
		CurrentAccount compteVal = new CurrentAccount("001", "Compte1", val, new Date(), 100, 1000, 0, 300);
		CurrentAccount compteAlix = new CurrentAccount(compteVal);
		CurrentAccount compteAdrien = new CurrentAccount(compteAlix);

		val.addPayee(compteAlix);
		alix.addPayee(compteAdrien);
		adrien.addPayee(compteVal);
		
		
		Transaction t1 = new Transaction(compteAlix, 5, new Date(), new OneTimeTransferTransaction());
		Transaction t2 = new Transaction(compteAdrien, 15, new Date(), new OneTimeTransferTransaction());
		Transaction t3 = new Transaction(compteVal, 50, new Date(), new OneTimeTransferTransaction());
		
		Card valCard = new Card(val, "3443", "1234234534564567");
		for (int i = 0; i < 10; i++) {
			compteVal.addCard(new Card(valCard));
		}
		
		compteVal.addPendingTransaction(t3);
		compteVal.addTransactionToHistory(t3);
		for (int i = 0; i < 10; i++) {
			compteVal.addPendingTransaction(new Transaction(t3));
			compteVal.addTransactionToHistory(new Transaction(t3));
		}
		compteAlix.addTransactionToHistory(t1);
		compteAlix.addPendingTransaction(t1);
		compteAdrien.addTransactionToHistory(t2);
		compteAdrien.addPendingTransaction(t2);
		
		val.addCurrentAccount(compteVal);
		val.addPelAccount(new PELAccount("123", "MonPEL", val, new Date(), 4000, 5000));
		val.addLivretAAccount(new LivretAAccount("234", "Super Livret", val, new Date(), 400, 3000, 200, 500));
		for (int i = 0; i < 10; i++) {
			val.addCurrentAccount(new CurrentAccount(compteVal));
		}
		alix.addCurrentAccount(compteAlix);
		adrien.addCurrentAccount(compteAdrien);
		
		this.add(val);
		this.add(alix);
		this.add(adrien);
	}
}
