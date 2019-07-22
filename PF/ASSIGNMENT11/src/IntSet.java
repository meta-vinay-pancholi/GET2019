/**
 * @class IntSet Have following operation like
 * @fun sizeOfSet
 * @fun isMember
 * @fun isSubSet
 * @fun getComplement
 * @fun getUnion
 * @param set is array type private member which can only initialize ones class is Immutable and which can not inherited
 * @author Vinay Pancholi
 * @date 22/7/2019
 */
public final class IntSet {
	private int set[];

	/**
	 * Constructor to initialize the set array
	 * @param set this is one dimensional array
	 */
	IntSet(int set[]) {
		this.set = set;
	}

	/**
	 * @return array value
	 */
	public int[] getSet() {
		return set;
	}

	/**
	 * @return size of universal set
	 */
	public int sizeOfSet() {
		int size = 0;
		for (int i = 0; i < this.getSet().length; i++) {
			size = size + 1;
		}
		return size - 1;
	}

	/**
	 * @param value is any variable which is int type
	 * @return if value is present in set return true else false
	 */
	public boolean isMember(int value) {
		for (int i = 0; i < this.getSet().length; i++) {
			if (value == this.getSet()[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param subSet contain the element of array
	 * @return if it is subset of universal set return true else false
	 */
	public boolean isSubSet(int[] subSet) {
		int count = 0;
		if (subSet.length == 0) {
			return true;// empty set
		} else {
			for (int i = 0; i < subSet.length; i++) {
				int temp = this.getSet().length - 1;
				while (temp != -1) {
					if (subSet[i] == this.getSet()[temp]) {
						count++;
						}
					temp--;
					}
			}
		}
		if (count == subSet.length) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param subSet
	 * @return the complement set
	 */
	public int[] getComplement(int[] subSet) {

		int complementSet[] = new int[this.getSet().length - subSet.length];
		if (subSet.length == 0) { // if subset is empty it return complete set
			return this.getSet();
		} else {
			int count = 0;
			int jElement = set.length - 1;
			while (count != subSet.length) {
				if (subSet[count] != set[jElement]) {
					if (jElement != -1) {// if jElement is == -1 which means set is checked
						jElement = jElement - 1;// check every element of universal set by the value

					}
				} else {
					set[jElement] = -1;
					jElement = set.length - 1;
					count = count + 1;// increment the value of count when element of subset is in universal set
				}
			}
			int nElement = 0;
			for (int i = 0; i < set.length; i++) {

				if (set[i] != -1) {
					complementSet[nElement] = set[i];
					nElement = nElement + 1;
				}
			}
		}
		return complementSet;
	}

	/**
	 * @param set1
	 * @param set2
	 * @return union of set s1 and s2
	 */
	public int[] getUnion(IntSet set1, IntSet set2) {
		int nElement = 0;
		int kNoZero = 0;
		int unionSet[] = new int[set1.getSet().length + set2.getSet().length];
		for (int i = 0; i < set1.getSet().length; i++) {
			unionSet[i] = set1.getSet()[i];
		}
		int count = 0;
		while (set2.getSet().length != count) {

			if (unionSet[nElement] != set2.getSet()[count]) {
				nElement = nElement + 1;
				if (nElement == unionSet.length - 1) {
					unionSet[set1.getSet().length + count] = set2.getSet()[count];
					count = count + 1;
					nElement = 0;
				}
			} else {
				count = count + 1;// increment the value of count when element of subset is in universal set
				nElement = 0;
			}
		}
		for (int i = 0; i < unionSet.length; i++) {
			if (unionSet[i] != 0) {
				kNoZero++;
			}
		}
		int unionSet1[] = new int[kNoZero];
		int c = 0;
		for (int i = 0; i < unionSet.length; i++) {
			if (unionSet[i] != 0) {
				unionSet1[c] = unionSet[i];
				c++;
			}
		}
		return unionSet1;
	}
}