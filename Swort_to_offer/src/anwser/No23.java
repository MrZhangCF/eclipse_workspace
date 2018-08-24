package anwser;

import java.util.Arrays;

public class No23 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		
		if(sequence == null || sequence.length == 0)
			return false;
		
		int root = sequence[sequence.length -1];
		
		int i = 0;
		for(;i<sequence.length;++i){
			if(sequence[i]>root)
				break;
		}
		
		int j = i;
		for(;j<sequence.length-1;++j){
			if(sequence[j] <root)
				return false;
		}
		
		boolean left = true;
		
		if(i>0){
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		}
		
		boolean right = true;
		
		if(i<sequence.length -1){
			right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
		}
		
		return left & right;
	}
}
