package n_th_sum;
import java.lang.Math;

public class Create_matrix {
	
	public double[][] createNullMatrix(int n) {
		double[][] matrix = new double[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = 0.0d;
			}
		}
		return matrix;
	}
	
	public double[][] createIdentityMatrix(int n) {
		double[][] matrix = createNullMatrix(n);
		for (int i=0;i<n;i++) {
			matrix[i][i] = 1.0f;
		}
		return matrix;
	}
	
	public void readMatrix (double[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.println();
			for (int j=0; j< matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	
	public void readMatrix (double[] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.print(matrix[i] +" ");
		}
	}
	
	public double[][] findCoefficients (double[][] matrix){
		for (int i=0; i< matrix.length; i++) {
			for (int j=0; j< matrix[0].length; j++) {
				matrix[i][j] = (double) Math.pow(i+1, matrix.length - j);
			}
		}
		return matrix;
	}

	public double[] findPartialSums (double[][] matrix) {
		double[] vector = new double[matrix.length];
		double partialSum = 0.0d;
		for (int i=0; i< matrix.length; i++) {
			partialSum = partialSum + (double) Math.pow(i+1, matrix.length-1);
			vector[i] = partialSum ;
		}
		return vector;
	}
	
	public void readVector (double[] vector){
		for (int i=0; i< vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public double[][] findInverse(double[][] matrix){
		double[][] inverse = createIdentityMatrix(matrix.length);
		double[][] copy = copyMatrix(matrix);
		
		for (int i = 0; i < copy.length; i++) {
			if (copy[i][i] != 1) {
				double ratio = copy[i][i];
				for (int k = 0; k< copy.length; k++) {
					copy [i][k] = copy[i][k]/ratio;
					inverse [i][k] =  inverse[i][k]/ ratio ; 
				}
			}
			for (int j = 0; j < copy.length; j++) {
				if (i!= j) {
					double ratio = findRatio (copy[i][i], copy[j][i]);
					for (int k = 0; k< copy.length; k++) {
						copy [j][k] = copy[j][k] + ratio*copy[i][k];
						inverse [j][k] = inverse[j][k] + ratio*inverse[i][k]; 
					}
				}
			} 
		}
		return inverse;
	}
	
	public double findRatio (double a, double b) {
		return (- b/a);
	}

	public double[][] multiplyMatrices(double[][] a, double[][] b){
		if (a[0].length != b.length) {
			throw new ArithmeticException ("The number of columns of the first matrix must be equal to the number of rows of the second");
		}
		double[][] c = new double[a.length][b[0].length];
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++ ) {
				double term = 0.0d;
				for (int k = 0; k < a[0].length; k++) {
					term = term + a[i][k] * b[k][j];
				}
				
				c[i][j] = term;
			}
		}
		
		return c;
	}
	
	public double[] multiplyMatrices(double[][] a, double[] b){
		if (a[0].length != b.length) {
			throw new ArithmeticException ("The number of columns of the first matrix must be equal to the number of rows of the second");
		}
		double[] c = new double[a.length];
		
		for(int i = 0; i < a.length; i++) {
			double term = 0.0d;
			for (int k = 0; k < a[0].length; k++) {
				term = term + a[i][k] * b[k];
			}
			System.out.println(term);
			c[i] = term;
		}
		
		return c;
	}
	
	public double[][] copyMatrix (double[][] matrix){
		double[][] copy = new double[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				copy[i][j] = matrix [i][j];
			}
		}
		return copy;
	}
	

}
