/**
 * This class contains main methods like 
 * @fun evaluate()
 * @fun addPoly()
 * @fun multiPoly()
 * @fun degree()
 * and other helper methods like
 * @fun calculatePower()
 * @fun getDegree()
 * @fun getSize()
 * @fun findMaxValue()
 * @fun getCofficient()
 * @fun linearSearchAlgo()
 * @author Vinay Pancholi
 */
public final class Polynomial {
	final private int coffecient[];
	final private int degree[];

	/**
	 * @param coffecient
	 * @param degree
	 * constructor
	 */
	public Polynomial(int[] coffecient, int[] degree) {
		this.coffecient = coffecient;
		this.degree = degree;
	}

	/**
	 * @return coefficient of polynomial
	 */
	public int[] getCoffecient() {
		return coffecient;
	}

	/**
	 * @return degree of polynomial
	 */
	public int[] getDegree() {
		return degree;
	}

	/**
	 * @param value
	 * @return  value of the polynomial for the given value of the variable
	 */
	public int evaluate(int value) {
		int evaluateSum = 0;
		for (int i = 0; i < coffecient.length; i++) {
			evaluateSum = evaluateSum + this.getCoffecient()[i] * calculatePower(this.getDegree()[i], value);
		}
		return evaluateSum;
	}

	/**
	 * @param degree
	 * @param value
	 * @return 
	 */
	private int calculatePower(int degree, int value) {
		if (degree == 0) {
			return 1;
		}
		return value * calculatePower(degree - 1, value);
	}

	/**
	 * @return
	 */
	public int degree() {
		return this.getCoffecient().length;
	}

	/**
	 * @param polynomial
	 * @param polynomial1
	 * @return Addition of polynomial
	 */
	public int[] addPoly(Polynomial polynomial, Polynomial polynomial1) {
		int count = 0;
		int size = getSize(polynomial.getDegree() , polynomial1.getDegree());
		int [] coffecient1= new int[size];
		int [] degree1 = new int [size];
		
		while (count != coffecient1.length - 1) {
			int newCofficent = 0;
			for (int i = 0; i < polynomial.getDegree().length; i++) {

				if (polynomial.getDegree()[i] == polynomial1.getDegree()[count]) {
					newCofficent = polynomial.getCoffecient()[i] + polynomial1.getCoffecient()[count];
				}
			}
			if (newCofficent != 0) {
				coffecient1[count] = newCofficent;
				degree1[count] = polynomial1.getDegree()[count];
				count = count + 1;
			} else {

				coffecient1[count] = polynomial1.getCoffecient()[count];
				degree1[count] = polynomial1.getDegree()[count];
				count = count + 1;
			}
		}
		
		int flag = 0;
		for (int i = 0; i < polynomial.getDegree().length; i++) {
			for (int j = 0; j < degree1.length; j++) {
				if (polynomial.getDegree()[i] == degree1[j]) {
					flag = 0;
					break;
				} else {
					flag = 1;
				}
			}
			if (flag == 1) {
				coffecient1[count] = polynomial.getCoffecient()[i];
			}
		}
		return coffecient1;
	}

	/**
	 * @param degree
	 * @param degree1
	 * @return max size of polynomial
	 */
	private int getSize(int[] degree, int[] degree1) {
		int count = 0, flag = 1;

		for (int i = 0; i < degree.length; i++) {
			for (int j = 0; j < degree1.length; j++) {
				if (degree[i] == degree1[j]) {
					count++;
					flag = 0;
					break;
				   } else {
					flag = 1;
				}
			}
			if (flag == 1) {
				count++;
			}
		}

		return count;
	}

	/**
	 * @param degree
	 * @return maximum degree
	 */
	private int findMaxValue(int[] degree) {

		int maxValue = degree[0];
		for (int i = 0; i < degree.length; i++) {

			if (maxValue < degree[i]) {

				maxValue = degree[i];
			}
		}
		return maxValue;
	}
	
	/**
	 * @param polynomial
	 * @param polynomial1
	 * @return multiplication of polynomial
	 */
	public String multiPoly(Polynomial polynomial, Polynomial polynomial1) {
		int allDegree[] = getDgree(polynomial, polynomial1);
		int allCoffeicent[] = getCoffcient(polynomial, polynomial1);
		int maxDegre = this.findMaxValue(allDegree);
		int count = 0, flag = 0, value = 0;
		int newMultiPlyCoffecient[] = new int[maxDegre + 1];
		int newMultiPlyDegree[] = new int[maxDegre + 1];
		
		for (int i = 0; i < allDegree.length; i++) {
			flag = 0;
			int evaluateSum = 0;
			int linearSearch = allDegree.length;
			while (linearSearch != -1) {
				value = allDegree[i];
				linearSearch = this.linearSearchAlgo(allDegree, value,linearSearch - 1);
				if (linearSearch != -1) {
					if (allCoffeicent[linearSearch] != -1) {
						evaluateSum = evaluateSum + allCoffeicent[linearSearch];
						allCoffeicent[linearSearch] = -1;
					} else {
						flag = -1;
					}
				}
			}
			if (flag != -1) {
				newMultiPlyCoffecient[count] = evaluateSum;
				newMultiPlyDegree[count] = value;
				count = count + 1;
			}
		}
		String size = "";
		for (int i = 0; i < newMultiPlyCoffecient.length; i++) {
			if (newMultiPlyCoffecient[i] != 0) {
				size = size + String.valueOf(newMultiPlyCoffecient[i]) + "x^" + String.valueOf(newMultiPlyDegree[i]) + " ";
			}
		}
		return size;
	}

	/**
	 * @param allDegree
	 * @param value
	 * @param index
	 * @return for searching element
	 */
	private int linearSearchAlgo(int[] allDegree, int value, int index) {
		for (int j = index; j >= 0; j--) {
			if (allDegree[j] == value) {
				return j;
			}
		}
		return -1;
	}

	/**
	 * @param polynomial
	 * @param polynomial1
	 * @return multiplication of degrees
	 */
	private int[] getDgree(Polynomial polynomial, Polynomial polynomial1) {
		int allDegree[] = new int[polynomial.getDegree().length * polynomial1.getDegree().length];
		int count = 0;
		int j = 0;
		while (count != polynomial1.getDegree().length) {
			for (int i = 0; i < polynomial.getDegree().length; i++) {
					allDegree[j] = polynomial1.getDegree()[count] + polynomial.getDegree()[i];
					j = j + 1;
				}
			count = count + 1;
		}
		return allDegree;
	}

	/**
	 * @param polynomial
	 * @param polynomial1
	 * @return multiplication of coefficient
	 */
	private int[] getCoffcient(Polynomial polynomial, Polynomial polynomial1) {
		int allCoffeicent[] = new int[polynomial.getDegree().length * polynomial1.getDegree().length];
		int count = 0;
		int j = 0;
		while (count != polynomial1.getDegree().length) {
			for (int i = 0; i < polynomial.getDegree().length; i++) {
				allCoffeicent[j] = polynomial1.getCoffecient()[count] * polynomial1.getCoffecient()[i];
				j = j + 1;
			}
			count = count + 1;
		}
		return allCoffeicent;
	}
}