package demo;

import java.util.Scanner;

public class Netease1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jobNum = sc.nextInt();
		int personNum = sc.nextInt();

		int diff[] = new int[jobNum];
		int salery[] = new int[jobNum];

		int all[] = new int[2 * jobNum];

		for (int x = 0; x < 2 * jobNum; x++) {
			all[x] = sc.nextInt();
		}
		for (int x = 0; x < jobNum; x++) {
			diff[x] = all[2 * x];
			salery[x] = all[2 * x + 1];
		}
		int total[] = new int[personNum];

		for (int x = 0; x < personNum; x++) {
			total[x] = sc.nextInt();
		}
		
		for(int x=0;x<personNum;x++){
			int min = 1000000001;
			int index = 0;
			int minus = 0;
			for(int y=0;y<jobNum;y++){
				minus = total[x]-diff[y];
				if(minus>=0 && minus<min){
					min = minus;
					index=y;
				}
			}
			System.out.println(salery[index]);
		}
	}
}
