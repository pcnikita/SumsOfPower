package n_th_sum;
import java.lang.Math;
import java.math.BigDecimal;

public class Create_matrix {
	
	public BigDecimal[][] createNullMatrix(int n) {
		BigDecimal[][] matrix = new BigDecimal[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = BigDecimal.ZERO;
			}
		}
		return matrix;
	}
	
	public BigDecimal[][] createIdentityMatrix(int n) {
		BigDecimal[][] matrix = createNullMatrix(n);
		for (int i=0;i<n;i++) {
			matrix[i][i] = BigDecimal.ONE;
		}
		return matrix;
	}
	
	public void readMatrix (BigDecimal[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.println();
			for (int j=0; j< matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	
	public void readMatrix (BigDecimal[] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.print(matrix[i] +" ");
		}
	}
	
	public BigDecimal[][] findCoefficients (BigDecimal[][] matrix){
		for (int i=0; i< matrix.length; i++) {
			for (int j=0; j< matrix[0].length; j++) {
				BigDecimal a = new BigDecimal(i+1);
				matrix[i][j] = a.pow(matrix.length - j);
			}
		}
		return matrix;
	}

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
	
	public void readVector (BigDecimal[] vector){
		System.out.println("================================================================Vector reading starts here================================================================");
		for (int i=0; i< vector.length; i++) {
			System.out.println(vector[i] + " ");
		}
	}

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
	
	public BigDecimal findRatio (BigDecimal a, BigDecimal b) {
		return ( b.divide(a,1000,BigDecimal.ROUND_HALF_EVEN) ).negate();
	}

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
