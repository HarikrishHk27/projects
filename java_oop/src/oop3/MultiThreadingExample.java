package oop3;

class MyThread extends Thread {
	private String threadName;

	public MyThread(String name) {
		this.threadName = name;
	}

	public void run() {
		System.out.println(threadName + " is starting.");
		for (int i = 0; i < 5; i++) {
			System.out.println(threadName + " is counting: " + i);
			try {

				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(threadName + " is interrupted.");
			}
		}
		System.out.println(threadName + " has finished.");
	}
}

public class MultiThreadingExample {
	public static void main(String[] args) {

		MyThread thread1 = new MyThread("Thread 1");
		MyThread thread2 = new MyThread("Thread 2");
		thread1.start();
		thread2.start();

		System.out.println("Main thread is running.");
	}
}
