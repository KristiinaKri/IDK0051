package bank;

import java.math.BigDecimal;

public class BankCard {
	protected BigDecimal balance, newBalance;
	protected int sum;

	public void balanceToNew(BigDecimal bd) {
		System.out.println("Balance was: " + balance + " €");
		System.out.println("Paid with bank card: " + bd + " €");
		System.out.println("New balance is: " + newBalance + " €");
	}

	public BankCard() {
		this.balance = new BigDecimal("10000.0005");
	}

	public void cardPayment(BigDecimal bd) {
		newBalance = balance.subtract(bd);
		sum = newBalance.compareTo(new BigDecimal("0"));
		if (sum == 0) {
			balanceToNew(bd);
			System.out.println("Balance is exactly 0 €,"
					+ " further payments denied.");
			balance = newBalance;
		} else if (sum == 1) {
			balanceToNew(bd);
			balance = newBalance;
		} else if (sum == -1) {
			balanceToNew(bd);
			System.out.println("Balance will become less than 0 €,"
					+ " payment denied.");
		}
	}

	public BigDecimal moneyLeft() {
		System.out.println("Checking for money left on bank card.");
		return balance;
	}
}