package anwser;

import java.util.ArrayList;

public class No13 {
	
	public boolean isOdd(int num){
		return num % 2 == 1 ? true:false;
	}
	
	public void reOrderArray(int[] array) {
		long start = System.currentTimeMillis();
		int[] odd = new int[array.length];
		int[] even = new int[array.length];
		int odd_index = 0;
		int even_index = 0;
		for (int i = 0; i < array.length; i++) {
			
			if(isOdd(array[i])){
				odd[odd_index] = array[i];
				odd_index++;
			}else{
				even[even_index] = array[i];
				even_index++;
			}
		}
		
		for(int j = 0;j<=even_index-1;j++){
			odd[odd_index+j] = even[j];
		}

		for (int i = 0; i < even.length; i++) {
			array[i] = odd[i];
		}
		System.out.println("I:"+ (System.currentTimeMillis() - start));
	}
	
	/**
	 * 使用链表的比较省时间
	 * @param array
	 */
	public void reOrderArray_II(int[] array){
		long start = System.currentTimeMillis();
		if(array != null && array.length > 1){
			ArrayList<Integer> odd = new ArrayList<>();
			ArrayList<Integer> even = new ArrayList<>();
			
			for (Integer integer : even) {
				if(integer % 2 ==1){
					odd.add(integer);
				}else{
					even.add(integer);
				}
			}
			
			int index = 0;
			
			for (int i = 0; i < odd.size(); i++) {
				array[index] = odd.get(i);
				index++;
			}
			
			for (int i = 0; i < even.size(); i++) {
				array[index] = even.get(i);
				index++;
			}
		}
		System.out.println("II:"+ (System.currentTimeMillis() - start));
	}
	
	public static void main(String[] args) {
		int[] array = new int[100000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		new No13().reOrderArray(array);
		new No13().reOrderArray_II(array);
//		for (int i : array) {
//			System.out.println(i);
//		}
	}
}
