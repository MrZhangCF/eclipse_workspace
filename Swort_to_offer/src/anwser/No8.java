package anwser;

public class No8 {
	public int JumpFloor(int target) {
		
		if(target <= 0)
			return 0;
		
		if(target == 1)
			return 1;
		
		int first = 1;
		int second = 0;
		
		while(target > 0){
			first = first + second;
			second = first - second;
			target--;
		}
		
		return first;
	}
}
