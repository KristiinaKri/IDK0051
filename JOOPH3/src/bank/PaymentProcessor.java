package bank;

import java.math.BigDecimal;

public class PaymentProcessor {

	public void firstPay(BankCard card) {
		card.cardPayment(new BigDecimal("3.0454547"));
	}
}