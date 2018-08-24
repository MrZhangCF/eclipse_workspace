package anwser;

public class No9 {
	public int JumpFloorII(int target) {

		if (target == 0)
			return 0;
		if (target == 1)
			return 1;

		return 2 * JumpFloorII(target - 1);
	}
}
