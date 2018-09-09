package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

public class Payment {
	public static ArrayList<BankCard> cards = new ArrayList<BankCard>();
	public static PaymentProcessor pp = new PaymentProcessor();

	public static void main(String args[]) {
		BankCard b1 = new BankCard();
		cards.add(b1);
		CreditCard c1 = new CreditCard();
		cards.add(c1);
		BankCard b2 = new CreditCard();
		cards.add(b2);
		b1.cardPayment(new BigDecimal("500.50"));
		c1.cardPayment(new BigDecimal("765.43"));
		b2.cardPayment(new BigDecimal("9999.99"));
		b1.moneyLeft();
		c1.moneyLeft();
		b2.moneyLeft();
		// b1.moneyLeft(Calendar.getInstance());
		c1.moneyLeft(Calendar.getInstance());
		// b2.moneyLeft(Calendar.getInstance());
		CreditCard c2 = (CreditCard) b2;
		cards.add(c2);
		c2.moneyLeft();
		c2.moneyLeft(Calendar.getInstance());
		// CreditCard c3 = (CreditCard) b1;
		// c3.moneyLeft();
		// c3.moneyLeft(Calendar.getInstance());
		CreditCard c4 = new CreditCard(new BigDecimal("20000"));
		cards.add(c4);
		for (BankCard card : cards) {
			pp.firstPay(card);
		}
	}
}