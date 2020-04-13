package exampleData;
import java.util.Date;
import java.util.LinkedList;

import model.*;

public class ExampleUsers extends LinkedList<User>{

	private static final long serialVersionUID = -3057261316659943475L;

	public ExampleUsers() {
		User val = new User("", "", "Valérian", "Thomas", "Mr", 
				"valerian.thomas@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		User adrien = new User("1", "1", "Adrien", "Déplacé", "Mr", 
				"adrien.deplace@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		User alix = new User("2", "2", "Alix", "Brocoli", "Mr", 
				"alix.brocoli@grenoble-inp.org", "0123456789", "6 allée des acacias, Sèvres");
		
		CurrentAccount compteVal = new CurrentAccount("1234567890097556", "Compte1", val, new Date(), 100, 1000, 0, 300);
		CurrentAccount compteAlix = new CurrentAccount(compteVal);
		CurrentAccount compteAdrien = new CurrentAccount("12345", "Compte Adrien", adrien, new Date(), 400, 2000, 200, 800);

		val.addPayee(compteAdrien);
		alix.addPayee(compteAdrien);
		adrien.addPayee(compteVal);
		
		
		
		Card valCard = new Card(val, "3443", "1234234534564567");
		for (int i = 0; i < 10; i++) {
			compteVal.addCard(new Card(valCard));
		}
		
		Card adrienCard = new Card(adrien, "1122", "1234098745678765");
		
		for (int i = -30; i <= 30; i+=10) {
			compteVal.addTransaction(new Transaction(compteAdrien, i, (i%3 == 0)? 1 : 0, new Date(), new CardTransaction(adrienCard)));
		}
		
		val.addCurrentAccount(compteVal);
		val.addPelAccount(new PELAccount("123", "MonPEL", val, new Date(), 4000, 5000));
		val.addLivretAAccount(new LivretAAccount("234", "Super Livret", val, new Date(), 400, 3000, 200, 500));
		alix.addCurrentAccount(compteAlix);
		adrien.addCurrentAccount(compteAdrien);
		
		this.add(val);
		this.add(alix);
		this.add(adrien);
	}
}
