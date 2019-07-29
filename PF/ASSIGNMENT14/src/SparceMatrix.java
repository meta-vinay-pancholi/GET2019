/**
 * This class contains function like 
 * @fun transpose() 
 * @fun addition()
 * @fun multiplication()
 * A helper method 
 * @fun generateSparse()
 * @author Vinay Pancholi
 * @date 23/07/2019
 */
public final class SparceMatrix {
	private int[][] matrix;
	private int MAX = 20;
	/**
	 * @param matrix
	 * constructor 
	 */
	SparceMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * @return
	 * getter method for getting matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @return
	 * function returning transpose of Instance matrix
	 */
	public int[][] transpose() {
		int[][] smatrix = this.generateSparce(getMatrix());
		int[][] transpose = new int[smatrix.length][3];
		
		for (int i = 0; i < smatrix.length; i++) {
			transpose[i][0] = smatrix[i][1];
			transpose[i][1] = smatrix[i][0];
			transpose[i][2] = smatrix[i][2];
		}
		System.out.println("transpose is");
		for (int i = 0; i < smatrix.length; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + transpose[i][j]);
			}
			System.out.printf("\n");
		}
		return transpose;
	}
	
	/**
	 * @return
	 * function returning true if matrix is symmetric else false
	 */
	public boolean symetric() { 
		int[][] originalmatrix = this.generateSparce(getMatrix());
		int[][] transposematrix= transpose();
		int count=0;
		for(int i = 0 ; i < 4 ; i++ ) {
			if((originalmatrix[i][0] != transposematrix[i][0]) && (originalmatrix[i][1] != transposematrix[i][1]) && (originalmatrix[i][2] != transposematrix[i][2])) {
				count++;
			}
		}
		if(count > 0 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param matrix
	 * @return addition
	 * function returning addition of matrix[][] passed and Instance matrix[][]
	 */
	public  int[][] addition(int[][] matrix) {
		int[][] smatrix1 = this.generateSparce(getMatrix());
		int[][] smatrix2 = this.generateSparce(matrix);
		int[][] addition = new int[MAX][3];
		int k = 0, apos = 0, bpos = 0;

		while (apos < smatrix1.length && bpos < smatrix2.length) {
			// if b's row and col is smaller
			if (smatrix1[apos][0] > smatrix2[bpos][0] || (smatrix1[apos][0] == smatrix2[bpos][0] && smatrix1[apos][1] > smatrix2[bpos][1])) {
				addition[k][0] = smatrix2[bpos][0];
				addition[k][1] = smatrix2[bpos][1];
				addition[k][2] = smatrix2[bpos][2];
				bpos++;
				k++;
			}
			// if a's row and col is smaller
			else if (smatrix1[apos][0] < smatrix2[bpos][0] || (smatrix1[apos][0] == smatrix2[bpos][0] && smatrix1[apos][1] < smatrix2[bpos][1])) {
				// insert smaller value into result
				addition[k][0] = smatrix1[apos][0];
				addition[k][1] = smatrix1[apos][1];
				addition[k][2] = smatrix1[apos][2];
				apos++;
				k++;
			} else {
				// add the values as row and col is same
				int addedval = smatrix1[apos][2] + smatrix2[bpos][2];
				if (addedval != 0) {
					addition[k][0] = smatrix1[apos][0];
					addition[k][1] = smatrix1[apos][1];
					addition[k][2] = addedval;
				}
				// then insert
				apos++;
				bpos++;
				k++;
			}
		}
		// insert remaining elements
		while (apos < smatrix1.length) {
			addition[k][0] = smatrix1[apos][0];
			addition[k][1] = smatrix1[apos][1];
			addition[k][2] = smatrix1[apos][2];
			apos++;
			k++;
		}
		while (bpos < smatrix2.length) {
			addition[k][0] = smatrix2[apos][0];
			addition[k][1] = smatrix2[apos][1];
			addition[k][2] = smatrix2[apos][2];
			bpos++;
			k++;
		}
		int [][]add = new int[k][3];
		for(int i = 0 ; i < k ; i++) {
			for(int j = 0 ; j < 3 ;j++) {
				 add[i][j] = addition[i][j];
			}
			System.out.println();
		}
		return add;
	}

	/**
	 * @param matrix
	 * @return multiplication
	 * function returning addition of matrix[][] passed and Instance matrix[][]
	 */
	public int[][] multiplication(int matrix[][]) {
		int[][] smatrix1 = this.generateSparce(getMatrix());
		int[][] smatrix2 = this.generateSparce(matrix);

		int i, j, k, temp;
		for (i = 0; i < 4; ++i) {
			for (j = i + 1; j <= 4; ++j) {
				if (smatrix2[i][1] > smatrix2[j][1]) {
					temp = smatrix2[i][0];
					smatrix2[i][0] = smatrix2[j][0];
					smatrix2[j][0] = temp;
					temp = smatrix2[i][1];
					smatrix2[i][1] = smatrix2[j][1];
					smatrix2[j][1] = temp;
					temp = smatrix2[i][2];
					smatrix2[i][2] = smatrix2[j][2];
					smatrix2[j][2] = temp;
				}
			}
		}
		// Sorting the second Matrix on the basis of row data for elements
		// having same column data
		for (i = 1; i < smatrix2.length; ++i) {
			for (j = i + 1; j <= smatrix2.length; ++j) {
				if (smatrix2[i][1] == smatrix2[j][1]) {
					if (smatrix2[i][0] > smatrix2[j][0]) {
						temp = smatrix2[i][0];
						smatrix2[i][0] = smatrix2[j][0];
						smatrix2[j][0] = temp;
						temp = smatrix2[i][1];
						smatrix2[i][1] = smatrix2[j][1];
						smatrix2[j][1] = temp;
						temp = smatrix2[i][2];
						smatrix2[i][2] = smatrix2[j][2];
						smatrix2[j][2] = temp;
					}
				}
			}
		}
		// Swapping the row data and column data
		for (i = 1; i <= smatrix2.length; ++i) {
			temp = smatrix2[i][0];
			smatrix2[i][0] = smatrix2[i][1];
			smatrix2[i][1] = temp;
		}// Found the transpose of 2nd Matrix

		// Now finding the no. of possible combinations in both the Matrices for
		// calculation of product
		temp = 0;
		for (i = 1; i <= smatrix1.length; ++i) {
			for (j = 1; j <= smatrix2.length; ++j) {
				if (smatrix1[i][1] == smatrix2[j][1])
					++temp;
			}
		}
		// Creating and initializing the Matrix which will store the product
		int[][] multiplication = new int[temp][3];
		multiplication[0][0] = smatrix1.length;
		multiplication[0][1] = smatrix2[0].length;
		multiplication[0][2] = 0;
		k = 1; // Used for Traversing the Product Matrix
		// Storing only the product terms in the Product Matrix
		// on the basis of column terms which are same in Multiplicand and
		// Multiplier Matrices
		for (i = 1; i <= smatrix1.length; ++i) {
			for (j = 1; j <= smatrix2.length; ++j) {
				if (smatrix1[i][1] == smatrix2[j][1]) {
					multiplication[k][0] = smatrix1[i][0];
					multiplication[k][1] = smatrix2[j][0];
					multiplication[k][2] = smatrix1[i][2] * smatrix2[j][2];
					++k;
				}
			}
		}
		// Sorting the Product Matrix on the basis of row data
		for (i = 1; i < temp; ++i) {
			for (j = i + 1; j <= temp; ++j) {
				if (multiplication[i][0] > multiplication[j][0]) {
					temp = multiplication[i][0];
					multiplication[i][0] = multiplication[j][0];
					multiplication[j][0] = temp;
					temp = multiplication[i][1];
					multiplication[i][1] = multiplication[j][1];
					multiplication[j][1] = temp;
					temp = multiplication[i][2];
					multiplication[i][2] = multiplication[j][2];
					multiplication[j][2] = temp;
				}
			}
		}
		// Sorting the Product Matrix on the basis of column data having same
		// row data
		for (i = 1; i < temp; ++i) {
			for (j = i + 1; j <= temp; ++j) {
				if (multiplication[i][0] == multiplication[j][0]) {
					if (multiplication[i][1] > multiplication[j][1]) {
						temp = multiplication[i][0];
						multiplication[i][0] = multiplication[j][0];
						multiplication[j][0] = temp;
						temp = multiplication[i][1];
						multiplication[i][1] = multiplication[j][1];
						multiplication[j][1] = temp;
						temp = multiplication[i][2];
						multiplication[i][2] = multiplication[j][2];
						multiplication[j][2] = temp;
					}
				}
			}
		}

		k = 0;
		// Calculating the product terms which are to be added
		// to get the final product term
		// by adding those data which has same row data and column data
		// and shifting the rows of the Product Matrix
		for (i = 1; i < temp; ++i) {
			if ((multiplication[i][0] == multiplication[i + 1][0])
					&& (multiplication[i][1] == multiplication[i + 1][1])) {
				multiplication[i][2] += multiplication[i + 1][2];
				for (j = i + 1; j < temp; ++j) {
					multiplication[j][0] = multiplication[j + 1][0];
					multiplication[j][1] = multiplication[j + 1][1];
					multiplication[j][2] = multiplication[j + 1][2];
				}
				// Setting the unused rows to -1
				multiplication[j][0] = -1;
				multiplication[j][1] = -1;
				multiplication[j][2] = -1;
				++k; // Calculating the unused rows
			}
		}
		temp -= k; // Reducing the size of the Product Matrix by subtracting the
					// no. of unused rows
		int d3 = temp;
		multiplication[0][2] = d3; // Setting the no. of elements of Product
									// Matrix
		// Printing the Product Matrix
		for (int m = 0; m < multiplication.length; m++) {
			for (int n = 0; n < 3; n++) {
				System.out.print(" " + multiplication[m][n]);
			}
		}
		return multiplication;

	}

	/**
	 * @param matrix
	 * @return smatrix
	 * function returning the generated sparse matrix
	 */
	public int[][] generateSparce(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}
		int[][] smatrix = new int[count][3];
		int k = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (matrix[i][j] != 0) {
					smatrix[k][0] = i;
					smatrix[k][1] = j;
					smatrix[k][2] = matrix[i][j];
					k++;
				}
			}
		}
		System.out.println("sparce");
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 3; j++) {

				System.out.print(" " + smatrix[i][j]);
			}
			System.out.printf("\n");
		}
		return smatrix;
	}
}