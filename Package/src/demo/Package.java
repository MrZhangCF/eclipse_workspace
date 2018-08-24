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
	 * 枚举法暴力求解背包问题：即列举出所有的排列组合，加起来比较权重和容量
	 * 
	 * @param m
	 *            背包的最大容量
	 * @param A
	 *            体积向量
	 * @param V
	 *            价值向量
	 * @return 最大价值
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
	 * 0/1背包问题：每个物品只有一件，状态为取或者不取 实现的关键是列出状态转移方程，根据状态转移方程来更新计算。
	 * 
	 * @param m
	 *            背包的总容量
	 * @param A
	 *            体积向量
	 * @param V
	 *            价值向量
	 * @return 最大价值
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
	 * 0/1背包问题：由于上面的算法中只使用到了两个数组，即：bp[i][j] 和 bp[i - 1][j] 所以这里用滚动数组来进行优化
	 * 
	 * @param m
	 *            背包的总容量
	 * @param A
	 *            体积向量
	 * @param V
	 *            价值向量
	 * @return 最大价值
	 */
	public int backpack3(int m, int[] A, int[] V) {
		int n = A.length;
		int[][] bp = new int[2][m + 1];
		int now = 0;
		for (int i = 1; i <= n; ++i) {
			now ^= 1; // 滚动数组
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
	 * 0/1背包问题：接着对上面的算法进行优化，优化的点在于将原来的二维数组改成一一维数组
	 * 此外，还需要对j层循环进行逆序处理，这样的用处是为了防止同一件物品多次放入背包。
	 * 
	 * @param m
	 *            背包的容量
	 * @param A
	 *            体积向量
	 * @param V
	 *            价值向量
	 * @return 最大价值
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
