public class ArrOperation {
	/**
	 * @param numArray
	 * @return maxMirrorCount
	 * function returning size of the largest mirror section found in the input array.
	 */
	public int maxMirror(int[] numArray) {
		int len = numArray.length;
		int maxMirrorCount = 1;
		boolean flag = false;

		try {
			if (numArray.length == 0) {
				throw new AssertionError("Assertion Error occured");//If array length is zero it will throw assertion Error
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < len; i++) {
			int tempCount = 1;
			int count = i;
			for (int j = len - 1; j >= 0 && (count < len); j--) {
				if (numArray[count] == numArray[j] && !flag) {
					flag = true;
					count++;
					continue;
				}
				if (numArray[count] == numArray[j] && flag) {
					tempCount++;
					count++;
					maxMirrorCount = (tempCount > maxMirrorCount) ? tempCount
							: maxMirrorCount;
					continue;
				}
				if (numArray[i] != numArray[j] && flag) {
					flag = false;
					count = i;
					tempCount = 1;
					continue;
				}
				if (j == count || (j - count) == 1) {
					flag = false;
					break;
				}
			}
		}
		return maxMirrorCount;
	}

	/**
	 * @param numArray
	 * @return countClumps
	 * function returning the number of clumps in the input array
	 */
	public int countClumps(int[] numArray) {
		boolean match = false;
		int countClumps = 0;
		
		try {
			if (numArray.length == 0) {
				throw new AssertionError("Assertion Error occured");//Assertion array when array length will be zero
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < numArray.length - 1; i++) {
			if (numArray[i] == numArray[i + 1] && !match) {
				match = true;
				countClumps++;
			} else if (numArray[i] != numArray[i + 1]) {
				match = false;
			}
		}
		return countClumps;
	}

	/**
	 * @param nums
	 * @param x
	 * @param x
	 * @return numArray
	 * function returning an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y without moving X within array, but every other number may move
	 */
	public int[] fixXY(int numArray[], int x, int y) {
		int j = 0;
		int countX = 0, countY = 0;
		try {
			if (numArray.length == 0) {
				throw new AssertionError("Assertion Error occured");//Assertion error if array length will zero
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		
		for (int l = 0; l < numArray.length; l++) {
			if (numArray[l] == x) {
				countX = countX + 1;
			} else if (numArray[l] == y) {

				countY = countY + 1;
			}
		}

		try {
			if (countX != countY) {
				throw new AssertionError("Assertion Error occured");//Assertion error if number of x and y are unequal
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		for (int l = 1; l < numArray.length; l++) {
			try {
				if (numArray[l - 1] == x && numArray[l] == y) {

					throw new AssertionError("Assertion Error occured");
				}

			} catch (AssertionError e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			if (numArray[numArray.length - 1] == x) {
				throw new AssertionError("Assertion Error occured");//Assertion error if last element is X
			}

		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		for (int i = 0; i < numArray.length - 1; i++) {
			if (numArray[i] == x && numArray[i + 1] != y) {
				for (; !(numArray[j] == y && (j == 0 || j > 0
						&& numArray[j - 1] != x)); j++)
					;
				numArray[j] = numArray[i + 1];
				numArray[i + 1] = y;
			}
		}
		return numArray;
	}

	/**
	 * @param arr
	 * @return return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1
	 */
	public int findSplitPoint(int numArray[]) {
		try {
			if (numArray.length == 0) {
				throw new AssertionError("Assertion Error occured");//Assertion error if array length is zero
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		int leftSum = 0;
		for (int i = 0; i < numArray.length; i++) {
			leftSum += numArray[i];
			int rightSum = 0;
			for (int j = i + 1; j < numArray.length; j++)
				rightSum += numArray[j];
			if (leftSum == rightSum)
				return i + 1;
		}
		return -1;
	}
}
