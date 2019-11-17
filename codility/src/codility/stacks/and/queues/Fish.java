package codility.stacks.and.queues;

public class Fish {

    //check later to review timeout error on extreme_range1 reached 7secs
    public static int solution(int[] a, int[] b) {
	int aliveFish = a.length, upStreamCount = 0;
	boolean upstreamFlag = false;
	java.util.LinkedList<Integer> downStream = new java.util.LinkedList<>();
	for (int i = b.length - 1; i > -1; i--) {
	    if (b[i] == 1 && upstreamFlag) {
		downStream.offer(i);
	    } else if (b[i] == 0) {
		upstreamFlag = true;
		upStreamCount++;
	    }
	}

	if (downStream.isEmpty() || downStream.size() == b.length) {
	    return b.length;
	}

	while (downStream.peek() != null) {
	    if (upStreamCount == 0) {
		return aliveFish;
	    }
	    int i = downStream.pop();
	    for (int j = i + 1; j < a.length; j++) {
		if (b[j] == 0) {
		    if (a[i] > a[j]) {
			// i eats i+1
			b[j] = -1;
			aliveFish--;
			upStreamCount--;
		    } else if (a[i] < a[j]) {
			// i+1 eats i
			b[i] = -1;
			aliveFish--;
			break;
		    }
		}
	    }
	}

	return aliveFish;
    }

    public static void main(String[] args) {
	//	int[] a = { 4, 3, 2, 1, 5 };
	//	int[] b = { 0, 1, 1, 1, 1 };
	var aa = new int[99999];
	var bb = new int[99999];
	for (int i = aa.length - 1, j = 0; i > -1; i--, j++) {
	    aa[i] = j;
	    bb[i] = 1;
	}
	bb[99998] = 0;
	var start = System.nanoTime();
	System.out.println(solution(aa, bb));
	System.out.println((System.nanoTime() - start) / 1000000);
    }

}
