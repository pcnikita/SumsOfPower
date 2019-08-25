/**
 * The Create_matrix has all the methods necessary to find 
 * the sum of the first n numbers to a given power. Should
 * rename this class at one point.
 * 
 * @author Nikita
 * @version 1.0
 * @since 25 Aug 2019
 */

package n_th_sum;
import java.math.BigDecimal;

public class Create_matrix {	
	
	/**
	 * This method takes a whole, non-negative number
	 * and returns the null n x n matrix. The matrices
	 * are square.
	 * @param n This is the number of rows and columns.
	 * @return matrix This returns a square matrix with n columns.
	 */
	public BigDecimal[][] createNullMatrix(int n) {
		BigDecimal[][] matrix = new BigDecimal[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = BigDecimal.ZERO;
			}
		}
		return matrix;
	}
	
	/**
	 * This method takes a whole, non-negative number
	 * and returns the identity n x n matrix. The matrices
	 * are square. The identity matrix is the matrix that
	 * has all 1's on the main diagonal.
	 * @param n This is the number of rows and columns.
	 * @return matrix This is the n x n identity matrix.
	 */
	public BigDecimal[][] createIdentityMatrix(int n) {
		BigDecimal[][] matrix = createNullMatrix(n);
		for (int i=0;i<n;i++) {
			matrix[i][i] = BigDecimal.ONE;
		}
		return matrix;
	}
	
	/**
	 * This method takes as input a matrix and 
	 * reads its contents row by row and column
	 * by column.
	 * @param matrix This is the input matrix.
	 */
	public void readMatrix (BigDecimal[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.println();
			for (int j=0; j< matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	
	/**
	 * This takes as input a vector and
	 * reads its content on a single row.
	 * It is overloaded to work for
	 * matrices with 1 column.
	 * @param matrix This is the input matrix with 1 column.
	 */
	public void readMatrix (BigDecimal[] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.print(matrix[i] +" ");
		}
	}
	
	/**
	 * To find the coefficients of the n'th order polynomial,
	 * an n'th order system must be solved generally. This
	 * finds the coefficients of the square matrix. 
	 * @param matrix This is the input n x n matrix. 
	 * @return matrix This is the matrix that has the coefficients.
	 */
	public BigDecimal[][] findCoefficients (BigDecimal[][] matrix){
		for (int i=0; i< matrix.length; i++) {
			for (int j=0; j< matrix[0].length; j++) {
				BigDecimal a = new BigDecimal(i+1);
				matrix[i][j] = a.pow(matrix.length - j);
			}
		}
		return matrix;
	}
	/**
	 * To have a complete system for n variables, we need
	 * n results. In our case, the n results are the first n
	 * partial sums.
	 * @param matrix This is the matrix we will use. Only its length matters.
	 * @return vector This is vector containing the first n partial sums.
	 */
	public BigDecimal[] findPartialSums (BigDecimal[][] matrix) {
		BigDecimal[] vector = new BigDecimal[matrix.length];
		BigDecimal partialSum = BigDecimal.ZERO;
		for (int i=0; i< matrix.length; i++) {
			BigDecimal a = new BigDecimal (i+1);
			partialSum = partialSum.add(a.pow(matrix.length-1));
			vector[i] = partialSum ;
		}
		return vector;
	}
	
	/**
	 * This reads a vector row by row. Vertical display instead
	 * of the horizontal display we had in readMatrix().
	 * 
	 * @param vector The input is a matrix with 1 column.
	 */
	public void readVector (BigDecimal[] vector){
		System.out.println("================================================================Vector reading starts here================================================================");
		for (int i=0; i< vector.length; i++) {
			System.out.println(vector[i] + " ");
		}
	}
	
	/**
	 * This method uses Gaussian elimination to find the inverse of the
	 * given coefficient matrix.
	 * {@link https://www.mathportal.org/linear-algebra/matrices/gauss-jordan.php}
	 * See this for an explanation as to how might one use gaussian elimination to 
	 * find the inverse.
	 * 
	 * The matrix should not be singular.
	 * 
	 * @param matrix This is the matrix of the coefficients.
	 * @return inverse This is the inverse matrix.
	 */
	public BigDecimal[][] findInverse(BigDecimal[][] matrix){
		BigDecimal[][] inverse = createIdentityMatrix(matrix.length);
		BigDecimal[][] copy = copyMatrix(matrix);
		
		for (int i = 0; i < copy.length; i++) {
			if (copy[i][i] != BigDecimal.ONE) {
				BigDecimal ratio = copy[i][i];
				for (int k = 0; k< copy.length; k++) {
					copy [i][k] = copy[i][k].divide(ratio,1000,BigDecimal.ROUND_HALF_EVEN);
					inverse [i][k] =  inverse[i][k].divide(ratio,1000,BigDecimal.ROUND_HALF_EVEN); 
				}
			}
			for (int j = 0; j < copy.length; j++) {
				if (i!= j) {
					BigDecimal ratio = findRatio (copy[i][i], copy[j][i]);
					for (int k = 0; k< copy.length; k++) {
						copy [j][k] = copy[j][k].add( ratio.multiply(copy[i][k]));
						inverse [j][k] = inverse[j][k].add(ratio.multiply(inverse[i][k])); 
					}
				}
			} 
		}
		return inverse;
	}
	
	/**
	 * This method finds the ratio of 2 BigDecimal numbers. 
	 * The ratio is taken so that adding a row multiplied by 
	 * a ratio to the rows above and below it produces 0's 
	 * on the given column of the element with indices kk.
	 * This is to say, the ratio is used to 0 out the elements
	 * above and below the main diagonal.
	 *
	 * @param a This is the numerator.
	 * @param b This is the denominator.
	 * @return The ratio of a/b.
	 */
	public BigDecimal findRatio (BigDecimal a, BigDecimal b) {
		return ( b.divide(a,1000,BigDecimal.ROUND_HALF_EVEN) ).negate();
	}

	/**
	 * This method performs matrix multiplication.This
	 * was used to check that the multiplication of the
	 * coefficients matrix and its inverse results in the
	 * identity matrix.
	 * 
	 * @param a This is an n x n matrix.
	 * @param b This is another n x n matrix.
	 * @throws ArithmeticException This means that the 2 given matrices
	 * cannot be multiplied.  
	 * @return c This is the result of the matrix multiplication a x b.
	 */
	public BigDecimal[][] multiplyMatrices(BigDecimal[][] a, BigDecimal[][] b){
		if (a[0].length != b.length) {
			throw new ArithmeticException ("The number of columns of the first matrix must be equal to the number of rows of the second");
		}
		BigDecimal[][] c = new BigDecimal[a.length][b[0].length];
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++ ) {
				BigDecimal term = BigDecimal.ZERO;
				for (int k = 0; k < a[0].length; k++) {
					term = term.add( a[i][k].multiply( b[k][j]));
				}
				
				c[i][j] = term;
			}
		}
		
		return c;
	}
	
	/**
	 * This method performs matrix multiplication with a vector.This
	 * was used to find the coefficients of the n'th order polynomial.
	 * 
	 * @param a This is an n x n matrix.
	 * @param b This is another n x n matrix.
	 * @throws ArithmeticException This means that the dimensions of the matrix
	 * and the vector don't match.  
	 * @return c This is the result of the matrix multiplication a x b.
	 */
	public BigDecimal[] multiplyMatrices(BigDecimal[][] a, BigDecimal[] b){
		if (a[0].length != b.length) {
			throw new ArithmeticException ("The number of columns of the first matrix must be equal to the number of rows of the second");
		}
		BigDecimal[] c = new BigDecimal[a.length];
		
		for(int i = 0; i < a.length; i++) {
			BigDecimal term = BigDecimal.ZERO;
			for (int k = 0; k < a[0].length; k++) {
				term = term.add( a[i][k].multiply( b[k]));
			}
			System.out.println(term);
			c[i] = term;
		}
		
		return c;
	}
	
	/**
	 * This copies a matrix. Might be totally useless, but
	 * it was done just to be sure that the value is copied
	 * and not the reference. Might delete this if i find out 
	 * otherwise.
	 *  
	 * @param matrix This is the matrix to be copied.
	 * @return copy This is the copy of the matrix.
	 */
	public BigDecimal[][] copyMatrix (BigDecimal[][] matrix){
		BigDecimal[][] copy = new BigDecimal[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				copy[i][j] = matrix [i][j];
			}
		}
		return copy;
	}
	
}
