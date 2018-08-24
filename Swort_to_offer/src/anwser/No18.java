package anwser;

public class No18 {
	public void Mirror(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)){
			return;
		}
		
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
		
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null)
			Mirror(root.right);
		
	}
}
