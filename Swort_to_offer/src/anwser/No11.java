package anwser;

public class No11 {
	public int NumberOf1(int n) {
		
		long start = System.currentTimeMillis();
		String binaryNum = Integer.toBinaryString(n);
		// System.out.println(binaryNum);

		int count = 0;
		String[] strs = binaryNum.split("");
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("1"))
				count++;
		}
		System.out.println(System.currentTimeMillis() - start);
		return count;
	}

	/**
	 * 还是位运算牛逼啊
	 * @param n
	 * @return
	 */
	public int NumberOf1_II(int n) {
		long start = System.currentTimeMillis();
		int flag = 1;
		int count = 0;
		for (int i = 0; i < 32; ++i) {
			if ((flag & n) != 0) {
				count++;
			}
			flag <<= 1;
		}
		System.out.println(System.currentTimeMillis() - start);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new No11().NumberOf1(15));

		System.out.println(new No11().NumberOf1_II(15));
	}
}
