package anwser;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class No3 {
	/**
	 * 使用栈来实现自定义链表的倒序输出
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		

		Stack<Integer> vals = new Stack<>();
		
		while(listNode != null){
			vals.push(listNode.val);
			listNode = listNode.next;
			
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while(!vals.isEmpty()){
			list.add(vals.pop());
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ListNode ln6 = new ListNode(6);
		
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		
		ArrayList<Integer> list = new No3().printListFromTailToHead(ln1);
		
		//System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
}
