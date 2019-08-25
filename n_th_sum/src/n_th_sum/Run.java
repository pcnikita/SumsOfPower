/**
 * 
 */
package n_th_sum;
import n_th_sum.Create_matrix;
import java.util.Scanner;
import java.math.BigDecimal;


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
		
		long startTime = System.nanoTime();
		
		BigDecimal[][] init = matrix.createNullMatrix(power);
		
		init = matrix.findCoefficients(init);
		
		BigDecimal[] vec = matrix.findPartialSums(init);
		
		BigDecimal[][] inverse = matrix.findInverse(init);
		
		BigDecimal[] vec1 = matrix.multiplyMatrices(inverse, vec);
		System.out.println();
		matrix.readVector(vec1);
		
		long endTime = System.nanoTime();
		
		in.close();
		
		System.out.println( (float)((float)(endTime-startTime)/1000000000) + " seconds to finish");
	}
	

}
