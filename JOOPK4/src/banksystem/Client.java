package banksystem;

import java.math.BigDecimal;
import java.util.Optional;
import scoring.*;

public class Client {
	private int ID;
	private BankCard b;
	private CreditCard c;

	public Client(int ID) {
		b = new BankCard();
		BigDecimal score = Scoring.getMaxCreditLimit(ID);
		if (score.compareTo(new BigDecimal("0")) > 0) {
			c = new CreditCard(score, new BigDecimal("0"));
		}
	}

	public int getIDCode() {
		return ID;
	}

	public BankCard getBankCard() {
		return b;
	}

	public CreditCard getCreditCard() {
		return c;
	}

	public Optional<CreditCard> getOptCreditCard() {
		return Optional.ofNullable(c);
	}
}