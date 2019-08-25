package n_th_sum;

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
	
	public void readMatrix (float[][] matrix) {
		for(int i=0; i< matrix.length; i++) {
			System.out.println();
			for (int j=0; j< matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
	


}
