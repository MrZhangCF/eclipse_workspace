package offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author zhangcf
 */

public class No1 {
	public static void main(String[] args) {
		int input[][] = {{1,4,7},{2,5,8},{3,6,9}};
		System.out.println(find(10,input));
		System.out.println(find(4,input));
	}
	
	/**
	 * 设置起点为左下角，如果小于则上移一行，如果大于则每次右移一位
	 * 
	 * 最佳答案。
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean find(int target, int[][] array){
		int rows = array.length;
		int cols = array[0].length;
		for(int x = rows-1,y = 0;x>=0&&y<cols;){
			if(target == array[x][y])
				return true;
			if(target < array[x][y]){
				x--;
				continue;
			}
			if(target > array[x][y]){
				y++;
				continue;
			}
			
		}
		return false;
	}
	
	/**
	 * 二分查找，逐行扫描，定义左右指针，以中值作为判断条件，小于中值是右指针赋值中值减一
	 * 大于时左指针赋值中值加一
	 * 
	 * 这种方法没有find方法好，因为只用到了每行的有序性，而没有用到每列的有序性；
	 * @param target
	 * @param array
	 * @return
	 */
	public static boolean find2(int target, int [][]array){
		for(int x=0;x<array.length;x++){
			int low = 0,high = array[x].length - 1;
			while(low<=high){
				int mid = (low+high)/2;
				if(target > array[x][mid]){
					low = mid+1;
				}
				else if(target < array[x][mid])
					high = mid-1;
				else
					return true;
			}
		}
		return false;
	}
}
