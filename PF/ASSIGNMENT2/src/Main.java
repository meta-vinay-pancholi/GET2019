import java.util.Scanner;
public class Main {
	private static Scanner scan;
	public static void main(String args[]) {
		String hexdecnum1, hexdecnum2, result;
		int decnum1, decnum2, a;
		scan = new Scanner(System.in);
		HexCalc hex= new HexCalc();
		System.out.print("Enter First Hexadecimal Number : ");
		hexdecnum1 = scan.nextLine();
		System.out.print("Enter Second Hexadecimal Number : ");
		hexdecnum2 = scan.nextLine();
		decnum1 = hex.hex2decimal(hexdecnum1);
		decnum2 = hex.hex2decimal(hexdecnum2);
		do {
			System.out.print("Enter your choice \n1.Sum\n2.Subtraction\n3.Multiplication\n4.Division\n5.To check if first hexa number is greater\n6.To check if first hexa number is smaller\n7.To check if two hexa number are equal\n8.To convert hexa number into decimal\n9.To covert decimal into hexa\n");
			int i = scan.nextInt();
			switch (i) {
			case 1:
				a = hex.hexSum(decnum1, decnum2);
				result = hex.decm2Hex(a);
				System.out.println("Sum is:" + result+"\n");
				break;
			case 2:
				a = hex.hexSubtraction(decnum1, decnum2);
				result = hex.decm2Hex(a);
				System.out.println("Subtraction is:" + result);
				break;
			case 3:
				a = hex.hexMultiplication(decnum1, decnum2);
				result = hex.decm2Hex(a);
				System.out.println("Multiplication is:" + result);
				break;
			case 4:
				a = hex.hexDivision(decnum1, decnum2);
				result = hex.decm2Hex(a);
				System.out.println("Division is:" + result);
				break;
			case 5:
				boolean b = hex.hexGreater(hexdecnum1, hexdecnum2);
				System.out.print(b + "\n");
				break;
			case 6:
				boolean c = hex.hexSmaller(hexdecnum1, hexdecnum2);
				System.out.print(c + "\n");
				break;
			case 7:
				boolean d = hex.hexEqual(hexdecnum1, hexdecnum2);
				System.out.print(d + "\n");
				break;
			case 8:
				System.out.print(hex.hex2decimal("4a3"));
				break;
			case 9:
				System.out.print(hex.decm2Hex(695));
				break;
			default:
				System.out.print("Wrong input");
				}
		} while (true);
		}
	}
