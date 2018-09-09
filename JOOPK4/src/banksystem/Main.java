package banksystem;

import java.math.BigDecimal;

public class Main {
	public static void printLine() {
		System.out.println("\n----------x----------\n");
	}

	public static void printEmptyLine() {
		System.out.println("\n");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 16; i++) {
			Client client = BankClientGateway.getClient(i).get();
			client.getBankCard().cardPayment(new BigDecimal("100"));
			printEmptyLine();
			if (client.getCreditCard() != null) {
				client.getCreditCard().cardPayment(new BigDecimal("25"));
				printEmptyLine();
			}
			client.getOptCreditCard().ifPresent(Main::doublePayment);
			printLine();
		}
	}

	private static void doublePayment(CreditCard c) {
		c.cardPayment(new BigDecimal("50"));
	}
}