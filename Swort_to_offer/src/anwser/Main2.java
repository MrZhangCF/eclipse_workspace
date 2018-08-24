package anwser;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[] classes = new String[M];
		for (int l = 0; l < M; l++) {
			classes[l] = sc.nextLine();
			//System.out.println(classes[i]);
		}
		
		
		for (int i = 0; i < N; i++) {
			int flag = 0;
			for (int k = 0; k < N; k++) {
				int count = 0;
				if (i != k) {
					for (int j = 0; j < M; j++) {

						if (classes[j].toCharArray()[i] < classes[j].toCharArray()[k]) {
							count++;
						} else {
							count--;
						}

					}
				}
				if (count > 0) {
					flag++;
				} else {
					break;
				}
			}
			if (flag == N - 1) {
				System.out.println(i);
				return;
			}
		}
	}
}
