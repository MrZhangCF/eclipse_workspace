package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * @author zhangcf
 */
class ListNode {
	public int val;
	ListNode next = null;

	public ListNode(int val) {
		this.val = val;
	}
}

public class No3 {
	public static void main(String[] args) {
		
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> temp = new Stack<>();
		ArrayList<Integer> newList = new ArrayList<>();
		ListNode t = listNode;
		while (t != null) {
			temp.push(t.val);
			t = t.next;
		}
		while (!temp.empty()) {
			newList.add(temp.pop());
		}
		return newList;
	}
}
