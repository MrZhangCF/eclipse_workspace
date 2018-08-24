package cn.zhangcf.demo;

public class QuickSort {
	public static void main(String[] args) {
		int s[] = new int[] { 6, 1, 2, 5, 9, 4, 7, 10, 8, 3 };
		int t[] = new int[] { 72, 6, 57, 88, 56, 42, 83, 73, 48, 85 };

		quickSort(t, 0, t.length-1);
		for (int x = 0; x < t.length; x++) {
			System.out.print(t[x] + " ");
		}
	}

	public static void quickSort(int s[], int l, int r) {
		if (l < r) {
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x)
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x)
					i++;
				if (i < j) {
					s[j--] = s[i];
				}
			}
			s[i] = x;
			quickSort(s, l, i - 1);
			quickSort(s, i + 1, r);
		}
	}
}
