package mapper;

public class TestDemo {
	public static TestDemo SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("Yes, i am still alive...");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		TestDemo.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new TestDemo();

		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead :(");
		}

		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead :(");
		}
	}
}
