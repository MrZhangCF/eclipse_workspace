package demo;

/**
 * �ڵ��࣬ÿ���ڵ������Ϊһ����������
 * 
 * @author zhangcf
 */
class Node {
	private int data;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.println("data is " + data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

/**
 * �������࣬�������ɶ����������Զ��������в���ڵ㣬ɾ���ڵ㣬��������Ȳ�����
 * 
 * @author zhangcf
 */
class Tree {
	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current.getData() != key) {
			if (key < current.getData()) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	/**
	 * �����µĽڵ㣬С�ķ���ߣ���ķ��ұߣ�
	 * 
	 * @param data
	 *            �½ڵ������
	 */
	public void insert(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent = null;
			while (true) {
				parent = current;
				if (data < current.getData()) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * �������������
	 */
	public void inMidOrder() {
		this.inMidOrder(this.root);
	}

	private void inMidOrder(Node localRoot) {
		if (localRoot != null) {
			inMidOrder(localRoot.leftChild);
			System.out.print(localRoot.getData() + " ");
			inMidOrder(localRoot.rightChild);
		}

	}

	/**
	 * ɾ���ڵ㣺�������������ɾ��Ҷ�ӽڵ㡢ɾ��ֻ��һ���ӽڵ�Ľڵ㡢ɾ�����������ӽڵ�Ľڵ㣻
	 * @param data
	 * @return
	 */
	public boolean delete(int data) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.getData() != data) {
			parent = current;
			if (data < current.getData()) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;
		}
		
		//ɾ��Ҷ�ӽڵ�
		if(current.leftChild == null && current.rightChild == null){
			if(current == root)
				root = null;
			else if(isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		//ɾ����һ���ӽڵ�Ľڵ�
		else if(current.rightChild == null){
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		else if(current.leftChild == null){
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		
		//ɾ���������ӽڵ�Ľڵ�
		else{
			Node successor = getSuccessor(current);
			
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node delNode){
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * ���Ҷ���������Сֵ
	 * 
	 * @return ������Сֵ
	 */
	public int mininum() {
		Node current, last = null;
		current = this.root;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.getData();
	}

	/**
	 * ���Ҷ����������ֵ
	 * 
	 * @return �������ֵ
	 */
	public int max() {
		Node current, last = null;
		current = this.root;
		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last.getData();
	}
}

public class BinaryTree {
	public static void main(String[] args) {

		Tree tree = new Tree();
		Tree tree2 = new Tree();

		tree.insert(63);
		tree.insert(47);
		tree.insert(22);
		tree.insert(11);
		tree.insert(33);
		tree.insert(17);
		tree.insert(53);
		tree.insert(50);
		tree.insert(60);
		tree.insert(49);
		tree.insert(51);
		tree.insert(71);
		tree.insert(67);

		tree2.insert(11);
		tree2.insert(17);
		tree2.insert(53);
		tree2.insert(60);
		tree2.insert(47);
		tree2.insert(63);
		tree2.insert(51);
		tree2.insert(50);
		tree2.insert(33);
		tree2.insert(49);
		tree2.insert(22);
		tree2.insert(67);
		tree2.insert(71);

		Node found = tree.find(25);

		if (found != null) {
			System.out.println("Found the node with key 25");
		} else {
			System.out.println("Could not find node with key 25");
		}

		tree.inMidOrder();
		System.out.println("");
		tree2.inMidOrder();
		System.out.println("");

		System.out.println(tree.max());
		System.out.println(tree.mininum());
	}
}
