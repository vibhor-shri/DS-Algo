package integer;

public class ReverseNumber {

	public static void main(String[] args) {
//		int num = 1234;
		int num = 1021;
		System.out.println(reverse(num));

	}

	private static int reverse(int number) {

		int reversed = 0;
		while (number != 0) {
			int digit = number % 10;
			reversed = (reversed * 10) + digit;
			number /= 10;
		}

		return reversed;
	}

}
