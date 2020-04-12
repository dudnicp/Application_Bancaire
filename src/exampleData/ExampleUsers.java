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
		
		CurrentAccount compteVal = new CurrentAccount("001", "Compte1", val, new Date(), 100, 1000, 300, 0);
		CurrentAccount compteAlix = new CurrentAccount(compteVal);
		CurrentAccount compteAdrien = new CurrentAccount(compteAlix);

		val.addBeneficiary(compteAlix);
		alix.addBeneficiary(compteAdrien);
		adrien.addBeneficiary(compteVal);
		
		
		Transaction t1 = new Transaction(compteAlix, 5, new Date(), new OneTimeTransferTransaction());
		Transaction t2 = new Transaction(compteAdrien, 15, new Date(), new OneTimeTransferTransaction());
		Transaction t3 = new Transaction(compteVal, 50, new Date(), new OneTimeTransferTransaction());
		
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
		
		val.addPersonalAccount(compteVal);
		val.addPersonalAccount(new PELAccount("123", "MonPEL", val, new Date(), 4000, 5000));
		val.addPersonalAccount(new LivretAAccount("234", "Super Livret", val, new Date(), 400, 3000, 300, 200));
		for (int i = 0; i < 10; i++) {
			val.addPersonalAccount(new CurrentAccount(compteVal));
		}
		alix.addPersonalAccount(compteAlix);
		adrien.addPersonalAccount(compteAdrien);
		
		this.add(val);
		this.add(alix);
		this.add(adrien);
	}
}
