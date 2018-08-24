package anwser;

public class No26 {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return pRootOfTree;
		TreeNode pLastOfList = new TreeNode(0);
		pLastOfList = convertNode(pRootOfTree, pLastOfList);

		TreeNode pHeadOfList = pLastOfList;

		while (pLastOfList != null && pHeadOfList.left != null)
			pHeadOfList = pHeadOfList.left;

		pHeadOfList = pHeadOfList.right;
		pHeadOfList.left = null;

		return pHeadOfList;
	}

	private TreeNode convertNode(TreeNode pRootOfTree, TreeNode pLastOfList) {
		if (pRootOfTree == null)
			return pRootOfTree;
		TreeNode currentNode = pRootOfTree;
		if (currentNode.left != null)
			pLastOfList = convertNode(currentNode.left, pLastOfList);
		currentNode.left = pLastOfList;
		if (pLastOfList != null)
			pLastOfList.right = currentNode;
		pLastOfList = currentNode;
		if (currentNode.right != null)
			pLastOfList = convertNode(currentNode.right, pLastOfList);
		return pLastOfList;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n4.left = n2;
		n4.right = n6;
		n2.left = n1;
		n2.right = n3;

		n6.left = n5;
		n6.right = n7;

		TreeNode root = new No26().Convert(n4);

		TreeNode right = root;
		
		while (root != null) {
			System.out.print(root.val + "->");
			right = root;
			root = root.right;
		}
		
		System.out.println();
		
		while (right != null) {
			System.out.print(right.val + "->");
			right = right.left;
		}
	}
}
