public class HexCalc {
	/**
	 * @param s
	 * @return decimalValue
	 * function taking hexadecimal number in string format and converting it into decimal 
	 */
	public int hex2decimal(String s){
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int decimalValue = 0;
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			decimalValue = 16 * decimalValue + d;
		}
		return decimalValue;
	}
	/**
	 * @param a
	 * @return
	 * function getting decimal number and returning a hexadecimal number
	 */
	public  String decm2Hex(int decimalNum) {
		int rem;
		String hexdecnum = "";

		/* digits in hexadecimal number system */

		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };

		while (decimalNum> 0) {
			rem = decimalNum % 16;
			hexdecnum = hex[rem] + hexdecnum;
			decimalNum = decimalNum / 16;
		}

		return hexdecnum;
	}

	/**
	 * @param a
	 * @param b
	 * function returning sum of numbers in decimal format
	 */
	public int hexSum(int a, int b) {

		return a + b;
	}

	/**
	 * @param a
	 * @param b
	 * function returning subtraction of number in decimal format
	 */
	public  int hexSubtraction(int a, int b) {
		return a - b;
	}

	/**
	 * @param a
	 * @param b
	 * function returning multiplication of number in decimal format
	 */
	public  int hexMultiplication(int a, int b) {
		return a * b;
	}

	/**
	 * @param a
	 * @param b
	 * function returning division of numbers in decimal format
	 */
	public  int hexDivision(int a, int b) {
		return a / b;
	}



	/**
	 * @param hexdecnum1
	 * @param hexdecnum2
	 * function return true if first number is greater else false
	 */
	public  boolean hexGreater(String hexdecnum1, String hexdecnum2) {

		int len1 = hexdecnum1.length();
		int len2 = hexdecnum1.length();
		if (len1 > len2)
			return true;
		else {
			for (int i = 0; i < len1; i++) {
				if(hexdecnum1.charAt(i) == hexdecnum2.charAt(i))
					continue;
				if (hexdecnum1.charAt(i) > hexdecnum2.charAt(i)) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	/**
	 * @param hexdecnum1
	 * @param hexdecnum2
	 * function return true if first number is smaller else false
	 */
	public  boolean hexSmaller(String hexdecnum1, String hexdecnum2) {	

		int len1 = hexdecnum1.length();
		int len2 = hexdecnum1.length();
		if (len1 < len2)
			return true;
		else {
			for (int i = 0; i < len1; i++) {
				if(hexdecnum1.charAt(i) == hexdecnum2.charAt(i))
					continue;
				if (hexdecnum1.charAt(i) < hexdecnum2.charAt(i))
					return true;
				break;
			}
		}
		return false;
	}

	/**
	 * @param hexdecnum1
	 * @param hexdecnum2
	 * function return true if both numbers are equal else false
	 */
	public  boolean hexEqual(String hexdecnum1, String hexdecnum2) {



		if(hexdecnum1 == hexdecnum2)
			return true;
		else
			return false;
	}
}
