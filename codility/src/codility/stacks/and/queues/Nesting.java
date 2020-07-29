package codility.stacks.and.queues;

public class Nesting {

    public static void main(String[] args) {
	System.out.println(new Nesting().solution("(()(())())"));
    }

    public int solution(String s) {
	if (s.isEmpty()) {
	    return 1;
	}
	if (s.charAt(0) == ')' || s.length() % 2 != 0) {
	    return 0;
	}

	int counter = 0;
	for (int i = 0; i < s.length(); i++) {
	    switch (s.charAt(i)) {
	    case '(':
		counter++;
		break;
	    case ')':
		counter--;
		break;
	    }
	    if (counter < 0) {
		break;
	    }
	}

	return counter == 0 ? 1 : 0;
    }

}
