package n_th_sum;
import java.lang.Math;

public class Create_matrix {
	
	public float[][] createNullMatrix(int n) {
		float[][] matrix = new float[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = 0.0f;
			}
		}
		return matrix;
	}
	
	public float[][] createIdentityMatrix(int n) {
		float[][] matrix = createNullMatrix(n);
		for (int i=0;i<n;i++) {
			matrix[i][i] = 1.0f;
		}
		return matrix;
	}
	
	public void readMatrix (float[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.println();
			for (int j=0; j< matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	
	public float[][] findCoefficients (float[][] matrix){
		for (int i=0; i< matrix.length; i++) {
			for (int j=0; j< matrix[0].length; j++) {
				matrix[i][j] = (float) Math.pow(i+1, matrix.length - j);
			}
		}
		return matrix;
	}

	public float[] findPartialSums (float[][] matrix) {
		float[] vector = new float[matrix.length];
		float partialSum = 0.0f;
		for (int i=0; i< matrix.length; i++) {
			partialSum = partialSum + (float) Math.pow(i+1, matrix.length);
			vector[i] = partialSum ;
		}
		return vector;
	}
	
	public void readVector (float[] vector){
		for (int i=0; i< vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	

}
