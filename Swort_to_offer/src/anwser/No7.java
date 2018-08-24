package anwser;

public class No7 {
	public int Fibonacci(int n) {
		
		if(n<=0)
			return 0;
		if(n == 1)
			return 1;
		
		int one = 1;
		int two = 0;
		while(n>1){
			one = one + two;
			two = one - two;
			n--;
		}
		
		return one;
	}
}
