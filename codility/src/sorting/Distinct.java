/**
 * 
 */
package sorting;

import java.util.TreeSet;

/**
 * @author apobits@gmail.com
 *
 */
public class Distinct {

	public static int solution(int[] a) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		return set.size();
	}

	public static int solution2(int[] a) {
		int count = 0;
		int[] x = new int[2000001];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				a[i] = (a[i] * -1) + 1000000;
			}
			if (x[a[i]] == 0) {
				x[a[i]] = 1;
				count++;
			}
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution2(new int[] { -1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }));

	}

}
