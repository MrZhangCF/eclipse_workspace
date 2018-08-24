package test;

public class TestDemo {
	public static void main(String[] args) {
		
		//0/1����������
		
		int m = 100;
		int[] A = { 77, 22, 29, 50, 99 };
		int[] V = { 92, 22, 87, 46, 90 };
		backPackII(m, A, V);
		// System.out.println(backPackII(m, A, V));
		// System.out.println(backPackIII(m, A, V));
		int m1 = 10;
		int[] A1 = { 2, 3, 5, 7 };
		int[] V1 = { 1, 5, 2, 4 };
		// backPackIII(m1, A1, V1);
		//System.out.println(backPackIV(m1, A1, V1));
		
		//���ر���������
		int m2 = 8;
		int [] prices = {3,2};
		int [] weights = {300,160};
		int [] amounts = {1,6};
		//System.out.println(backPackV(m2, prices, weights, amounts));
	}
	
	/**
	 * 0/1�������⣺ÿ����Ʒֻ��һ����1����ȡ�ߣ�0����ȡ����������Ϊm���������ΪA����Ӧ��ֵΪV��
	 * @param m ��������
	 * @param A �������
	 * @param V ÿ����Ʒ��Ӧ�ļ�ֵ
	 * @return �����ڱ��������µ�����ֵ��
	 */
	public static int backPackII(int m, int[] A, int[] V) {
		int n = A.length;
		int lim = 1 << n;
		int ans = 0;
		for (int s = 0; s < lim; ++s) {
			int tA = 0, tV = 0;
			System.out.print("s= " + s + " ");
			for (int j = 0; j < n; ++j) {
				if ((s >> j) % 2 == 1) {
					System.out.print("A[" + j + "]" + " ");
					tA += A[j];
					tV += V[j];
				}
			}
			System.out.println("");
			if (tA <= m && tV > ans) {
				ans = tV;
			}
		}
		return ans;
	}

	/**
	 * 0/1�������⣺ÿ����Ʒֻ��һ����1����ȡ�ߣ�0����ȡ����������Ϊm���������ΪA����Ӧ��ֵΪV��
	 * @param m ��������
	 * @param A �������
	 * @param V ÿ����Ʒ��Ӧ�ļ�ֵ
	 * @return �����ڱ��������µ�����ֵ��
	 */
	public static int backPackIII(int m, int[] A, int[] V) {
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
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				System.out.print(bp[i][j] + " ");
			}
			System.out.println("");
		}
		return bp[n][m];
	}

	/**
	 * 0/1�������⣺ÿ����Ʒֻ��һ����1����ȡ�ߣ�0����ȡ����������Ϊm���������ΪA����Ӧ��ֵΪV����ÿ����Ʒ����
	 * ��ͬ����Ʒ����ת��Ϊ0/1�������⣻
	 * @param m ��������
	 * @param A �������
	 * @param V ÿ����Ʒ��Ӧ�ļ�ֵ
	 * @return �����ڱ�����������µ�����ֵ��
	 */
	public static int backPackIV(int m, int[] A, int[] V) {
		int n = A.length;
		int[] f = new int[m + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = m; j >= A[i]; --j) {
				f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
			}
		}
		for(int i=0;i<=m;i++){
			System.out.print(f[i]);
		}
		System.out.println("");
		return f[m];
	}
	
	/**
	 * ���ر������⣬��ÿ����Ʒ�ж����m��ʾ����������prices��ʾÿ����Ʒ��Ӧ�ļ۸�weights��ʾ
	 * ÿ����Ʒ��Ȩ�أ�amount��ʾÿ����Ʒ��������
	 * @param m ��������
	 * @param prices ÿ����Ʒ��Ӧ�ļ۸�
	 * @param weights �Լ���Ʒ��Ӧ��Ȩ��
	 * @param amount ÿ����Ʒ������
	 * @return �����ڱ�������������µ����Ȩ�ء�
	 */
	public static int backPackV(int m,int[] prices,int[] weights,int[] amount){
		int n = prices.length;
		int [] f = new int [m+1];
		for(int i=1;i<=n;++i){
			for(int k=1;k<=amount[i-1];++k){
				for(int j=m;j>=prices[i-1];--j){
					f[j] = Math.max(f[j], f[j-prices[i-1]] + weights[i-1]);
				}
			}
		}
		return f[m];
	}
	
	/**
	 * ��ȫ�������⣬��ÿ����Ʒ�����������ޣ���������Ϊm��A��ʾÿ����Ʒ�������V��ʾÿ����Ʒ�ļ�ֵ��
	 * ����˼·��ÿ����Ʒ��������Ȼû�����ƣ��������ڱ������������ƣ�����ÿ����Ʒ����������Ϊm/A��[i]
	 * 		     ���ת��Ϊ�˶��ر������⡣
	 * @param m ��������
	 * @param A ÿ����Ʒ�����
	 * @param V ÿ����Ʒ�ļ�ֵ
	 * @return ���������������µ�����ֵ��
	 */
	public static int backPackVI(int m,int [] A,int[] V){
		int n = A.length;

		int f[] = new int[m+1];
		for(int i=1;i<=n;++i){
			for(int k=1;k<=m/A[i-1];++k){
				for(int j=m;j>=A[i-1];--j){
					f[j] = Math.max(f[j], f[j-A[i-1]] + V[i-1]);
				}
			}
		}
		return f[m];
	}
	
	/**
	 * ��ȫ�������⣬��ÿ����Ʒ�����������ޣ���������Ϊm��A��ʾÿ����Ʒ�������V��ʾÿ����Ʒ�ļ�ֵ��
	 * ����˼·��ÿ����Ʒ��������Ȼû�����ƣ��������ڱ������������ƣ�����ÿ����Ʒ����������Ϊm/A��[i]
	 * 		     ���ת��Ϊ�˶��ر������⡣
	 * @param m ��������
	 * @param A ÿ����Ʒ�����
	 * @param V ÿ����Ʒ�ļ�ֵ
	 * @return ���������������µ�����ֵ��
	 */
	public static int backPackVII(int m,int [] A,int[] V){
		int n = A.length;

		int f[] = new int[m+1];
		for(int i=1;i<=n;++i){
			for(int k=1;k<=m/A[i-1];++k){
				for(int j=A[i-1];j<=m;++j){
					f[j] = Math.max(f[j], f[j-A[i-1]] + V[i-1]);
				}
			}
		}
		return f[m];
	}
}
