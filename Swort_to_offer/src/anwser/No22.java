package anwser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No22 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.peek();
			queue.remove();

			result.add(temp.val);

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

		return result;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		
		ArrayList<Integer> list = new No22().PrintFromTopToBottom(n1);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
