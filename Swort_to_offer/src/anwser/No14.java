package anwser;

import java.util.ArrayList;

public class No14 {
	
	public ListNode FindKthToTail(ListNode head, int k) {
		
		ArrayList<ListNode> list = new ArrayList<>();
		
		while(head != null){
			list.add(head);
			head = head.next;
		}
		
		if(k>list.size() || k == 0)
			return null;
		
		return list.get(list.size()-k);
	}
}
