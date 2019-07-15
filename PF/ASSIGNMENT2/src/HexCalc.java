import java.util.Scanner;

public class HexCalc {
	public static int hex2decimal(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	public static int hexSum(int a, int b) {

		return a + b;
	}

	public static int hexSubtraction(int a, int b) {
		return a - b;
	}

	public static int hexMultiplication(int a, int b) {
		return a * b;
	}

	public static int hexDivision(int a, int b) {
		return a / b;
	}

	public static String decm2Hex(int a) {
		int rem;
		String hexdecnum = "";

		/* digits in hexadecimal number system */

		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };

		while (a > 0) {
			rem = a % 16;
			hexdecnum = hex[rem] + hexdecnum;
			a = a / 16;
		}

		return hexdecnum;
	}

	public static boolean hexGreater(String hexdecnum1, String hexdecnum2) {

		int len1 = hexdecnum1.length();
		int len2 = hexdecnum1.length();
		int flag = 0;
		if (len1 > len2)
			return true;
		else {
			for (int i = 0; i < len1; i++) {
				if (hexdecnum1.charAt(i) >= hexdecnum2.charAt(i)) {
					flag++;

				} else {
					flag--;
				}
			}
		}
		if (flag == len1)
			return true;
		else
			return false;
	}

	public static void main(String args[]) {
		String hexdecnum1, hexdecnum2, result;
		int decnum1, decnum2, a;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter First Hexadecimal Number : ");
		hexdecnum1 = scan.nextLine();
		System.out.print("Enter Second Hexadecimal Number : ");
		hexdecnum2 = scan.nextLine();

		decnum1 = hex2decimal(hexdecnum1);
		decnum2 = hex2decimal(hexdecnum2);
		// a = hexSum(decnum1, decnum2);
		// result = decm2Hex(a);
		do {
			System.out
					.print("Enter your choice \n1.Sum\n2.Subtraction\n3.Multiplication\n4.Division\n5.Greater\n");
			int i = scan.nextInt();
			switch (i) {
			case 1:
				a = hexSum(decnum1, decnum2);
				result = decm2Hex(a);
				System.out.println("Sum is:" + result);
				break;
			case 2:
				a = hexSubtraction(decnum1, decnum2);
				result = decm2Hex(a);
				System.out.println("Subtraction is:" + result);
				break;
			case 3:
				a = hexMultiplication(decnum1, decnum2);
				result = decm2Hex(a);
				System.out.println("Multiplication is:" + result);
				break;
			case 4:
				a = hexDivision(decnum1, decnum2);
				result = decm2Hex(a);
				System.out.println("Division is:" + result);
				break;
			case 5:
				boolean b = hexGreater(hexdecnum1, hexdecnum2);
				System.out.print(b);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.print("Wrong input");

			}
		} while (true);

	}
}