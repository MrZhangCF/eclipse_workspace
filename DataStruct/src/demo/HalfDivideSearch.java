package demo;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 二分查找的递归实现
 * @author zhangcf
 *
 */
public class HalfDivideSearch {
	public static void main(String[] args) {
		int [] whiteList = In.readInts(args[0]);

		Arrays.sort(whiteList);
		int [] testList = In.readInts(args[1]);
//		while(!StdIn.isEmpty()){
//			int key = StdIn.readInt();
//			System.out.println(key);
//			if(rank(key, whiteList) < 0){
//				//StdOut.print(key);
//				System.out.println(key);
//			}
//		}

		for(int x = 0; x < testList.length; x ++){
			//System.out.println(testList[x]);
			if(rank(testList[x], whiteList) < 0){
				System.out.println(testList[x]);
			}
		}
	}

	public static int rank(int key, int[] a){
		int lo = 0;
		int hi = a.length -1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
}
