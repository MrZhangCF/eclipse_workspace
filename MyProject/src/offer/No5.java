package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author zhangcf
 */

public class No5 {
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public static void main(String[] args) {
		No5 temp = new No5();
		temp.push(10);
		temp.push(20);
		temp.push(30);
		temp.push(40);
		temp.push(50);
		
		System.out.println(temp.pop());
		System.out.println(temp.stack1.empty());
		System.out.println(temp.pop());
		temp.push(60);
		temp.push(70);
		temp.push(80);
		System.out.println(temp.pop());
	}
	
	public void push(int node){
		stack1.push(node);
	}
	
	public int pop(){
		if(stack1.empty() && stack2.empty()){
			throw new RuntimeException("Queue is Empty");
		}
		if(stack2.empty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
