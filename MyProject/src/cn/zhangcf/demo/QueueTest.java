package cn.zhangcf.demo;

class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int size) {
		maxSize = size;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(long j) {
		if (rear == maxSize - 1)
			rear = -1;
		queArray[++rear] = j;
		nItems++;
	}

	public long remove() {
		long temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int Size() {
		return nItems;
	}
}

public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);

		queue.remove();
		queue.remove();
		queue.remove();

		queue.insert(50);
		queue.insert(60);
		queue.insert(70);
		queue.insert(80);
		queue.insert(90);

		System.out.println(queue.Size());
		
		while (!queue.isEmpty()) {
			long n = queue.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
