package jooph8;

public class ExceptionTest {
	public void checkArg(int num) throws Exception {
		if (num < 11) {
			System.out.println(num);
		} else {
			throw new Exception("Sisend peab olema min 11");
		}
	}

	public void checkArgs2(int num) throws Exception {
		checkArg(num);
	}
}