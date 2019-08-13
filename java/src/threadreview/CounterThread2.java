package threadreview;

public class CounterThread2 extends Thread {
	Counter counter;

	public CounterThread2(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.incr();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int num = 1000;
		Counter counter = new Counter();
		Thread[] threads = new Thread[num];
		for (int i = 0; i < num; i++) {
			threads[i] = new CounterThread2(counter);
			threads[i].start();
		}
		for (int i = 0; i < num; i++) {
			threads[i].join();
		}
		System.out.println(counter.getCount());
	}

}
