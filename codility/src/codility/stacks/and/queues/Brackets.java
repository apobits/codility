package codility.stacks.and.queues;

import java.util.LinkedList;

public class Brackets {

    //method compliance with codility firm
    public static int solution(String data) {
	if (data.isEmpty()) {
	    return 1;
	}

	LinkedList<Character> linkedListQueue = new LinkedList<>();
	LinkedList<Character> linkedListStack = new LinkedList<>();
	for (int i = 0; i < data.length(); i++) {
	    char temp = data.charAt(i);
	    switch (temp) {
	    case '(':
		if (i + 1 < data.length() && data.charAt(i + 1) != ')')
		    linkedListQueue.offer(temp);
		else
		    i++;
		break;
	    case '{':
		if (i + 1 < data.length() && data.charAt(i + 1) != '}')
		    linkedListQueue.offer(temp);
		else
		    i++;
		break;
	    case '[':
		if (i + 1 < data.length() && data.charAt(i + 1) != ']')
		    linkedListQueue.offer(temp);
		else
		    i++;
		break;
	    case ')':
	    case '}':
	    case ']':
		if (linkedListQueue.isEmpty()) {
		    return 0;
		}
		linkedListStack.push(temp);
		break;
	    default:
		return 0;
	    }
	}

	if (linkedListQueue.size() != linkedListStack.size()) {
	    return 0;
	}

	Character stackTemp;
	while ((stackTemp = linkedListQueue.poll()) != null) {
	    switch (stackTemp) {
	    case '{': {
		char queueTemp = linkedListStack.pop();
		if (queueTemp != '}') {
		    return 0;
		}
		break;
	    }
	    case '(': {
		char queueTemp = linkedListStack.pop();
		if (queueTemp != ')') {
		    return 0;
		}
		break;
	    }
	    case '[': {
		char queueTemp = linkedListStack.pop();
		if (queueTemp != ']') {
		    return 0;
		}
		break;
	    }
	    default:
		return 0;
	    }
	}
	return 1;
    }

    public static int checkEquality(String data) {
	var start = System.nanoTime();
	int result = 1;
	if (!data.isEmpty()) {
	    var linkedListStack = new LinkedList<Character>();
	    var linkedListQueue = new LinkedList<Character>();

	    for (int i = 0; i < data.length(); i++) {
		char temp = data.charAt(i);
		switch (temp) {
		case '(':
		case '{':
		case '[':
		    linkedListStack.push(temp);
		    break;
		case ')':
		case '}':
		case ']':
		    linkedListQueue.offer(temp);
		    break;
		default:
		    result = 0;
		    break;
		}
	    }

	    if (linkedListQueue.size() == linkedListStack.size()) {
		for (int i = 0; i < linkedListStack.size(); i++) {
		    switch (linkedListStack.pop()) {
		    case '{': {
			if (linkedListQueue.peek() == null || !linkedListQueue.poll().equals('}')) {
			    return 0;
			}
			break;
		    }
		    case '(': {
			if (linkedListQueue.peek() == null || !linkedListQueue.poll().equals(')')) {
			    return 0;
			}
			break;
		    }
		    case '[': {
			if (linkedListQueue.peek() == null || !linkedListQueue.poll().equals(']')) {
			    return 0;
			}
			break;
		    }
		    default:
			return 0;
		    }
		}
	    } else {
		result = 0;
	    }
	}
	System.out.println("checkEquality executed in: " + (System.nanoTime() - start) + " nanoseconds");
	return result;
    }

    public static int checkForEquality2(String data) {
	var start = System.nanoTime();
	int length = data.length() / 2;
	while (length-- > 0) {
	    data = data.replaceAll("\\[]", "");
	    data = data.replaceAll("\\{}", "");
	    data = data.replaceAll("\\(\\)", "");
	}
	System.out.println("checkForEquality executed in: " + (System.nanoTime() - start) + " nanoseconds");
	return data.isEmpty() ? 1 : 0;
    }

    public static void main(String args[]) {
	System.out.println(solution("()((()())(()()))"));
    }

}
