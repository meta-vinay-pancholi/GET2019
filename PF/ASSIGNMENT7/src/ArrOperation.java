public class ArrOperation {
	/**
	 * @param numArray
	 * @return maxMirrorCount
	 * function returning size of the largest mirror section found in the input array.
	 */
	public int maxMirror(int[] numArray) {
		int len = numArray.length;
		int maxMirrorCount = 0;
		boolean flag = false;

		try {
			if (numArray.length == 0) {
				throw new AssertionError("Assertion Error occured");// If array length  zero it will throw assertion error
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
				} else if (numArray[count] == numArray[j] && flag) {
					tempCount++;
					count++;
					maxMirrorCount = (tempCount > maxMirrorCount) ? tempCount : maxMirrorCount;
					continue;
				} else if (numArray[i] != numArray[j] && flag) {
					flag = false;
					count = i;
					tempCount = 1;
					continue;
				} else if (j == count || (j - count) == 1) {
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
	public int[] fixXY(int array[] , int x , int y) {
		if (array.length == 0)
			throw new AssertionError("Array is Empty.");
		// Check if occurence of x & y are equal, throws Assertion error otherwise.
		int countx = 0, county = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				if (i < array.length - 1 && array[i + 1] == x)
					throw new AssertionError("Two adjacents X values are there.");
				countx++;
			}
			if (array[i] == y)
				county++;
		}
		if (countx != county)
			throw new AssertionError("There are unequal numbers of X and Y " + "in input array.");

		int y1 = -1;
		for (int i = 0; i < array.length; i++) {
			// If x is the last element in array, throws Assertion error.
			if (i == array.length - 1 && array[i] == x)
				throw new AssertionError("X occurs at the last index of array.");
			if (i < array.length - 1 && array[i] == x && array[i + 1] == y) {
				i = i + 1;
				continue;
			}
			if (array[i] == x) {
				if (y1 != -1) {
					ArrOperation.swap(i + 1, y1, array);
					y1 = -1;
					i++;
				} else {
					int temp = i + 2;
					while (temp < array.length && array[temp] != y)
						temp++;
					if (temp < array.length && array[temp] == y) {
						ArrOperation.swap(i + 1, temp, array);
						i++;
					}
				}
				continue;
			}
			if (array[i] == y && y1 == -1)
				y1 = i;
		}
		return array;
	}
	
	public static void swap(int x, int y, int array[]) {
		array[x] = array[x] + array[y];
		array[y] = array[x] - array[y];
		array[x] = array[x] - array[y];
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
