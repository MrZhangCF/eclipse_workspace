package test;

public class TestDemo {
	public static void main(String[] args) {
		
		//0/1背包样例；
		
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
		
		//多重背包样例；
		int m2 = 8;
		int [] prices = {3,2};
		int [] weights = {300,160};
		int [] amounts = {1,6};
		//System.out.println(backPackV(m2, prices, weights, amounts));
	}
	
	/**
	 * 0/1背包问题：每件商品只有一件，1代表取走，0代表不取；背包容量为m，物件中类为A，对应价值为V；
	 * @param m 背包容量
	 * @param A 物件种类
	 * @param V 每件物品对应的价值
	 * @return 不大于背包容量下的最大价值。
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
	 * 0/1背包问题：每件商品只有一件，1代表取走，0代表不取；背包容量为m，物件中类为A，对应价值为V；
	 * @param m 背包容量
	 * @param A 物件种类
	 * @param V 每件物品对应的价值
	 * @return 不大于背包容量下的最大价值。
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
	 * 0/1背包问题：每件商品只有一件，1代表取走，0代表不取；背包容量为m，物件中类为A，对应价值为V；把每件商品看作
	 * 不同的商品即可转化为0/1背包问题；
	 * @param m 背包容量
	 * @param A 物件种类
	 * @param V 每件物品对应的价值
	 * @return 不大于背包容量情况下的最大价值。
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
	 * 多重背包问题，即每件商品有多件，m表示背包容量，prices表示每种商品对应的价格，weights表示
	 * 每件商品的权重，amount表示每件商品的数量。
	 * @param m 背包容量
	 * @param prices 每件商品对应的价格
	 * @param weights 对件商品对应的权重
	 * @param amount 每件商品的数量
	 * @return 不大于背包容量的情况下的最大权重。
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
	 * 完全背包问题，即每件商品的数量无上限，背包容量为m，A表示每件商品的体积，V表示每件商品的价值。
	 * 解题思路：每件商品的上限虽然没有限制，但是由于背包容量的限制，所以每件商品的数量上限为m/A【[i]
	 * 		     这就转化为了多重背包问题。
	 * @param m 背包容量
	 * @param A 每件商品的体积
	 * @param V 每件商品的价值
	 * @return 不超过背包容量下的最大价值。
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
	 * 完全背包问题，即每件商品的数量无上限，背包容量为m，A表示每件商品的体积，V表示每件商品的价值。
	 * 解题思路：每件商品的上限虽然没有限制，但是由于背包容量的限制，所以每件商品的数量上限为m/A【[i]
	 * 		     这就转化为了多重背包问题。
	 * @param m 背包容量
	 * @param A 每件商品的体积
	 * @param V 每件商品的价值
	 * @return 不超过背包容量下的最大价值。
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
