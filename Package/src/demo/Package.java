package demo;

public class Package {
	public static void main(String[] args) {
		Package test = new Package();
		int m = 100;
		int[] A = { 77, 22, 29, 50, 99 };
		int[] V = { 92, 22, 87, 46, 90 };
		System.out.println(test.backpack1(m, A, V));
		System.out.println(test.backpack2(m, A, V));
		System.out.println(test.backpack3(m, A, V));
		System.out.println(test.backpack4(m, A, V));
	}

	/**
	 * ö�ٷ�������ⱳ�����⣺���оٳ����е�������ϣ��������Ƚ�Ȩ�غ�����
	 * 
	 * @param m
	 *            �������������
	 * @param A
	 *            �������
	 * @param V
	 *            ��ֵ����
	 * @return ����ֵ
	 */
	public int backpack1(int m, int[] A, int[] V) {
		int n = A.length;
		int lim = 1 << n;
		int ans = 0;
		for (int s = 0; s < lim; ++s) {
			int tA = 0, tV = 0;
			for (int j = 0; j < n; ++j) {
				if ((s >> j) % 2 == 1) {
					tA += A[j];
					tV += V[j];
				}
			}
			if (tA <= m && tV > ans) {
				ans = tV;
			}
		}
		return ans;
	}

	/**
	 * 0/1�������⣺ÿ����Ʒֻ��һ����״̬Ϊȡ���߲�ȡ ʵ�ֵĹؼ����г�״̬ת�Ʒ��̣�����״̬ת�Ʒ��������¼��㡣
	 * 
	 * @param m
	 *            ������������
	 * @param A
	 *            �������
	 * @param V
	 *            ��ֵ����
	 * @return ����ֵ
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public int backpack2(int m, int[] A, int[] V) {
		int n = A.length;
		int[][] bp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				bp[i][j] = bp[i - 1][j];
				if (j >= A[i - 1]) {
					bp[i][j] = Math.max(bp[i][j], bp[i - 1][j - A[i - 1]] + V[i - 1]);
				}
			}
		}
		return bp[n][m];
	}

	/**
	 * 0/1�������⣺����������㷨��ֻʹ�õ����������飬����bp[i][j] �� bp[i - 1][j] ���������ù��������������Ż�
	 * 
	 * @param m
	 *            ������������
	 * @param A
	 *            �������
	 * @param V
	 *            ��ֵ����
	 * @return ����ֵ
	 */
	public int backpack3(int m, int[] A, int[] V) {
		int n = A.length;
		int[][] bp = new int[2][m + 1];
		int now = 0;
		for (int i = 1; i <= n; ++i) {
			now ^= 1; // ��������
			for (int j = 0; j <= m; ++j) {
				bp[now][j] = bp[now ^ 1][j];
				if (j >= A[i - 1]) {
					bp[now][j] = Math.max(bp[now][j], bp[now ^ 1][j - A[i - 1]] + V[i - 1]);
				}
			}
		}
		return bp[now][m];
	}

	/**
	 * 0/1�������⣺���Ŷ�������㷨�����Ż����Ż��ĵ����ڽ�ԭ���Ķ�ά����ĳ�һһά����
	 * ���⣬����Ҫ��j��ѭ�������������������ô���Ϊ�˷�ֹͬһ����Ʒ��η��뱳����
	 * 
	 * @param m
	 *            ����������
	 * @param A
	 *            �������
	 * @param V
	 *            ��ֵ����
	 * @return ����ֵ
	 */
	public int backpack4(int m, int[] A, int[] V) {
		int n = A.length;
		int[] f = new int[m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = m; j >= A[i - 1]; --j) {
				f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
			}
		}
		return f[m];
	}
	
	
}
