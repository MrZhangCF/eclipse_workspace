package anwser;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();

		System.out.println('a'>'b');

		String[] names = { "Alice", "Bob", "Cathy", "Dave" };

		if (n == 0)
			return;
		
		if(n < 4){
			System.out.println(names[(int) (n-1)]);
			return ;
		}
		double index = 0;
		
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			double head = Math.pow(2, i + 2) - 4;
			double end = Math.pow(2, i + 3) - 4;
			if (n > head && n < end) {
				index = (n - head) / Math.pow(2, i);
				System.out.println(names[(int) index]);
				return ;
			}
			if(n == head || n == end){
				System.out.println(names[3]);
				return ;
			}
			
		}
		

	}
}
