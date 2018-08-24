package demo;

class ArrayShell {
	private long[] array;
	private int nElems;

	public ArrayShell(int maxSize) {
		array = new long[maxSize];
		nElems = 0;
	}

	public void insert(long value) {
		array[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public void shellSort() {
		int inner, outer;
		long temp;
		int h = 1;
		while (h <= nElems / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = array[outer];
				inner = outer;

				while (inner > h - 1 && array[inner - h] >= temp) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}

public class ShellSortTest {
	public static void main(String[] args) {
		int maxSize = 10;
		ArrayShell as = new ArrayShell(maxSize);
		
		for(int i=0;i<maxSize;i++){
			long n = (int)(Math.random()*99);
			as.insert(n);
		}
		
		as.display();
		as.shellSort();
		as.display();
	}
}
