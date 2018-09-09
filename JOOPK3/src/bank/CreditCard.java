package bank;

import java.math.BigDecimal;

//import java.util.Calendar;
public class CreditCard extends BankCard {
	private BigDecimal creditLimit = new BigDecimal("1000.05");
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

	public CreditCard(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
		balance = balance.add(creditLimit);
		System.out.println("New credit: " + creditLimit + " €");
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
	/*
	 * public BigDecimal moneyLeft(Calendar c) {
	 * System.out.println("Checking for money left on credit card" +
	 * " according to calendar.");
	 * return balance;
	 * }
	 */
}