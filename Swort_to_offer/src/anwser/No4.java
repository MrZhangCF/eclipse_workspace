package anwser;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class No4 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		TreeNode root = new TreeNode(pre[0]);
		int length = pre.length;
		int index = 0;
		// 检查中序输出中根节点的位置。
		for (int i = 0; i < length; ++i) {
			if (root.val == in[i]) {
				index = i;
				break;
			}
		}

		// 构建左子树
		if (index > 0) {

			int[] pre_left = new int[index];
			int[] in_left = new int[index];
			for (int j = 0; j < index; ++j) {
				pre_left[j] = pre[j + 1];
				in_left[j] = in[j];
			}

			root.left = reConstructBinaryTree(pre_left, in_left);
		} else {
			root.left = null;
		}

		// 构建右子树
		if (index < length - 1) {
			int right = length-index-1;
			int[] pre_right = new int[right];
			int[] in_right = new int[right];
			for(int j=index+1;j<right;++j){
				pre_right[j-index-1] = pre[j];
				in_right[j-index-1] = in[j];
			}
			root.right = reConstructBinaryTree(pre_right, in_right);
		}

		return root;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		TreeNode tn = new No4().reConstructBinaryTree(pre, in);
	}
}
