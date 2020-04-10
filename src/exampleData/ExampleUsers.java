package exampleData;
import java.util.Date;
import java.util.LinkedList;

import model.*;

public class ExampleUsers extends LinkedList<User>{

	private static final long serialVersionUID = -3057261316659943475L;

	public ExampleUsers() {
		User val = new User("thomasva", "thomasva", "Valérian","THOMAS", "Duc");
		User alix = new User("bruckali", "nulenmath", "Alix","BRUCKERT", "Princesse");
		User adrien = new User("delepla", "vener", "Adrien","DELEPLACE", "Dauphin");
		
		PersonalAccount compteVal = new PersonalAccount("001", "001", AccountType.COMPTE_COURRANT, 100);
		PersonalAccount compteAlix = new PersonalAccount("002", "002", AccountType.COMPTE_COURRANT, 100);
		PersonalAccount compteAdrien = new PersonalAccount("003", "003", AccountType.COMPTE_COURRANT, 100);

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
		for (int i = 0; i < 10; i++) {
			val.addPersonalAccount(new PersonalAccount(compteVal));
		}
		alix.addPersonalAccount(compteAlix);
		adrien.addPersonalAccount(compteAdrien);
		
		this.add(val);
		this.add(alix);
		this.add(adrien);
	}
}
