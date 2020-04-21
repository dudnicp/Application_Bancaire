package model;

import java.util.Comparator;

public class PermanentTransferComparator implements Comparator<PermanentTransfer> {
	@Override
	public int compare(PermanentTransfer t1, PermanentTransfer t2) {
		if (t1.getFirstTransactionDate().before(t2.getFirstTransactionDate())) {
			return -1;
		}
		else if (t1.getFirstTransactionDate().after(t2.getFirstTransactionDate())) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
