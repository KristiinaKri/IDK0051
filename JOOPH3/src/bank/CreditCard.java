package bank;

import java.math.BigDecimal;
import java.util.Calendar;

public class CreditCard extends BankCard {

	public CreditCard() {
		super();
	}

	public CreditCard(BigDecimal bd) {

	}

	@Override
	public void cardPayment(BigDecimal bd) {
		balance = balance.subtract(bd);
		System.out.println("Paid with credit card: " + bd);
	}

	public BigDecimal moneyLeft(Calendar c) {
		System.out.println("Checking for money left on credit card.");
		return balance;
	}
}