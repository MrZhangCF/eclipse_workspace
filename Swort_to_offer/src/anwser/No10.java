package anwser;

public class No10 {
	public int RectCover(int target) {

		if (target <= 0)
			return 0;
		if (target <= 2)
			return target;
		int first = 2;
		int second = 1;
		while (target > 2) {
			first = first + second;
			second = first - second;
			target--;
		}
		return first;
	}
}
