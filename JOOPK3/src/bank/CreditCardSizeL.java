package bank;

import java.math.BigDecimal;

public class CreditCardSizeL extends CreditCard {
	protected int l;

	@Override
	public void cardPayment(BigDecimal bd) {
		balance = balance.subtract(bd);
		difference = balance.subtract(balance.subtract(bd));
		l = difference.compareTo(new BigDecimal("50"));
		if (l == 0) {
			System.out.println("Payment is exactly 50 €."
					+ " You may proceed...");
		} else if (l == -1) {
			System.out.println("Payment is smaller than 50 €."
					+ " You may proceed...");
		} else if (l == 1) {
			System.out.println("Payment is bigger than 50 €."
					+ " Cannot proceed.");
			balance = balance.add(bd);
			return;
		}
		sum = balance.compareTo(new BigDecimal("0"));
		if (sum == 0) {
			balanceToNew(bd);
			System.out.println("Balance is exactly 0 €,"
					+ " further payments denied.");
		} else if (sum == 1) {
			balanceToNew(bd);
		} else if (sum == -1) {
			balanceToNew(bd);
			System.out.println("Balance will become less than 0 €,"
					+ " payment denied.");
			balance = balance.add(bd);
		}
	}
}