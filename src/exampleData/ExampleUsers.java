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
		
		PersonalAccount compteVal = new PersonalAccount("001", AccountType.COMPTE_COURRANT, 100, "001");
		PersonalAccount compteAlix = new PersonalAccount("002", AccountType.COMPTE_COURRANT, 100, "002");
		PersonalAccount compteAdrien = new PersonalAccount("003", AccountType.COMPTE_COURRANT, 100, "003");

		val.addBeneficiary(compteAlix);
		alix.addBeneficiary(compteAdrien);
		adrien.addBeneficiary(compteVal);
		
		Transaction t1 = new Transaction(compteAlix, 5, new Date());
		Transaction t2 = new Transaction(compteAdrien, 15, new Date());
		Transaction t3 = new Transaction(compteVal, 50, new Date());
		
		compteVal.addPendingTransaction(t3);
		compteVal.addHistory(t3);
		compteAlix.addHistory(t1);
		compteAlix.addPendingTransaction(t1);
		compteAdrien.addHistory(t2);
		compteAdrien.addPendingTransaction(t2);
		
		val.addPersonalAccount(compteVal);
		alix.addPersonalAccount(compteAlix);
		adrien.addPersonalAccount(compteAdrien);
		
		this.add(val);
		this.add(alix);
		this.add(adrien);
	}
}
