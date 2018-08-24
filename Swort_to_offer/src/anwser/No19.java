package anwser;

import java.util.ArrayList;

public class No19 {
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			return new ArrayList<Integer>();

		ArrayList<Integer> result = new ArrayList<Integer>();
		int start = 0;
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		while (numRow > 2 * start && numCol > 2 * start) {
			PrintMatrixInCircle(matrix, numRow, numCol, start, result);
			start++;
		}
		return result;

	}

	private void PrintMatrixInCircle(int[][] matrix, int numRow, int numCol, int start, ArrayList<Integer> result) {
		int endX = numCol-1-start;
	       int endY = numRow-1-start;
	       // �����Ҵ�ӡһ��
	       for (int i=start; i<=endX; ++i) {
	           result.add(matrix[start][i]);
	       }
	       // ���ϵ��´�ӡһ��
	       if (start < endY) {
	           for (int i=start+1; i<=endY; i++) {
	               result.add(matrix[i][endX]);
	           }
	       }
	       // ���ҵ����ӡһ��
	       if (start<endX && start<endY) {
	           for (int i=endX-1; i>=start; i--) {
	               result.add(matrix[endY][i]);
	           }
	       }
	       // ���µ��ϴ�ӡһ��
	       if (start<endX && start<endY-1) {
	           for(int i=endY-1; i>=start+1; i--) {
	               result.add(matrix[i][start]);
	           }
	       }

	}
}
