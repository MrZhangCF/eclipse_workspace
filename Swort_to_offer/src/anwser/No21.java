package anwser;

import java.util.Stack;

public class No21 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean isPossible = false;

		if (pushA == null || popA == null)
			return isPossible;

		if (pushA.length != popA.length)
			return isPossible;

		int length = pushA.length;

		int nextPushIndex = 0;
		int nextPopIndex = 0;
		Stack<Integer> stack = new Stack<>();
		while (nextPopIndex < length) {
			while (stack.isEmpty() || stack.peek() != popA[nextPopIndex]) {
				if (nextPushIndex == length)
					break;
				stack.push(pushA[nextPushIndex]);
				nextPushIndex++;
			}
			if(stack.peek() != popA[nextPopIndex])
				break;
			stack.pop();
			nextPopIndex++;
		}

		if (stack.isEmpty() && nextPopIndex == length)
			isPossible = true;

		return isPossible;
	}

	public static void main(String[] args) {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 2, 1, 5, 3, 4 };
		System.out.println(new No21().IsPopOrder(pushA, popA));
	}

}
