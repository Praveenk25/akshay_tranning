package com.intimetec.main;
import com.intimetec.interfaceOfRestaurentapp.IntimetecRestaurent;

public class Chef extends PrepareFood implements IntimetecRestaurent, Runnable {
	Order order = null;
	int flag = 0;

	public void run() {
		// System.out.println(Thread.currentThread().getName() + " is start");

		try {
			goWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void order() throws InterruptedException {

		// if (!Queue.orderqueue.isEmpty()) { // pulling the order object
		order = Queue.orderqueue.pollFirst();

		// }
		if (order != null) {
			prepareFood(order);
		}
		goWait();
	}

	public synchronized void goWait() throws InterruptedException {
		// System.out.println(Thread.currentThread().getName() + " is going to wait");
		flag = 0;
		wait();
		flag = 1;
		order();
	}

	public synchronized void giveNotify() {
		// System.out.println("notify");
		notify();
	}
}