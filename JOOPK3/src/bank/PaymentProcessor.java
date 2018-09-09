package bank;

import java.math.BigDecimal;

public class PaymentProcessor {
	public void payUp(BankCard card) {
		card.cardPayment(new BigDecimal("3.0454547"));
	}

	public void payUpDouble(BankCard card) {
		card.cardPayment(new BigDecimal("1000.00"));
	}
}