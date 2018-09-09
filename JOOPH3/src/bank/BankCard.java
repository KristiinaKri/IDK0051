package bank;

import java.math.BigDecimal;

public class BankCard {
	protected BigDecimal balance;

	public BankCard() {
		this.balance = new BigDecimal("10000.0005");
	}

	public void cardPayment(BigDecimal bd) {
		balance = balance.subtract(bd);
		System.out.println("Paid with bank card: " + bd);
	}

	public BigDecimal moneyLeft() {
		System.out.println("Checking for money left on bank card.");
		return balance;
	}
}