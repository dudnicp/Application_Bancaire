package model;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction t1, Transaction t2) {
		if (t1.getDate().before(t2.getDate())) {
			return -1;
		}
		else if (t1.getDate().after(t2.getDate())) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
