/**
 * 
 */
package iterations;

/**
 * @author apobits@gmail.com
 *
 */
public class BinaryGap {

	public static int solution(int n) {
		return getMaximumGap(getBinary(n));
	}

	private static String getBinary(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % 2);
			n = n / 2;
		}
		return sb.reverse().toString();
	}

	private static int getMaximumGap(String binaryNumber) {
		boolean oneDetected = false;
		int count = 0, max = 0;
		for (int i = 0; i < binaryNumber.length(); i++) {
			if (binaryNumber.charAt(i) == '1') {
				oneDetected = true;
				if (count > 0) {
					if (count > max) {
						max = count;
					}
					count = 0;
				}
			}
			if (oneDetected) {
				if (binaryNumber.charAt(i) == '0') {
					count++;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(561892));

	}

}
