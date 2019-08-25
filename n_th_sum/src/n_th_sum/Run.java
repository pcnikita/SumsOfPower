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
		double[] vec = matrix.findPartialSums(init);
		matrix.readMatrix(init);
		System.out.println();
		init = matrix.createIdentityMatrix(power);
		matrix.readMatrix(init);
		System.out.println();
		init = matrix.findCoefficients(init);
		matrix.readMatrix(init);
		System.out.println();
		System.out.println();
		matrix.readVector(vec);
		
		double[][] inverse = matrix.findInverse(init);
		
		vec = matrix.multiplyMatrices(inverse, vec);
		System.out.println();
		System.out.println();
		matrix.readMatrix(vec);
		
		in.close();
	}
	

}
