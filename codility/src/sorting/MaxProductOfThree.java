/**
 * 
 */
package sorting;

import java.util.TreeSet;

/**
 * @author Administrador
 *
 */
public class MaxProductOfThree {

	public int solution(int a[]) {
		TreeSet<Integer> triplets = new TreeSet<>();
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				for (int k = j + 1; k < a.length; k++) {
					triplets.add(a[i] * a[j] * a[k]);
				}
			}
		}

		return triplets.last();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(new MaxProductOfThree().solution(new int[] { -5, 5, -5, 4 }));

	}

}
