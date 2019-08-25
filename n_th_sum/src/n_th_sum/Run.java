/**
 * 
 */
package n_th_sum;
import n_th_sum.Create_matrix;

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
		float[][] init = matrix.createNullMatrix(10000);
		matrix.readMatrix(init);
	}

}
