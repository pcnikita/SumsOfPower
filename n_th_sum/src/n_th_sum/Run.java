/**
 * 
 */
package n_th_sum;
import n_th_sum.Create_matrix;
import java.util.Scanner;


/**
 * @author Nikita
 *
 */
public class Run {

	/**
	 * @param args
	 */
	
	static Create_matrix matrix = new Create_matrix();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("For which power would you like to calculate the formula? (type whole, positive number)");
		int power = in.nextInt()+1;
		
		double[][] init = matrix.createNullMatrix(power);
		matrix.readMatrix(init);
		System.out.println();
		init = matrix.createIdentityMatrix(power);
		matrix.readMatrix(init);
		System.out.println();
		init = matrix.findCoefficients(init);
		matrix.readMatrix(init);
		System.out.println();
		System.out.println();
		double[] vec = matrix.findPartialSums(init);
		matrix.readVector(vec);
		
		double[][] inverse = matrix.findInverse(init);
		matrix.readMatrix(inverse);
		System.out.println();
		
		double[][] result = matrix.multiplyMatrices(init, inverse);
		matrix.readMatrix(result);
		
		double[][] result1 = matrix.multiplyMatrices(inverse, init);
		matrix.readMatrix(result1);
		
		double[] vec1 = matrix.multiplyMatrices(inverse, vec);
		System.out.println();
		System.out.println();
		matrix.readVector(vec1);
		
		in.close();
	}
	

}
