package demo;

class SingleLink {
	public int iData;
	public double dData;
	public SingleLink next;

	public SingleLink(int a, double b) {
		this.iData = a;
		this.dData = b;
	}

	public void display() {
		System.out.print("{" + iData + ", " + dData + "} ");
	}
}

class LinkList {

	private SingleLink first;

	public LinkList() {
		this.first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public SingleLink find(int key){
		SingleLink current = first;
		while(current.iData != key){
			if(current.next == null){
				return null;
			}else{
				current = current.next;
			}
		}
		return current;
	}
	
	public void insertFirst(int iData, double dData) {
		SingleLink sl = new SingleLink(iData, dData);
		sl.next = first;
		first = sl;
	}
	
	public SingleLink delete(int key){
		SingleLink current = first;
		SingleLink previous = first;
		while(current.iData != key){
			if(current.next == null)
				return null;
			else{
				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
		
	}
	
	public SingleLink deleteFirst(){
		SingleLink temp = first;
		first = first.next;
		return temp;
	}

	public void dispalyList() {
		System.out.println("List (first-->last): ");
		SingleLink current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("");
	}
}

public class SingleListTest {
	public static void main(String[] args) {
		LinkList list = new LinkList();

		list.insertFirst(22, 2.99);
		list.insertFirst(44, 4.99);
		list.insertFirst(66, 6.99);
		list.insertFirst(88, 8.99);
		list.insertFirst(99, 9.99);

		list.dispalyList();

		while (!list.isEmpty()) {
			SingleLink sl = list.deleteFirst();
			System.out.print("Deleted ");
			sl.display();
			System.out.println("");
		}
		list.dispalyList();
	}
}
