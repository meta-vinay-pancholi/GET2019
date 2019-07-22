public class MathOperation {
	private int lcm = 1;

	/**
	 * @param a
	 * @param b
	 * function returning greatest common divisor of given two number
	 */
	static int hcfCalculate(int number1, int number2) {
		if (number1 == 0)
			return number2;
		if(number2==0)
			return number1;
		return hcfCalculate(number2 % number1, number1);

	}

	/**
	 * @param a
	 * @param b
	 * function returning least common factor of given two numbers
	 */
	public int lcmCalculate(int number1, int number2) {
		if(number1==0 ||number2==0){
			return 0;
		}
		if (lcm % number1 == 0 && lcm % number2 == 0) {
			return lcm;
		}
		lcm++;
		return lcmCalculate(number1, number2);
	}
}