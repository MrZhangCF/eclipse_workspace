package anwser;

import java.util.ArrayList;
import java.util.Iterator;

public class No24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	if(root == null)
    		return new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> path = new ArrayList<>();
    	
    	int currentSum = 0;
    	
    	findPath(root, target, arrayList, path, currentSum);
    	
    	return arrayList;
    }
    
    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> arrayList, ArrayList<Integer> path, int currentSum){
    	currentSum += root.val;
    	path.add(root.val);
    	
    	boolean isLeaf = ((root.left == null) && (root.right == null));
    	if(currentSum == target && isLeaf){
    		//这里为什么要新建变量？不懂
    		Iterator<Integer> iterator = path.iterator();
            ArrayList<Integer> pathTemp = new ArrayList<>();
            while (iterator.hasNext()) {
                pathTemp.add(iterator.next());
            }
            
            arrayList.add(pathTemp);
    	}
    	
    	if(root.left != null)
    		findPath(root.left, target, arrayList, path, currentSum);
    	if(root.right != null)
    		findPath(root.right, target, arrayList, path, currentSum);
    	
    	path.remove(path.size()-1);
    			
    }
}
