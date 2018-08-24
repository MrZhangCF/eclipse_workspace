package cn.zhangcf.demo;

class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;

	public PriorityQueue(int s) {
		this.maxSize = s;
		this.queueArray = new long[maxSize];
		this.nItems = 0;
	}

	public void insert(long item) {
		int j;
		if (nItems == 0) {
			queueArray[nItems++] = item;
		} else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queueArray[j])
					queueArray[j + 1] = queueArray[j];
				else {
					break;
				}
			}
			queueArray[j + 1] = item;
			nItems++;
		}
	}

	public long remove() {
		return queueArray[--nItems];
	}

	public long peekMin() {
		return queueArray[nItems - 1];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}
}

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);

		queue.insert(30);
		queue.insert(50);
		queue.insert(10);
		queue.insert(40);
		queue.insert(20);

		while (!queue.isEmpty()) {
			long item = queue.remove();
			System.out.print(item + " ");
		}
		System.out.println("");
	}
}
