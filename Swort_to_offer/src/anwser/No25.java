package anwser;

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

public class No25 {
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNode(pHead);
		connectRandomNodes(pHead);
		return reconnectNodes(pHead);
	}
	
	//���ƽڵ㣬���ƵĽڵ�λ��ԭ�ڵ��next�����ƽڵ��nextΪԭ�ڵ��next
	public void cloneNode(RandomListNode pHead){
		RandomListNode pNode = pHead;
		while(pNode!= null){
			RandomListNode pClone = new RandomListNode(pNode.label);
			pClone.next = pNode.next;
			pClone.random = null;
			pNode.next = pClone;
			pNode = pClone.next;
		}
		
	}
	
	//����random���ӣ���ԭ�ڵ��random��next��ֵ��ԭ�ڵ��next
	public void connectRandomNodes(RandomListNode pHead){
		RandomListNode pNode = pHead;
		while(pNode != null){
			RandomListNode pClone = pNode.next;
			if(pNode.random != null){
				pClone.random = pNode.random.next;
			}
			pNode = pClone.next;
		}
	}
	
	//����next���ӣ����Ͽ��ɵ�����
	public RandomListNode reconnectNodes(RandomListNode pHead){
		RandomListNode pNode = pHead;
		RandomListNode pCloneHead = null;
		RandomListNode pCloneNode = null;
		
		if(pNode != null){
			pCloneHead = pNode.next;
			pCloneNode = pNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		
		while(pNode != null){
			pCloneNode.next = pNode.next;
			pCloneNode = pCloneNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		
		return pCloneHead;
	}
	
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		n1.random = n3;
		n2.random = n4;
		
		RandomListNode root = new No25().Clone(n1);
		while(root != null){
			System.out.println(root.label);
			root = root.next;
		}
	}
}
