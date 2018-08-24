package anwser;

public class No12 {
	public double Power(double base, int exponent) {
		if (exponent == 0)
			return 1;
		double result = 1;
		int absExponent = Math.abs(exponent);
		while (absExponent > 0) {
			result *= base;
			absExponent--;
		}

		if (exponent > 0) {
			return result;
		} else {
			return 1 / result;
		}

	}
}
