package codility.stacks.and.queues;

public class StoneWall {

    public static void main(String[] args) {
	//	int[] heights = { 8, 8, 5, 7, 9, 8, 7, 4, 8 }; //7
	int[] heights = { 3, 2, 1 };//3
	System.out.println(solution(heights));
    }

    public static int solution(int[] h) {
	java.util.Map<String, String> map = new java.util.HashMap<>();
	int counter = 0;
	for (int i = 0; i < h.length; i++) {
	    if (i + 2 == h.length) {
		if (h[i] != h[i + 1]) {
		    counter += 2;
		} else {
		    counter++;
		}
		break;
	    } else if (h[i] == h[i + 1]) {
		continue;
	    } else {
		for (int j = i + 1; j < h.length; j++) {
		    if (h[i] > h[j]) {
			if (!map.containsKey(h[i] + "" + h[j])) {
			    counter++;
			    map.put(h[i] + "" + h[j], h[i] + "" + h[j]);
			    break;
			}
		    }
		}
	    }
	}
	return counter;
    }
}
