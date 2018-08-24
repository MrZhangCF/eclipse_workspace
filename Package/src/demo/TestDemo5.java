package demo;
class Test5{
	private Integer value;

	public Integer getValue() {
		System.out.println(this.value);
		return value;
		
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
public class TestDemo5 {
	public static void main(String[] args) {
		Test5 test = new Test5();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.setValue(10);
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.getValue();
			}
		});
		
		
		thread2.start();
		thread1.start();
	}
}
