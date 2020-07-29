package codility.stacks.and.queues;

import java.util.LinkedList;

public class Brackets {

    //method compliance with codility firm
    public static int solution(String data) {
	if (data.isEmpty()) {
	    return 1;
	}

	int count1 = 0, count2 = 0, count3 = 0;

	for (int i = 0; i < data.length(); i++) {
	    char temp = data.charAt(i);
	    switch (temp) {
	    case '(':
		count1++;
		break;
	    case '{':
		count2++;
		break;
	    case '[':
		count3++;
		break;
	    case ')':
		count1--;
		break;
	    case '}':
		count2--;
		break;
	    case ']':
		count3--;
		break;
	    }
	    if (count1 < 0 || count2 < 0 || count3 < 0) {
		return 0;
	    }
	}

	if (count1 == 0 && count2 == 0 && count3 == 0) {
	    return 1;
	} else {
	    return 0;
	}
    }

    public static void main(String args[]) {
	System.out.println(solution("([)()]"));
    }

}
