package offer;

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
 * @author zhangcf
 */

public class No1 {
	public static void main(String[] args) {
		int input[][] = {{1,4,7},{2,5,8},{3,6,9}};
		System.out.println(find(10,input));
		System.out.println(find(4,input));
	}
	
	/**
	 * �������Ϊ���½ǣ����С��������һ�У����������ÿ������һλ
	 * 
	 * ��Ѵ𰸡�
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
	 * ���ֲ��ң�����ɨ�裬��������ָ�룬����ֵ��Ϊ�ж�������С����ֵ����ָ�븳ֵ��ֵ��һ
	 * ����ʱ��ָ�븳ֵ��ֵ��һ
	 * 
	 * ���ַ���û��find�����ã���Ϊֻ�õ���ÿ�е������ԣ���û���õ�ÿ�е������ԣ�
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
