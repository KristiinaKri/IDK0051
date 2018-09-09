package banksystem;

import java.math.BigDecimal;

public class CreditCard extends BankCard {
	private BigDecimal creditLimit = new BigDecimal("500");
	protected BigDecimal difference;

	@Override
	public void balanceToNew(BigDecimal bd) {
		System.out.println("Balance was: " + balance.add(bd) + " €");
		System.out.println("Paid with credit card: " + bd + " €");
		System.out.println("New balance is: " + balance + " €");
	}

	public CreditCard() {
		balance = balance.add(creditLimit);
		System.out.println("Credit: " + creditLimit + " €");
	}

	public CreditCard(BigDecimal creditLimit, BigDecimal balance) {
		this.creditLimit = creditLimit;
		this.balance = balance.add(creditLimit);
		System.out.println("New credit: " + creditLimit + " €\n");
	}

	@Override
	public void cardPayment(BigDecimal bd) {
		balance = balance.subtract(bd);
		difference = balance.subtract(balance.subtract(bd));
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

	@Override
	public BigDecimal moneyLeft() {
		System.out.println("Checking for money left on credit card.");
		return balance;
	}
}