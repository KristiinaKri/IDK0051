package jooph8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) {
		PrintStream original = System.out;
		System.out.println("Enne muutmist");
		FileOutputStream out;
		try {
			out = new FileOutputStream("C:\\Users\\Kristiina\\Desktop\\out.txt", true);
			System.setOut(new PrintStream(out));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Peale muutmist");
		System.out.println("Peale muutmist2");
		System.err.println("Kirjutab punase tooniga");
		System.setOut(original);
		System.out.println("Siia");
		FileOutputStream error;
		try {
			error = new FileOutputStream("C:\\Users\\Kristiina\\Desktop\\out.txt", true);
			System.setErr(new PrintStream(error));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.err.println("Kirjutab punase tooniga");
		System.err.println("Ei kirjuta sinise tooniga");

		ExceptionTest e = new ExceptionTest();
		try {
			e.checkArgs2(5);
		} catch (Exception myException) {
			System.out.println("Ilmnes viga: " + myException.getMessage());
			// myException.printStackTrace();
		}
	}
}