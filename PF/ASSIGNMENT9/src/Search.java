import java.awt.LinearGradientPaint;

public class Search {
	private static int size = 0;
	private static int flag = 0;
	private static int mid = 0;
	private static int left = 0;
	private static int right = 0;

	/**
	 * @param array
	 * @param numberToSearch
	 * function returning index of element to be found if its not found it will return -1
	 */
	public int linearSearch(int[] array, int numberToSearch) {
		if (size == array.length) {
			return -1;
		} else if (array[size] == numberToSearch) {
			return size + 1;
		}
		else {
			size = size + 1;
			return linearSearch(array, numberToSearch);
		}
	}

	/**
	 * @param array
	 * @param numberToSearch
	 * function returning index of element to be found if its not found it will return -1
	 */
	public int binarySearch(int[] array, int numberToSearch) {
		if (flag == 0) {
			left = 0;
			right = array.length;
			mid = left + (right - 1) / 2;//mid=left+(right-1)/2
			flag = 1;
		}
		if (mid == array.length || mid < 0) {
			return -1;
		}
		if (array[mid] == numberToSearch) {
			return mid + 1;
		} else if (array[mid] > numberToSearch) { //if number is greater than number to be search it will decrease mid by 1
			mid = mid - 1;
			return binarySearch(array, numberToSearch);
		} else {
			mid = mid + 1; //if number is greater than number to be search it will increment mid by 1
			return binarySearch(array, numberToSearch);
		}
	}
}
