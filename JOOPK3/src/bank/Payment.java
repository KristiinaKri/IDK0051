package bank;

import java.math.BigDecimal;
import java.util.ArrayList;

//import java.util.Calendar;
public class Payment {
	public static ArrayList<BankCard> cards = new ArrayList<BankCard>();
	public static PaymentProcessor pp = new PaymentProcessor();

	public static void printLine() {
		System.out.println("----------x----------\n\n");
	}

	public static void main(String args[]) {
		BankCard b1 = new BankCard();
		cards.add(b1);
		b1.cardPayment(new BigDecimal("500.50"));
		printLine();
		CreditCard c1 = new CreditCard();
		cards.add(c1);
		c1.cardPayment(new BigDecimal("765.43"));
		// c1.moneyLeft(Calendar.getInstance());
		printLine();
		BankCard b2 = new CreditCard();
		cards.add(b2);
		b2.cardPayment(new BigDecimal("9999.99"));
		printLine();
		CreditCard c2 = (CreditCard) b2;
		cards.add(c2);
		c2.cardPayment(new BigDecimal("0.00001"));
		// c2.moneyLeft(Calendar.getInstance());
		printLine();
		CreditCard c3 = new CreditCard(new BigDecimal("3000.00"));
		cards.add(c3);
		c3.cardPayment(new BigDecimal("32.00"));
		printLine();
		CreditCard c4 = new CreditCardSizeL();
		cards.add(c4);
		c4.cardPayment(new BigDecimal("51.00"));
		printLine();
		CreditCard c5 = new CreditCardSizeL();
		cards.add(c5);
		c5.cardPayment(new BigDecimal("50.00"));
		printLine();
		CreditCard c6 = new CreditCardSizeL();
		cards.add(c6);
		c6.cardPayment(new BigDecimal("49.99"));
		printLine();
		BankCard b3 = new BankCard();
		cards.add(b3);
		b3.cardPayment(new BigDecimal("14000.00"));
		printLine();
		BankCard b4 = new BankCard();
		cards.add(b4);
		b4.cardPayment(new BigDecimal("-1337.00"));
		printLine();
		System.out.println("\n\n\nThere are " + cards.size() + " cards in total.");
		System.out.println("First round:\n\n\n\n\n");
		for (BankCard card : cards) {
			pp.payUp(card);
			System.out.println("Money left: " + card.moneyLeft() + " €");
			printLine();
		}
		System.out.println("\n\n\nSecond round:\n\n\n\n\n");
		for (BankCard card : cards) {
			pp.payUpDouble(card);
			System.out.println("Money left: " + card.moneyLeft() + " €");
			printLine();
		}
	}
}