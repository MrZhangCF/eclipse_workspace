package anwser;

public class No15 {
	public ListNode ReverseList(ListNode head) {
		
		ListNode newHead = null;
		ListNode node = null;
		ListNode prev = null;
		
		while(node != null){
			ListNode next = node.next;
			if(next == null){
				newHead = node;
			}
			node.next = prev ;
			prev = node;
			node = next;
		}
		
		return newHead;
	}
}
