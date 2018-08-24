package demo;
class ArrayIns{
	private long[] a;
	private int nElems;
	
	public ArrayIns(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public void Insert(int value){
		a[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int i =0;i < nElems;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public void insertSort(){
		int in,out;
		for(out=1;out<nElems;out++){
			long temp = a[out];
			in = out;
			while(in > 0 && a[in - 1] >= temp){
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
	}
}
public class InsertSort {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);
		
		arr.Insert(77);
		arr.Insert(99);
		arr.Insert(44);
		arr.Insert(55);
		arr.Insert(22);
		arr.Insert(88);
		arr.Insert(11);
		arr.Insert(00);
		arr.Insert(66);
		arr.Insert(33);
		
		arr.display();
		
		arr.insertSort();
		
		arr.display();
	}
}
