package exampleData;
import java.util.Date;
import java.util.LinkedList;

import model.*;

public class ExampleUsers extends LinkedList<User>{

	private static final long serialVersionUID = -3057261316659943475L;

	public ExampleUsers() {
		User user1 = new User("1", "1", "Lewis", "Witely", "Mr", 
				"lewis.witely@gmail.com", "06740555876", "6 rue des lilas, Paris, 94800");
		User user2 = new User("2", "2", "Fiona", "Snyder", "Ms", 
				"fsnyder@outlook.com", "0502784579", "66 bouleverd Arstride Briand, Le Bouscat, 33110");
		
		Account random1 = new Account("1538405826", "Boulangerie Duchère");
		Account random2 = new Account("0184739414", "Uber Eats");
		Account random3 = new Account("6398137501", "Gaumont Parnasse");
		Account random4 = new Account("7240174938", "Amazon Prime");
		
		Account payee1 = new Account("3348134932", "Pascal Abil");
		Account payee2 = new Account("1394714824", "Didier Dulac");
		Account payee3 = new Account("1577403234", "Florence Cartier");
		
		CurrentAccount curr1 = new CurrentAccount("1846673023", "CompteLewis", user1, new Date(2010, 12, 15), 2341, 0, 500);
		CurrentAccount curr2 = new CurrentAccount("2403483473", "Compte Fiona", user2, new Date(2015, 5, 20), 6434, 0, 300);
		
		PELAccount pel1 = new PELAccount("1834759604", "Mon PEL", user1, new Date(2017, 4, 10), 7090, 0, 61200);
		PELAccount pel2 = new PELAccount("9986410034", "Mon PEL", user2, new Date(2008, 1, 1), 10000, 0, 61200);
		
		LivretAAccount livret1 = new LivretAAccount("1633491044", "LivretA", user1, new Date(2019, 4, 10), 5000, 0, 300, 22950);
		LivretAAccount livret2 = new LivretAAccount("5539111274", "LivretA", user2, new Date(2010, 10, 5), 1500 , 0, 500, 22950);
		
		Card card1 = new Card(user1, "2345", "32948749833");
		Card card2 = new Card(user2, "3456", "38375093728");
		
		PermanentTransfer transfer1 = new PermanentTransfer(curr1, payee1, 50, new Date(2019, 5, 10), TransferRegularity.THREE_MONTHLY);
		PermanentTransfer transfer2 = new PermanentTransfer(curr2, payee2, 1000, new Date(2015, 3, 15), TransferRegularity.ANNUAL);
		PermanentTransfer transfer3 = new PermanentTransfer(curr2, payee3, 150, new Date(2016, 10, 5), TransferRegularity.MONTHLY);
		
		Transaction transaction1 = new Transaction(random1, -5, 0, new Date(2020, 1, 1), new CardTransaction(card1));
		Transaction transaction2 = new Transaction(random3, -20, 0, new Date(2020, 2, 2), new PermanentTransferTransaction());
		Transaction transaction3 = new Transaction(random2, -10, 1, new Date(2020, 4, 15), new CardTransaction(card2));
		Transaction transaction4 = new Transaction(random3, -30, 0, new Date(2020, 3,3), new CardTransaction(card2));
		Transaction transaction5 = new Transaction(random4, -40, 1, new Date(), new PermanentTransferTransaction());
		
		Loan loan1 = new Loan(10000, 12000, 0.05, 4000, 0, new Date(2020, 10, 10), new Date(2030, 10, 10));
		Loan loan2 = new Loan(2000, 2500, 0.05, 2000, 1500, new Date(2017, 1, 1), new Date(2022, 1,1));
		
		curr1.addCard(card1);
		curr2.addCard(card2);
		
		curr1.addTransaction(transaction1);
		curr1.addTransaction(transaction2);
		curr1.addTransaction(transaction3);
		curr2.addTransaction(transaction4);
		curr2.addTransaction(transaction5);
		
		user1.addCurrentAccount(curr1);
		user2.addCurrentAccount(curr2);

		user1.addPelAccount(pel1);
		user2.addPelAccount(pel2);
		
		user1.addLivretAAccount(livret1);
		user2.addLivretAAccount(livret2);
		
		user1.addPayee(payee1);
		user2.addPayee(payee2);
		user2.addPayee(payee3);
		
		user1.addPermanentTransfer(transfer1);
		user2.addPermanentTransfer(transfer2);
		user2.addPermanentTransfer(transfer3);
		
		user1.addLoan(loan1);
		user2.addLoan(loan2);
		
		this.add(user1);
		this.add(user2);
	}
	
	
	
	
}
